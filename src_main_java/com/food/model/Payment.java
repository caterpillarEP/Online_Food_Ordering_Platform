package com.food.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail;
    private String userName;
    private String userAddress;
    private String mobileNumber;
    @Column(columnDefinition = "TEXT") // Store cart as JSON
    private String cartItems;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}
	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the cartItems
	 */
	public String getCartItems() {
		return cartItems;
	}
	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(String cartItems) {
		this.cartItems = cartItems;
	}
	public Payment(Long id, String userEmail, String userName, String userAddress, String mobileNumber,
			String cartItems) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userAddress = userAddress;
		this.mobileNumber = mobileNumber;
		this.cartItems = cartItems;
	}
	public Payment(String userEmail, String userName, String userAddress, String mobileNumber, String cartItems) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userAddress = userAddress;
		this.mobileNumber = mobileNumber;
		this.cartItems = cartItems;
	}
	public Payment() {		
	}
    // Getters and Setters  
    
}

