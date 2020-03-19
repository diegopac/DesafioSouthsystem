package com.desafio.persistencia;


/**
 * 
 * @author diego.pacheco
 *
 */
public class ItemVenda {
	
	private String id;
	private String quantity;
	private Double price;
	

	public ItemVenda(String id, String quantity, Double price) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
}
