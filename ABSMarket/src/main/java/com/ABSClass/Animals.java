package com.ABSClass;

import java.sql.Date;
import java.util.Objects;

public class Animals {
	private int animalId;
	private String animalType;
	private String animalName;
	private String animalGender;
	private Date dobDate;
	private String description;
	private double price;
	private String animalColor;
	private String animalImage;
	private String status;
	private int customerId;
	private int adminId;
	private Date regDate;
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getAnimalGender() {
		return animalGender;
	}
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	public Date getDobDate() {
		return dobDate;
	}
	public void setDobDate(Date dobDate) {
		this.dobDate = dobDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAnimalColor() {
		return animalColor;
	}
	public void setAnimalColor(String animalColor) {
		this.animalColor = animalColor;
	}
	public String getAnimalImage() {
		return animalImage;
	}
	public void setAnimalImage(String animalImage) {
		this.animalImage = animalImage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminId, animalColor, animalGender, animalId, animalImage, animalName, animalType,
				customerId, description, dobDate, price, regDate, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animals other = (Animals) obj;
		return adminId == other.adminId && Objects.equals(animalColor, other.animalColor)
				&& Objects.equals(animalGender, other.animalGender) && animalId == other.animalId
				&& Objects.equals(animalImage, other.animalImage) && Objects.equals(animalName, other.animalName)
				&& Objects.equals(animalType, other.animalType) && customerId == other.customerId
				&& Objects.equals(description, other.description) && Objects.equals(dobDate, other.dobDate)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(regDate, other.regDate) && Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "Animals [animalId=" + animalId + ", animalType=" + animalType + ", animalName=" + animalName
				+ ", animalGender=" + animalGender + ", dobDate=" + dobDate + ", description=" + description
				+ ", price=" + price + ", animalColor=" + animalColor + ", animalImage=" + animalImage + ", status="
				+ status + ", customerId=" + customerId + ", adminId=" + adminId + ", regDate=" + regDate + "]";
	}
	public Animals() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animals(int animalId, String status, int adminId) {
		super();
		this.animalId = animalId;
		this.status = status;
		this.adminId = adminId;
	}
	public Animals(String animalType, String animalName, String animalGender, Date dobDate, String description,
			double price, String animalColor, int customerId) {
		super();
		this.animalType = animalType;
		this.animalName = animalName;
		this.animalGender = animalGender;
		this.dobDate = dobDate;
		this.description = description;
		this.price = price;
		this.animalColor = animalColor;
		this.customerId = customerId;
	}
	public Animals(int animalId, String animalType, String animalName, String animalGender, Date dobDate,
			String description, double price, String animalColor, int customerId) {
		super();
		this.animalId = animalId;
		this.animalType = animalType;
		this.animalName = animalName;
		this.animalGender = animalGender;
		this.dobDate = dobDate;
		this.description = description;
		this.price = price;
		this.animalColor = animalColor;
		this.customerId = customerId;
	}
	public Animals(int animalId, String animalType, String animalName, String animalGender, Date dobDate,
			String description, double price, String animalColor, String animalImage, String status, int customerId,
			int adminId, Date regDate) {
		super();
		this.animalId = animalId;
		this.animalType = animalType;
		this.animalName = animalName;
		this.animalGender = animalGender;
		this.dobDate = dobDate;
		this.description = description;
		this.price = price;
		this.animalColor = animalColor;
		this.animalImage = animalImage;
		this.status = status;
		this.customerId = customerId;
		this.adminId = adminId;
		this.regDate = regDate;
	}
	
}
