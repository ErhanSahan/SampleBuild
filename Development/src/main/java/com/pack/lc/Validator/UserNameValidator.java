package com.pack.lc.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pack.lc.api.UserRegistrationDTO;

public class UserNameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "usernName.empty","User name can not be empty");
	
		String userName = ((UserRegistrationDTO)object).getUserName();
		if(userName!=null) {
			if(!userName.contains("_")) {
				errors.rejectValue("userName", "userName.invalidString","Username must contain _");
			}
		}
	}

}
