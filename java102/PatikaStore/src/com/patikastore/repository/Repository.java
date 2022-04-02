package com.patikastore.repository;

import java.util.ArrayList;
import java.util.List;

import com.patikastore.model.Entity;

public abstract class Repository<T extends Entity> {

	private List<T> entities;
	
	public Repository() {
		this.entities = new ArrayList<T>();
	}
	
	public List<? extends Entity> getAll() {
		return entities;
	}
	
	public T getById(int id) {
		for(T entity : entities) {
			if(entity.getId() == id) {
				return entity;
			}
		}
		return null;
	}
	
	public boolean add(T entity) {
		return this.entities.add(entity);
	}
	
	public boolean deleteById(int id) {
		T foundEntity = getById(id);
		return this.entities.remove(foundEntity);
	}
	
	public abstract void add();
	
	public abstract void printListInTable();
	
	public abstract void printListInTable(Iterable<? extends Entity> iterable);
}
