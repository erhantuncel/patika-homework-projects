package com.insurance.entites.concretes;

import com.insurance.entites.abstracts.Insurance;

public class TravelInsurance extends Insurance {

	@Override
	public double calculate() {
		return 200;
	}

}
