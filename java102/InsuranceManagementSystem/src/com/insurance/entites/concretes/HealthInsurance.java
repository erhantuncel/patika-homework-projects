package com.insurance.entites.concretes;

import com.insurance.entites.abstracts.Insurance;

public class HealthInsurance extends Insurance {

	@Override
	public double calculate() {
		return 2000;
	}

}
