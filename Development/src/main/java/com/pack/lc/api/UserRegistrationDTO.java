package com.pack.lc.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.pack.lc.Validator.Age;

public class UserRegistrationDTO {

	// bu sayfaya ve jspsine user-regist e userinfodto da olan karakter kısıtlamalarını ekle
	
	@NotEmpty(message = "{string.notEmpty}")
	private String name;
	
	private String userName;
	private char[] password;
	private String countryName;
	private String[] hobbies;
	private String gender;
	
	@Age
	private Integer age;
	
	private CommunicationDTO communicationDTO;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}
	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
