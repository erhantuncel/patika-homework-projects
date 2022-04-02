package com.patikastore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.patikastore.model.Brand;
import com.patikastore.model.MobilePhone;
import com.patikastore.model.Notebook;
import com.patikastore.repository.BrandRepository;
import com.patikastore.repository.MobilePhoneRepository;
import com.patikastore.repository.NotebookRepository;

public class Helper {
	
	public static final Scanner INPUT = new Scanner(System.in);

	private static final String BRANDS = "Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster";
	public static int PRODUCT_ID = 1;
	
	public static BrandRepository brandRepository = new BrandRepository();
	public static MobilePhoneRepository mobilePhoneRepository = new MobilePhoneRepository();
	public static NotebookRepository notebookRepository = new NotebookRepository();
	
	public static List<Brand> getBrandList() {
		String[] brandArray = BRANDS.split(", ");
		ArrayList<Brand> brandList = new ArrayList<Brand>();
		for(int i=0; i<brandArray.length; i++) {
			brandList.add(new Brand(i+1, brandArray[i]));
		}
		return brandList;
	}
	
	public static void populateBrandRepository() {
		String[] brandArray = BRANDS.split(", ");
		for(int i=0; i<brandArray.length; i++) {			
			brandRepository.add(new Brand(i+1, brandArray[i]));
		}
	}
	
	public static void populateMobilePhoneRepository() {
		mobilePhoneRepository.add(new MobilePhone("SAMSUNG GALAXY A51", 3199, 0, 100, 
				brandRepository.getById(1), 128, 6.5, 32, 4000, 6, "Black"));
		mobilePhoneRepository.add(new MobilePhone("iPhone 11 64 GB", 7379, 0, 50, 
				brandRepository.getById(3), 64, 6.1, 5, 3046, 6, "Blue"));
		mobilePhoneRepository.add(new MobilePhone("Redmi Note 10 Pro 8GB", 4012, 0, 150, 
				brandRepository.getById(8), 128, 6.5, 35, 4000, 12, "White"));
	}
	
	public static void populateNotebookRepository() {
		notebookRepository.add(new Notebook("HUAWEI Matebook 14", 7000, 0, 100, brandRepository.getById(4), 16, 512, 14));
		notebookRepository.add(new Notebook("LENOVO V14 IGL", 3699, 0, 10, brandRepository.getById(2), 8, 1024, 14));
		notebookRepository.add(new Notebook("ASUS Tuf Gaming", 8199, 0, 20, brandRepository.getById(6), 32, 2048, 15.6));
	}
	
	public static void printMenu(String menuTitle, String inputMessage, String... menuItems) {
		int maxLengthOfMenuItem = 0;
		for(String s : menuItems) {
			if(s.length() > maxLengthOfMenuItem) {
				maxLengthOfMenuItem = s.length();
			}
		}
		maxLengthOfMenuItem+=6;
		
		StringBuilder format = new StringBuilder();
		
		for(int i=1; i<=menuItems.length; i++) {
			format.append("%-" + maxLengthOfMenuItem + "s");
			if(i % 3 == 0) {
				format.append("\n");
			}
			menuItems[i-1] = "[" + i + "]-" + menuItems[i-1];
		}
		format.append("\n\n");
		if(menuTitle != null) {			
			System.out.println(menuTitle + "\n");
		}
		System.out.printf(format.toString(), (Object[]) menuItems);
		System.out.print(inputMessage + ": ");
	}
	
	public static void printLineOfCharacter(String character, int dashCount) {
		for(int i=0; i<dashCount; i++) {
			System.out.print(character);
		}
		System.out.println();
	}
	
	public static void printBanner() {
		System.out.println("\n  ____       _   _ _           ____  _                 \n"
				+ " |  _ \\ __ _| |_(_) | ____ _  / ___|| |_ ___  _ __ ___ \n"
				+ " | |_) / _` | __| | |/ / _` | \\___ \\| __/ _ \\| '__/ _ \\\n"
				+ " |  __/ (_| | |_| |   < (_| |  ___) | || (_) | | |  __/\n"
				+ " |_|   \\__,_|\\__|_|_|\\_\\__,_| |____/ \\__\\___/|_|  \\___|\n"
				+ "                                                       \n\n");
	}
}
