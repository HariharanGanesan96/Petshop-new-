package Class;

import java.util.Date;
import java.util.Objects;

public class Animals {

	private int animalId;
	private String type;
	private String name;
	private String gender;
	private String dob;
	private String dsc;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	private String color;
	private String image;
	private double price;
	private String status;
	private int cusId;
	private int adminId;
	private Date regDate;

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Animals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Animals(int animalId) {
		super();
		this.animalId = animalId;
	}

	public Animals(int animalId, String status) {
		super();
		this.animalId = animalId;
		this.status = status;
	}

	public Animals(int animalId, String type, String name, String gender, String dob, String dsc, String color,
			double price, String status, int cusId) {
		super();
		this.animalId = animalId;
		this.type = type;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.dsc = dsc;
		this.color = color;
		this.price = price;
		this.status = status;
		this.cusId = cusId;
	}
	public Animals(int animalId, String type, String name, String gender, String dob, String dsc, String color,
			double price, int cusId) {
		super();
		this.animalId = animalId;
		this.type = type;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.dsc = dsc;
		this.color = color;
		this.price = price;
		this.cusId = cusId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(animalId, color, cusId, dob, dsc, gender, name, price, regDate, status, type);
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
		return animalId == other.animalId && Objects.equals(color, other.color) && cusId == other.cusId
				&& Objects.equals(dob, other.dob) && Objects.equals(dsc, other.dsc)
				&& Objects.equals(gender, other.gender) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(regDate, other.regDate) && Objects.equals(status, other.status)
				&& Objects.equals(type, other.type);
	}


}
