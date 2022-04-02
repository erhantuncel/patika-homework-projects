package com.patikastore;

import java.util.ArrayList;
import java.util.List;

import com.patikastore.model.Product;
import com.patikastore.repository.ProductRepository;


public class Store {
	
	public void showMenu() {
		while (true) {			
			if(!showMainMenu()) {
				break;
			}
		}
	}
	
	private boolean showMainMenu() {
		Helper.printBanner();
		Helper.printMenu("Product Categories", "Select product category",
				"Mobile Phones", "Notebooks", "Quit");
		int selectedMenu = Helper.INPUT.nextInt();
		if(selectedMenu != 3) {			
			ProductRepository<? extends Product> repository = null;
			switch (selectedMenu) {
			case 1: {
				repository = Helper.mobilePhoneRepository;
				break;
			}
			case 2: {
				repository = Helper.notebookRepository;
				break;
			}
			}
			return showProductInfo(repository);
		} else {
			System.out.println("\nYou have logged out of the system.");
			return false;
		}
	}
	
	private boolean showProductInfo(ProductRepository<? extends Product> repository) {
		List<Product> filteredList = new ArrayList<Product>();
		while(true) {	
			if(filteredList.size() > 0) {
				repository.printListInTable(filteredList);
			} else {				
				repository.printListInTable();
			}
			Helper.printMenu("Operations", "Enter operation", 
					"Add", "Delete By Id", "Filter By Id", "Filter By Brand", "Back to Main Menu");
			int selectedOperation = Helper.INPUT.nextInt();
			switch (selectedOperation) {
				case 1: {
					repository.add();
					continue;
				} 
				case 2: {
					System.out.print("Enter id to delete: ");
					int idToDelete = Helper.INPUT.nextInt();
					repository.deleteById(idToDelete);
					continue;
				}
				case 3: {
					System.out.print("Enter id to filter: ");
					int idToFilter = Helper.INPUT.nextInt();
					filteredList.add((Product) repository.getById(idToFilter));
					continue;
				}
				case 4: {
					Helper.brandRepository.printListInTableWithAlphabeticalOrder();
					System.out.print("Select brand id to filter: ");
					int brandIdToFilter = Helper.INPUT.nextInt();
					filteredList.addAll(repository.filterByBrand(Helper.brandRepository.getById(brandIdToFilter)));
					continue;
				}
				case 5: {
					return true;
				}
			}
			return false;
		}
	}
}
