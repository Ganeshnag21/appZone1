package com.xworkz.appzone.service.login;

import javax.servlet.http.HttpServletRequest;

import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.exception.login.LoginServiceException;

public interface LoginService {

	public LoginDTO loginService(LoginDTO dto,HttpServletRequest req) throws LoginServiceException;
}
