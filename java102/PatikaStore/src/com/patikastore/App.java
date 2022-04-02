package com.patikastore;

public class App { 
	
	public static void main(String[] args) {
		Helper.populateBrandRepository();
		Helper.populateMobilePhoneRepository();
		Helper.populateNotebookRepository();
		
		Store store = new Store();
		store.showMenu();
	}
}
