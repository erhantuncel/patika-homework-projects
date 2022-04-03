package com.insurance.entites.abstracts;

import java.util.List;
import java.util.Objects;

import com.insurance.business.AddressManager;
import com.insurance.entites.concretes.AuthenticationStatus;
import com.insurance.entites.concretes.User;
import com.insurance.exceptions.InvalidAuthenticationStatus;

public abstract class Account implements Comparable<Account> {

	private User user;

	private AuthenticationStatus authenticationStatus;
	
	private List<Insurance> insuranceList;

	public Account(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AuthenticationStatus getAuthenticationStatus() {
		return authenticationStatus;
	}

	public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
		this.authenticationStatus = authenticationStatus;
	}

	public List<Insurance> getInsuranceList() {
		return insuranceList;
	}

	public void setInsuranceList(List<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(authenticationStatus, insuranceList, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return authenticationStatus == other.authenticationStatus && Objects.equals(insuranceList, other.insuranceList)
				&& Objects.equals(user, other.user);
	}

	public abstract boolean addInsurance(Insurance insurance);
	
	public final void showUserInfo() {
		System.out.println(user.getName() + " " + user.getSurname() + " - " + user.getEmail());
	}
	
	public boolean login(String email, String password) throws InvalidAuthenticationStatus {
		if(email.equals(user.getEmail()) && password.equals(user.getPassword())) {
			setAuthenticationStatus(AuthenticationStatus.SUCCESS);
			return true;
		} else {			
			setAuthenticationStatus(AuthenticationStatus.FAIL);
			throw new InvalidAuthenticationStatus("Invalid authentication.");
		}
	}
	
	public boolean addAddress(Address address) {
		return AddressManager.add(address, this.user);
	}
	
	public boolean removeAddress(Address address) {
		return AddressManager.remove(address, this.user);
	}
	
	public boolean isLoggedIn() {
		if(this.authenticationStatus.equals(AuthenticationStatus.SUCCESS)) {
			return true;
		}
		return false;
	}
}
