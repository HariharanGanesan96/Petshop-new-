package Class;

import java.util.Objects;

public class CartItems {
	@Override
	public int hashCode() {
		return Objects.hash(animalId, cusId, itemId, qty, totalPrice, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItems other = (CartItems) obj;
		return animalId == other.animalId && cusId == other.cusId && itemId == other.itemId && qty == other.qty
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Double.doubleToLongBits(unitPrice) == Double.doubleToLongBits(other.unitPrice);
	}

	private int itemId;
	private int animalId;
	private int cusId;
	private int qty;
	private double unitPrice;
	private double totalPrice;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
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

	public CartItems(int itemId, int animalId, int cusId, int qty, double unitPrice, double totalPrice) {
		super();
		this.itemId = itemId;
		this.animalId = animalId;
		this.cusId = cusId;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}

	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}

}
