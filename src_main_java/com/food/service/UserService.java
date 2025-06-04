package com.food.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.food.model.UserModel;
import com.food.repo.UserRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    private String generateOTP() {
        return String.valueOf(new Random().nextInt(900000) + 100000);
    }

    public void sendOtpToEmail(String email) {
        String otp = generateOTP();
        Timestamp expiry = Timestamp.from(Instant.now().plusSeconds(300)); // ✅ Set expiry time (5 minutes)
        Timestamp recentLogin = new Timestamp(System.currentTimeMillis()); // Current timestamp for recent login
        UserModel user = userRepository.findByEmail(email).orElse(new UserModel());
        
        
        user.setEmail(email);
        user.setOtp(otp);
        user.setOtpExpiry(expiry);
        user.setRecentLogin(recentLogin); // Set the recent login timestamp
        userRepository.save(user);

        try {
			sendEmail(email, "Your OTP", "Your OTP is: " + otp);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public boolean verifyOtp(String email, String otp) {
        Optional<UserModel> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            UserModel user = userOpt.get();
            Timestamp currentTimestamp = Timestamp.from(Instant.now());

            // ✅ Check if OTP matches and is not expired
            if (user.getOtp().equals(otp) && currentTimestamp.before(user.getOtpExpiry())) {
                return true;
            }
        }
        return false;
    }
   private void sendEmail(String to, String subject, String otp) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();      
        // Create a MimeMessageHelper to send an HTML email
        MimeMessageHelper helper = new MimeMessageHelper(message, true); // 'true' indicates multipart message      
        helper.setTo(to);  // recipient
        helper.setSubject(subject);  // subject of the email    
        // HTML content (OTP with styling)
        String htmlContent = "<html><body>"
                + "<h2 style='color:#4CAF50;'>Your OTP</h2>"
                + "<p style='font-size:16px;'>Dear User,</p>"
                + "<p style='font-size:16px;'>Your OTP IS: <strong style='color:#4CAF50; font-size:24px;'>" + otp + "</strong></p>"
                + "<p style='font-size:16px;'>This OTP is valid for 5 minutes.</p>"
                + "<p style='font-size:16px;'>If you did not request this OTP, please ignore this email.</p>"
                + "<br>"
                + "<footer><small style='font-size:12px; color:#888;'>Regards, <br>Spice Sprouts Team</small></footer>"
                + "</body></html>";    
        // Set the email content with HTML
        helper.setText(htmlContent, true);  // 'true' enables HTML content
        // Send the email
        mailSender.send(message);
    }
}