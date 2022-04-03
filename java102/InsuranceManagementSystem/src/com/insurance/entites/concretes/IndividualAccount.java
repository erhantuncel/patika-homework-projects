package com.insurance.entites.concretes;

import com.insurance.entites.abstracts.Account;
import com.insurance.entites.abstracts.Insurance;

public class IndividualAccount extends Account {
	
	public IndividualAccount(User user) {
		super(user);
	}

	@Override
	public boolean addInsurance(Insurance insurance) {
		double priceWithProfit = insurance.getPrice() * (1 + 0.05);
		insurance.setPrice(priceWithProfit);
		return getInsuranceList().add(insurance);
	}

	@Override
	public int compareTo(Account o) {
		return o.getUser().getName().compareTo(getUser().getName());
	}

}
