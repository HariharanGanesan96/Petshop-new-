package com.ABSClass;

import java.sql.Date;
import java.util.Objects;

public class Admin {
    private int adminId;
    private String userName;
    private String password;
    private int employeeId;
    private Date registerDate;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminId, employeeId, password, registerDate, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return adminId == other.adminId && employeeId == other.employeeId && Objects.equals(password, other.password)
				&& Objects.equals(registerDate, other.registerDate) && Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", employeeId="
				+ employeeId + ", registerDate=" + registerDate + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	public Admin(int adminId, String userName, String password, int employeeId) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.employeeId = employeeId;
	}
	public Admin(int adminId, String userName, String password, int employeeId, Date registerDate) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.employeeId = employeeId;
		this.registerDate = registerDate;
	}	
}
