package com.xworkz.appzone.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.appzone.constant.login.ApplicationConstants;
import com.xworkz.appzone.constant.login.StringConstants;
import com.xworkz.appzone.dao.login.LoginDAO;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.exception.login.LoginControllerException;
import com.xworkz.appzone.service.login.LoginService;

@Controller
@Component
@RequestMapping("/")
public class LoginController {

	@Autowired
	LoginService service;
	
	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView loginController(LoginDTO dto, HttpServletRequest req) throws LoginControllerException {
		try {
			HttpSession session = req.getSession(true);
			LoginDTO dtoFromDb = service.loginService(dto,req);
			if (dtoFromDb != null) {
				session.setAttribute("user", dtoFromDb);
				if(session.getAttribute("userType").equals("admin"))
				return new ModelAndView(ApplicationConstants.HOME, StringConstants.SUCCESS,
						StringConstants.SUCCESS_MESSAGE).addObject(StringConstants.USER,dtoFromDb);
				else
					return new ModelAndView(ApplicationConstants.SEARCH, StringConstants.SUCCESS,
							StringConstants.SUCCESS_MESSAGE);
			} 
			else
				return new ModelAndView(ApplicationConstants.SIGNIN, StringConstants.FAILURE,
						StringConstants.FAILURE_MESSAGE);
		} catch (Exception e) {
			throw new LoginControllerException(e.getMessage());
		}
	}
}
