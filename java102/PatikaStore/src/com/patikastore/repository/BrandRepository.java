package com.patikastore.repository;

import java.util.Iterator;
import java.util.TreeSet;

import com.patikastore.Helper;
import com.patikastore.model.Brand;
import com.patikastore.model.Entity;

public class BrandRepository extends Repository<Brand> {


	public TreeSet<Brand> getAllWithAlphabeticalOrder() {
		TreeSet<Brand> brandTreeSet = new TreeSet<Brand>();
		for(Entity entity : getAll()) {
			Brand brand = (Brand) entity;
			brandTreeSet.add(brand);
		}
		return brandTreeSet;
	}

	@Override
	public void printListInTable() {
		printListInTable(getAll());
	}
	
	public void printListInTableWithAlphabeticalOrder() {
		printListInTable(getAllWithAlphabeticalOrder());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void printListInTable(Iterable<? extends Entity> iterable) {
		int characterCountForLine = 21;
		System.out.println("Brands\n");
		Helper.printLineOfCharacter("-", characterCountForLine);
		System.out.printf("| %-4s | %-10s |\n", "ID", "Marka");
		Helper.printLineOfCharacter("-", characterCountForLine);
		Iterator<Brand> brandIterator = (Iterator<Brand>) iterable.iterator();
		while(brandIterator.hasNext()) {
			Brand brand = brandIterator.next();
			System.out.printf("| %-4s | %-10s |\n", brand.getId(), brand.getName());
		}
		Helper.printLineOfCharacter("-", characterCountForLine);
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}
}
