package com.simplilearn.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId")
	private User user;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "purchaseOrder_Shoes",
            joinColumns = {@JoinColumn(name = "purchaseOrderId", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "shoeId", referencedColumnName = "id", nullable = false)})
	private List<SportShoes> shoes = new ArrayList<SportShoes>();
	
	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Date purchaseDate;
	private double billedAmount;

	public PurchaseOrder(User user, List<SportShoes> shoes, Date purchaseDate, double billedAmount) {
		super();
		this.user = user;
		this.shoes = shoes;
		this.purchaseDate = purchaseDate;
		this.billedAmount = billedAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setShoes(List<SportShoes> shoes) {
		this.shoes = shoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<SportShoes> getShoes() {
		return shoes;
	}

	public void setShoesIds(List<SportShoes> shoes) {
		this.shoes = shoes;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getBilledAmount() {
		return billedAmount;
	}

	public void setBilledAmount(double billedAmount) {
		this.billedAmount = billedAmount;
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
		PurchaseOrder other = (PurchaseOrder) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", user=" + user + ", shoes=" + shoes + ", dateOfPurchase=" + purchaseDate
				+ ", billedAmount=" + billedAmount + "]";
	}
}
