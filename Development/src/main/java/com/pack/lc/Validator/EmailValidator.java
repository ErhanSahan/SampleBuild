package com.pack.lc.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pack.lc.api.UserRegistrationDTO;

@Component
public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"CommunicationDTO.email","email.empty");
		String email = ((UserRegistrationDTO)object).getCommunicationDTO().getEmail();

		if(!email.endsWith("@gmail.com")) {
			errors.rejectValue("CommunicationDTO.email", "email.invalidDomain");
		}
	}

}
