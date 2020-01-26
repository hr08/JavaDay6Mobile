package com.robomq.pojo;

public class Mobile {
	private int id,quantity,price;
	private String name,desp;
	
	public Mobile()
	{
		
	}

	public Mobile(int id, int quantity, int price, String name, String desp) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.name = name;
		this.desp = desp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", quantity=" + quantity + ", price=" + price + ", name=" + name + ", desp=" + desp
				+ "]";
	}
	
	

}
