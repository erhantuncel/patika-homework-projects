package com.patikastore.model;

import java.util.Objects;

public class Brand extends Entity implements Comparable<Brand> {
	
	private String name;

	public Brand(int id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
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
		Brand other = (Brand) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Brand o) {
		return this.name.compareTo(o.name);
	}
}
