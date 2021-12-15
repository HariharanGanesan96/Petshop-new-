package com.ABSClass;

import java.sql.Date;
import java.util.Objects;

public class Customers {
	private int customerId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private long number;
	private long bank;
	private Date regDate;
	private String address;
	private int pincode;
	private String gender;
	private String image;
	
    
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public long getBank() {
		return bank;
	}
	public void setBank(long bank) {
		this.bank = bank;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, bank, customerId, email, firstName, gender, image, lastName, number, password,
				pincode, regDate, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return Objects.equals(address, other.address) && bank == other.bank && customerId == other.customerId
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(image, other.image)
				&& Objects.equals(lastName, other.lastName) && number == other.number
				&& Objects.equals(password, other.password) && pincode == other.pincode
				&& Objects.equals(regDate, other.regDate) && Objects.equals(userName, other.userName);
	}
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Customers(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public Customers(int customerId, long bank, String address, int pincode) {
		super();
		this.customerId = customerId;
		this.bank = bank;
		this.address = address;
		this.pincode = pincode;
	}
	public Customers( String firstName, String lastName, String userName, String password, String email,
			long number,String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.number = number;
		this.gender=gender;
	}
	public Customers(int customerId, String firstName, String lastName, String userName, String password, String email,
			long number, long bank, Date regDate, String address, int pincode, String gender, String image) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.number = number;
		this.bank = bank;
		this.regDate = regDate;
		this.address = address;
		this.pincode = pincode;
		this.gender = gender;
		this.image = image;
	}
		
	
	
	  
}
