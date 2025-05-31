package com.food.DTO;

import java.util.List;

public class PaymentRequest {
    private String userEmail;
    private String userName;
    private String userAddress;
    private String mobileNumber;
    private List<CartItem> cartItems; // Nested list for cart items
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
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public PaymentRequest(String userEmail, String userName, String userAddress, String mobileNumber,
			List<CartItem> cartItems) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userAddress = userAddress;
		this.mobileNumber = mobileNumber;
		this.cartItems = cartItems;
	}
	public PaymentRequest() {
		
	}
	

    // Getters and Setters
	
	
    
}
