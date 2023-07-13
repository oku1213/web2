package model;

import java.io.Serializable;

public class Vegetable implements Serializable {
	private String name;
	private int price;
	
	public Vegetable() {}
	public Vegetable(String name, int price) {
		this.name =name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}