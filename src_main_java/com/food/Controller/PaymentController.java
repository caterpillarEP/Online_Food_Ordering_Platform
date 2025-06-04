package com.food.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.DTO.PaymentRequest;
import com.food.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService; // Assume you have a service for DB operations

    @PostMapping("/save")
    public ResponseEntity<String> savePayment(@RequestBody PaymentRequest request) {
        paymentService.savePaymentDetails(request);
        return ResponseEntity.ok("Payment details saved successfully.");
    }
}
