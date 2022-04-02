package com.patikastore.repository;

import java.util.Iterator;

import com.patikastore.Helper;
import com.patikastore.model.Entity;
import com.patikastore.model.Notebook;

public class NotebookRepository extends ProductRepository<Notebook> {

	@Override
	public void add() {
		Notebook notebookToAdd = new Notebook(null, 0, 0, 0, null, 0, 0, 0);
		Helper.INPUT.nextLine();
		System.out.print("Enter name: ");
		notebookToAdd.setName(Helper.INPUT.nextLine());
		System.out.print("Enter unit price: ");
		notebookToAdd.setUnitPrice(Double.parseDouble(Helper.INPUT.nextLine()));
		System.out.print("Enter discount rate: ");
		notebookToAdd.setDiscountRate(Double.parseDouble(Helper.INPUT.nextLine()));
		System.out.print("Enter amount: ");
		notebookToAdd.setAmount(Integer.parseInt(Helper.INPUT.nextLine()));
		Helper.brandRepository.printListInTableWithAlphabeticalOrder();
		System.out.print("Enter brand id: ");
		notebookToAdd.setBrand(Helper.brandRepository.getById(Integer.parseInt(Helper.INPUT.nextLine())));
		System.out.print("Enter ram: ");
		notebookToAdd.setRam(Integer.parseInt(Helper.INPUT.nextLine()));
		System.out.println("Enter storage: ");
		notebookToAdd.setStorage(Integer.parseInt(Helper.INPUT.nextLine()));
		System.out.print("Enter scrren size: ");
		notebookToAdd.setScreenSize(Double.parseDouble(Helper.INPUT.nextLine()));
		
		add(notebookToAdd);
	}
	
	@Override
	public void printListInTable() {
		printListInTable(getAll());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void printListInTable(Iterable<? extends Entity> iterable) {
		int characterCountForLine = 85;
		System.out.println("NOTEBOOKS");
		Helper.printLineOfCharacter("-", characterCountForLine);
		System.out.printf("| %-2s | %-25s | %-7s | %-10s | %-8s | %-5s | %-6s |\n", 
							"ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Ram");
		Helper.printLineOfCharacter("-", characterCountForLine);
		Iterator<Notebook> notebookIterator = (Iterator<Notebook>) iterable.iterator();
		while(notebookIterator.hasNext()) {
			Notebook notebook = notebookIterator.next();
			System.out.printf("| %-2s | %-25s | %-7.1f | %-10s | %-8d | %-5.1f | %-6d |\n", 
					notebook.getId(), notebook.getName(), notebook.getUnitPrice(), notebook.getBrand().getName(), 
					notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
		}
		Helper.printLineOfCharacter("-", characterCountForLine);
	}
}
