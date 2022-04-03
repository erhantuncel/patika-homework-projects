package com.insurance.business;

import com.insurance.entites.abstracts.Address;
import com.insurance.entites.concretes.User;

public class AddressManager {

	public static boolean add(Address address, User user) {
		return user.getAddressList().add(address);
	}
	
	public static boolean remove(Address address, User user) {
		return user.getAddressList().remove(address);
	}
}
