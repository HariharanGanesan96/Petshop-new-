package Class;

import java.util.Objects;

public class Cart {
	@Override
	public int hashCode() {
		return Objects.hash(cartId, cusId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return cartId == other.cartId && cusId == other.cusId;
	}

	private int cartId;
	private int cusId;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public Cart(int cartId, int cusId) {
		super();
		this.cartId = cartId;
		this.cusId = cusId;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
}
