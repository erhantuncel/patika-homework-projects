package com.patikastore.repository;

import java.util.ArrayList;
import java.util.List;

import com.patikastore.model.Brand;
import com.patikastore.model.Entity;
import com.patikastore.model.Product;

public abstract class ProductRepository<T extends Product> extends Repository<Entity> {	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		List<T> allProducts = new ArrayList<T>();
		for(Entity entity : super.getAll()) {
			allProducts.add((T) entity);
		}
		return allProducts; 
	}

	@SuppressWarnings("unchecked")
	public List<T> filterByBrand(Brand brand) {
		List<T> productListForBrand = new ArrayList<T>();
		for(Entity entity : getAll()) {
			T product = (T) entity;
			if(product.getBrand().equals(brand)) {
				productListForBrand.add((T) product);
			}
		}
		return productListForBrand;
	}
	
}
