package com.xworkz.appzone.controller.HomeController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.appzone.constant.login.ApplicationConstants;
import com.xworkz.appzone.constant.login.StringConstants;
import com.xworkz.appzone.dto.LoginDTO;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/goToHome.do")
	public ModelAndView homeController(HttpServletRequest req){
		HttpSession session = req.getSession();
		LoginDTO dto = (LoginDTO) session.getAttribute("user");
		
		return new ModelAndView(ApplicationConstants.HOME, StringConstants.USER, dto);
		
	}
}
