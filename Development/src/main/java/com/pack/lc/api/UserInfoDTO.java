package com.pack.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {

//	@NotBlank(message = "* Your name can't be blank")
//	@Min(value = 3,message = "*Your Name should have at least 3 character")
	@Size(min = 3,max = 10,message = "*Your Name should between 3-10 character")
	private String userName;
	private String friendName;
	
	@AssertTrue(message = "You have to agree to term and condition.")
	private boolean termAndCondition;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", friendName=" + friendName + "]";
	}
	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
	
	
}
