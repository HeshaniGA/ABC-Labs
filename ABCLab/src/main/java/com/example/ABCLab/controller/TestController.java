package com.example.ABCLab.controller;

import com.example.ABCLab.model.Test;
import com.example.ABCLab.model.TestState;
import com.example.ABCLab.service.CustomUserDetail;
import com.example.ABCLab.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

@Controller
@RequestMapping("/tests")
public class TestController {

    public static final String UPLOAD_FOLDER = "src/main/resources/static/uploaded/";

    private final TestService testService;
    private final UserDetailsService userDetailsService;
    private final ResourceLoader resourceLoader;

    @Autowired
    public TestController(TestService testService, UserDetailsService userDetailsService, ResourceLoader resourceLoader) {
        this.testService = testService;
        this.userDetailsService = userDetailsService;
        this.resourceLoader = resourceLoader;
    }

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private String savePrescriptionFile(MultipartFile prescriptionFile) {
        if (prescriptionFile.isEmpty()) {
            return "error";
        }
    
        try {
            // Create the 'static/uploaded' directory if it doesn't exist
            File saveFile = new ClassPathResource("static/uploaded").getFile();
            if (!saveFile.exists()) {
                if (saveFile.mkdirs()) {
                    logger.info("Directory created: {}", saveFile.getAbsolutePath());
                } else {
                    logger.error("Failed to create directory: {}", saveFile.getAbsolutePath());
                    return "error";
                }
            }
    
            // Save the file
            Path path = Paths.get(saveFile.getAbsolutePath(), prescriptionFile.getOriginalFilename());
            Files.copy(prescriptionFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    
            logger.info("File uploaded successfully: {}", path);
            return prescriptionFile.getOriginalFilename();
        } catch (Exception e) {
            logger.error("Error uploading file", e);
            return "error";
        }
    }

    @GetMapping("/tech/all")
    public String getAllTests(Model model) {
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        return "tech/alltests";
    }

    @GetMapping("/add")
    public String getAddTestPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userid", ((CustomUserDetail) userDetails).getId());
        model.addAttribute("username", ((CustomUserDetail) userDetails).getFullname());

        model.addAttribute("test", new Test());
        return "tests/addtest";
    }

    @PostMapping("/add")
    public String addTest(@ModelAttribute("test") Test test,
                         @RequestParam("prescriptionFile") MultipartFile prescriptionFile) {
        String prescriptionFileName = savePrescriptionFile(prescriptionFile);
        test.setPrescriptionFileName(prescriptionFileName);

        testService.saveTest(test);
        return "tests/addtest";
    }
    @GetMapping("/user-tests")
    public String getUserTests(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        Long userId=((CustomUserDetail) userDetails).getId();
      
        List<Test> userTests = testService.getTestByPatientId(userId);
        model.addAttribute("userTests", userTests);
    
        return "tests/alltests";
}

@PostMapping("/updateState/{id}")
public String updateTestState(@PathVariable Long id, @RequestParam String state) {
    // Convert the string to TestState enum
    TestState newState = TestState.valueOf(state);

    // Call the service method to update the state
    testService.updateTestStateById(id, newState);

    // Redirect to the "/tests/all" endpoint
    return "redirect:/tests/all";
}

}