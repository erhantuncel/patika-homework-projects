package com.insurance.entites.concretes;

import com.insurance.entites.abstracts.Insurance;

public class ResidenceInsurance extends Insurance {

	@Override
	public double calculate() {
		return 700;
	}

}
