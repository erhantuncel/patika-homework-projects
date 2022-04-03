package com.insurance.entites.concretes;

import com.insurance.entites.abstracts.Insurance;

public class CarInsurance extends Insurance {

	@Override
	public double calculate() {
		return 3000;
	}

}
