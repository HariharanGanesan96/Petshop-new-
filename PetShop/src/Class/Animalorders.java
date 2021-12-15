package Class;

import java.util.Date;
import java.util.Objects;

public class Animalorders {
	private int orderId;
	private int cusId;
	private String date;
	private double Price;
	private String status;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Animalorders(int orderId, int cusId, String date, double price, String status) {
		super();
		this.orderId = orderId;
		this.cusId = cusId;
		this.date = date;
		Price = price;
		this.status = status;
	}

	public Animalorders(int orderId, int cusId, String date, double price) {
		super();
		this.orderId = orderId;
		this.cusId = cusId;
		this.date = date;
		this.Price = price;

	}

	public Animalorders() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	@Override
	public int hashCode() {
		return Objects.hash(Price, cusId, date, orderId, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animalorders other = (Animalorders) obj;
		return Double.doubleToLongBits(Price) == Double.doubleToLongBits(other.Price) && cusId == other.cusId
				&& Objects.equals(date, other.date) && orderId == other.orderId && Objects.equals(status, other.status);
	}
}
