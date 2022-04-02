package com.patikastore.model;

import java.util.Objects;

import com.patikastore.Helper;

public class Notebook extends Product {

	private int ram;
	private int storage;
	private double screenSize;

	public Notebook(String name, double unitPrice, double discountRate, int amount, Brand brand, int ram,
			int storage, double screenSize) {
		super(Helper.PRODUCT_ID, name, unitPrice, discountRate, amount, brand);
		this.ram = ram;
		this.storage = storage;
		this.screenSize = screenSize;
		Helper.PRODUCT_ID++;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ram, screenSize, storage);
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
		Notebook other = (Notebook) obj;
		return ram == other.ram && Double.doubleToLongBits(screenSize) == Double.doubleToLongBits(other.screenSize)
				&& storage == other.storage;
	}

	@Override
	public String toString() {
		return "Notebook [ram=" + ram + ", storage=" + storage + ", screenSize=" + screenSize + "]";
	}
	
	
}
