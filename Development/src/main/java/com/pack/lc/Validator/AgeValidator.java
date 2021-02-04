package com.pack.lc.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int lower;
	private int upper;
	@Override
	public void initialize(Age age) {
		this.lower=age.lower();
		this.upper=age.upper();
	}
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value== null) {
			return false;
		}
		if(value<18 || value>60) {
			return false;
		}
		return true;
	}

}
