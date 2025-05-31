package com.food.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.service.UserService;

@CrossOrigin(origins = "*")  // Allow requests from any origin
@RestController
@RequestMapping("/index")
public class AuthController {
  
	@Autowired
	UserService userservice;
	
	
	@PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp (@RequestParam String email) {
        userservice.sendOtpToEmail(email);
        return ResponseEntity.ok("OTP sent to " + email);
    }
	
	@PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        if (userservice.verifyOtp(email, otp)) {
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
    }
	
}