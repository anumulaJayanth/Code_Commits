package com.simplilearn.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SportShoes {

	@Id
	@GeneratedValue
	private int id;
	private String shoetype;
	private String gender;
	private double size;
	private String color;
	private double price;
//	private boolean isInInventory;
	
	@ManyToMany(mappedBy = "shoes", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<PurchaseOrder> purchaseOrder = new ArrayList<PurchaseOrder>();

	public SportShoes() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public SportShoes(String shoetype, String gender, double size, String color, double price, boolean isInInventory) {
	public SportShoes(String shoetype, String gender, double size, String color, double price) {
		super();
		this.shoetype = shoetype;
		this.gender = gender;
		this.size = size;
		this.color = color;
		this.price = price;
//		this.isInInventory = isInInventory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShoetype() {
		return shoetype;
	}

	public void setShoetype(String shoetype) {
		this.shoetype = shoetype;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
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

	
	public List<PurchaseOrder> getPurchaseOrder() {
		return purchaseOrder;
	}
	
//	public boolean isInInventory() {
//		return isInInventory;
//	}
//
//	public void setInInventory(boolean isInInventory) {
//		this.isInInventory = isInInventory;
//	}

	public void setPurchaseOrder(List<PurchaseOrder> purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SportShoes other = (SportShoes) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Shoes [id=" + id + ", shoetype=" + shoetype + ", gender=" + gender + ", size=" + size + ", color="
				+ color + "]";
	}
	
}
