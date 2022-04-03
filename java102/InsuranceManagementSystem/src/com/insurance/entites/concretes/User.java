package com.insurance.entites.concretes;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.insurance.entites.abstracts.Address;

public class User {

	private String name;
	private String surname;
	private String email;
	private String password;
	private String job;
	private List<Address> addressList;
	private Date lastLoginDate;

	
	public User(String name, String surname, String email, String password, String job) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressList, email, job, lastLoginDate, name, password, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(addressList, other.addressList) && Objects.equals(email, other.email)
				&& Objects.equals(job, other.job) && Objects.equals(lastLoginDate, other.lastLoginDate)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(surname, other.surname);
	}
}
