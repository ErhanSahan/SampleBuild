package com.pack.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import javax.print.attribute.standard.Copies;

import org.springframework.format.Formatter;

import com.pack.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone object, Locale locale) {

		return object.toString();
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {

		int index = completePhoneNumber.indexOf("-");
		String [] phoneNumberArray = completePhoneNumber.split("-");
		Phone phone = new Phone();
		if(index== -1) {
					phone.setCountryCode("90");
					phone.setUserNumber(phoneNumberArray[0]);
		}
		else {
					phone.setCountryCode(phoneNumberArray[0]);
					phone.setUserNumber(phoneNumberArray[1]);
		}

		
		return phone;
	}


}
