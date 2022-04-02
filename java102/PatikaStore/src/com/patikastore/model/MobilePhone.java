package com.patikastore.model;

import java.util.Objects;

import com.patikastore.Helper;

public class MobilePhone extends Product {

	private int memory;
	private double screenSize;
	private int cameraResolution;
	private int batteryPower;
	private int ram;
	private String color;

	public MobilePhone(String name, double unitPrice, double discountRate, int amount, Brand brand, int memory,
			double screenSize, int cameraResolution, int batteryPower, int ram, String color) {
		super(Helper.PRODUCT_ID, name, unitPrice, discountRate, amount, brand);
		this.memory = memory;
		this.screenSize = screenSize;
		this.cameraResolution = cameraResolution;
		this.batteryPower = batteryPower;
		this.ram = ram;
		this.color = color;
		Helper.PRODUCT_ID++;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public int getCameraResolution() {
		return cameraResolution;
	}

	public void setCameraResolution(int cameraResolution) {
		this.cameraResolution = cameraResolution;
	}

	public int getBatteryPower() {
		return batteryPower;
	}

	public void setBatteryPower(int batteryPower) {
		this.batteryPower = batteryPower;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(batteryPower, cameraResolution, color, memory, ram, screenSize);
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
		MobilePhone other = (MobilePhone) obj;
		return batteryPower == other.batteryPower && cameraResolution == other.cameraResolution
				&& Objects.equals(color, other.color) && memory == other.memory && ram == other.ram
				&& Double.doubleToLongBits(screenSize) == Double.doubleToLongBits(other.screenSize);
	}

	@Override
	public String toString() {
		return "MobilePhone [memory=" + memory + ", screenSize=" + screenSize + ", batteryPower=" + batteryPower
				+ ", ram=" + ram + ", color=" + color + "]";
	}
}
