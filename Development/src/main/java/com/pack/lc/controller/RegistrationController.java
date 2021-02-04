package com.pack.lc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.lc.Validator.EmailValidator;
import com.pack.lc.Validator.UserNameValidator;
import com.pack.lc.api.CommunicationDTO;
import com.pack.lc.api.Phone;
import com.pack.lc.api.UserInfoDTO;
import com.pack.lc.api.UserRegistrationDTO;
import com.pack.lc.propertyeditor.NamePropertyEditor;

@Controller
public class RegistrationController {

	// autoviderd yaptık emailide component
	@Autowired
	private EmailValidator validator;
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("regInfoDTO") UserRegistrationDTO userRegistrationDTO) {
		
		//load the saved user data from db
		
		Phone phone = new Phone();
		phone.setCountryCode("90");
		phone.setUserNumber("2233445566");
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);		
		userRegistrationDTO.setCommunicationDTO(communicationDTO);
		
		return "user-registration-page";
	}
	
	@RequestMapping("/registration-success")
	public String processUserReg(@Valid@ModelAttribute("regInfoDTO") UserRegistrationDTO userRegistrationDTO,BindingResult result) {
	
		//buda aşağida yaptiğimiz initbinder işini yapiyor validate ediyor
		validator.validate(userRegistrationDTO, result);
		
		if(result.hasErrors())
			return "user-registration-page";
		
		//save the dto in to database
		return "registration-success";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//nameyi dissallow etti programda
		//binder.setDisallowedFields("name");
		
		// white spaceyi engelliyor bu editör ve binder 
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class,"name",editor);
		
		// adı up case yapan bi editör yaptık.
		NamePropertyEditor nameEditor=new NamePropertyEditor();
		binder.registerCustomEditor(String.class,"name",nameEditor);
		
		// Validator class oluşturup o classla usernameyi kontrol ettirdik.
		UserNameValidator validator = new UserNameValidator();
		binder.addValidators(validator);

		// maile bakiyor gmailmi diye Email validator classı ve propertiesden hata mesajı
		//binder.addValidators(new EmailValidator());
	}
	
}
