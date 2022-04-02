package com.patikastore.repository;

import java.util.Iterator;

import com.patikastore.Helper;
import com.patikastore.model.Entity;
import com.patikastore.model.MobilePhone;

public class MobilePhoneRepository extends ProductRepository<MobilePhone> {
	
	public void add() {
		MobilePhone mobilePhoneToAdd = new MobilePhone(null, 0, 0, 0, null, 0, 0, 0, 0, 0, null);
		Helper.INPUT.nextLine();
		System.out.print("Enter name: ");
		mobilePhoneToAdd.setName(Helper.INPUT.nextLine());
		System.out.print("Enter unit price: ");
		mobilePhoneToAdd.setUnitPrice(Double.parseDouble(Helper.INPUT.nextLine()));
		System.out.print("Enter discount rate: ");
		mobilePhoneToAdd.setDiscountRate(Double.parseDouble(Helper.INPUT.nextLine()));
		System.out.print("Enter amount: ");
		mobilePhoneToAdd.setAmount(Integer.parseInt(Helper.INPUT.nextLine()));
		Helper.brandRepository.printListInTableWithAlphabeticalOrder();
		System.out.print("Enter brand id: ");
		mobilePhoneToAdd.setBrand(Helper.brandRepository.getById(Integer.parseInt(Helper.INPUT.nextLine())));
		System.out.print("Enter memory: ");
		mobilePhoneToAdd.setMemory(Integer.parseInt(Helper.INPUT.nextLine()));
		System.out.print("Enter scrren size: ");
		mobilePhoneToAdd.setScreenSize(Double.parseDouble(Helper.INPUT.nextLine()));
		System.out.print("Enter camera resolution: ");
		mobilePhoneToAdd.setCameraResolution(Integer.parseInt(Helper.INPUT.nextLine()));
		System.out.print("Enter battery power: ");
		mobilePhoneToAdd.setBatteryPower(Integer.parseInt(Helper.INPUT.nextLine()));
		System.out.print("Enter ram: ");
		mobilePhoneToAdd.setRam(Integer.parseInt(Helper.INPUT.nextLine()));
		System.out.print("Enter color: ");
		mobilePhoneToAdd.setColor(Helper.INPUT.nextLine());
		
		add(mobilePhoneToAdd);
	}

	@Override
	public void printListInTable() {
		printListInTable(getAll());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void printListInTable(Iterable<? extends Entity> iterable) {
		int characterCountForLine = 114;
		System.out.println("MOBILE PHONES");
		Helper.printLineOfCharacter("-", characterCountForLine);
		System.out.printf("| %-2s | %-25s | %-10s | %-7s | %-7s | %-7s | %-7s | %-7s | %-6s | %-5s |\n", 
							"ID", "Product Name", "Unit Price", "Brand", "Storage", "Display", "Camera", "Battery", "Ram", "Color");
		Helper.printLineOfCharacter("-", characterCountForLine);
		Iterator<MobilePhone> mobilePhoneIterator = (Iterator<MobilePhone>) iterable.iterator();
		while(mobilePhoneIterator.hasNext()) {
			MobilePhone phone = mobilePhoneIterator.next();
			System.out.printf("| %-2s | %-25s | %-10.1f | %-7s | %-7d | %-7.1f | %-7d | %-7d | %-6d | %-5s |\n", 
					phone.getId(), phone.getName(), phone.getUnitPrice(), phone.getBrand().getName(), 
					phone.getMemory(), phone.getScreenSize(), phone.getCameraResolution(), phone.getBatteryPower(), 
					phone.getRam(), phone.getColor());
		}
		Helper.printLineOfCharacter("-", characterCountForLine);
	}

}
