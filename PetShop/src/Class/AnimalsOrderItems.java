package Class;

import java.util.Objects;

public class AnimalsOrderItems {
	@Override
	public int hashCode() {
		return Objects.hash(animalId, itemId, orderId, qty, totalPrice, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimalsOrderItems other = (AnimalsOrderItems) obj;
		return animalId == other.animalId && itemId == other.itemId && orderId == other.orderId && qty == other.qty
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Double.doubleToLongBits(unitPrice) == Double.doubleToLongBits(other.unitPrice);
	}

	private int itemId;
	private int orderId;
	private int animalId;
	private int qty;
	private double unitPrice;
	private double totalPrice;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public AnimalsOrderItems(int itemId, int orderId, int animalId, int qty, double unitPrice, double totalPrice) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
		this.animalId = animalId;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}

	public AnimalsOrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public AnimalsOrderItems(int itemId, int qty) {
		super();
		this.itemId = itemId;
		this.qty = qty;
	}

	public int getQty() {
		return qty;
	}
    
	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
