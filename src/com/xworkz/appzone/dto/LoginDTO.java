package com.xworkz.appzone.dto;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class LoginDTO {

	private String userName;
	private String password;

	//private static final Logger logger = LoggerFactory.getLogger(LoginDTO.class);

	public LoginDTO() {
		//logger.debug("Created " + this.getClass().getSimpleName());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", password=" + password + "]";
	}

	
}
