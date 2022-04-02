package com.patikastore.model;

import java.util.Objects;

public abstract class Product extends Entity {
	
	private String name;
	private double unitPrice;
	private double discountRate;
	private int amount;
	private Brand brand;

	public Product(int id, String name, double unitPrice, double discountRate, int amount, Brand brand) {
		super(id);
		this.name = name;
		this.unitPrice = unitPrice;
		this.discountRate = discountRate;
		this.amount = amount;
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(amount, brand, discountRate, name, unitPrice);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return amount == other.amount && Objects.equals(brand, other.brand)
				&& Double.doubleToLongBits(discountRate) == Double.doubleToLongBits(other.discountRate)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(unitPrice) == Double.doubleToLongBits(other.unitPrice);
	}
}
