package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.DTO.PaymentRequest;
import com.food.model.Payment;
import com.food.repo.PaymentRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository; // Assume you have a JPA repository

    @Autowired
    private JavaMailSender mailSender;

    public void savePaymentDetails(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setUserEmail(request.getUserEmail());
        payment.setUserName(request.getUserName());
        payment.setUserAddress(request.getUserAddress());
        payment.setMobileNumber(request.getMobileNumber());
        
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payment.setCartItems(objectMapper.writeValueAsString(request.getCartItems()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        paymentRepository.save(payment);

        // After saving the payment, send a confirmation email
        sendConfirmationEmail(payment);
    }

    private void sendConfirmationEmail(Payment payment) {
        String to = payment.getUserEmail();
        String subject = "Order Confirmation - Your Order Has Been Received to US !";
        
        String emailContent = "<html><body>"
                + "<h2 style='color:#4CAF50;'>Order Confirmation</h2>"
                + "<p style='font-size:16px;'>Dear " + payment.getUserName() + ",</p>"
                + "<p style='font-size:16px;'>Thank you for your order. We have successfully Order Details.</p>"
                + "<h3>Order Details</h3>"
                + "<p><strong>Order ID:</strong> " + payment.getId() + "</p>"
                + "<p><strong>User Name:</strong> " + payment.getUserName() + "</p>"
                + "<p><strong>Shipping Address:</strong> " + payment.getUserAddress() + "</p>"
                + "<p><strong>Mobile Number:</strong> " + payment.getMobileNumber() + "</p>"
                + "<p><strong>Items Ordered:</strong><br>" + payment.getCartItems() + "</p>"
                + "<br><p>Your order will be processed shortly and you will receive an update once it's shipped.</p>"
                + "<p>Thank you for choosing our service!</p>"
                + "<footer><small style='font-size:12px; color:#888;'>Regards, <br>Spice Sprouts Team</small></footer>"
                + "</body></html>";

        sendEmail(to, subject, emailContent);
    }
    private void sendEmail(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // 'true' enables multipart message
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true); // Enable HTML content
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
