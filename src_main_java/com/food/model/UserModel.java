package com.food.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class UserModel {

	@Id
    private String email;
    private String otp;
    private Timestamp otpExpiry;
   

    @Column(name = "recent_login")  // Map the field to the 'recent_login' column in the DB
    private Timestamp recentLogin;  // Field to store recent login timestamp
    
    // getters and setters 
    
    
	/**
	 * @return the recentLogin
	 */
	public Timestamp getRecentLogin() {
		return recentLogin;
	}
	/**
	 * @param recentLogin the recentLogin to set
	 */
	public void setRecentLogin(Timestamp recentLogin) {
		this.recentLogin = recentLogin;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the otp
	 */
	public String getOtp() {
		return otp;
	}
	/**
	 * @param otp the otp to set
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}
	/**
	 * @return the otpExpiry
	 */
	
	/**
	 * @param otpExpiry the otpExpiry to set
	 */
	
	public UserModel(String email, String otp, Timestamp otpExpiry) {
		super();
		this.email = email;
		this.otp = otp;
		this.otpExpiry = otpExpiry;
	}
	public UserModel(String otp, Timestamp otpExpiry) {
		super();
		this.otp = otp;
		this.otpExpiry = otpExpiry;
	}
	
	public UserModel() {
		
	}
	public Timestamp getOtpExpiry() {
		return otpExpiry;
	}
	public void setOtpExpiry(Timestamp otpExpiry) {
		this.otpExpiry = otpExpiry;
	}
	public UserModel(String email, String otp, Timestamp otpExpiry, Timestamp recentLogin) {
		super();
		this.email = email;
		this.otp = otp;
		this.otpExpiry = otpExpiry;
		this.recentLogin = recentLogin;
	}
	

	
    
}
