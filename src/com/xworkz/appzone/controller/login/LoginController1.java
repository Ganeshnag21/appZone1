package com.xworkz.appzone.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController1 {

	@RequestMapping("/map.do")
	public String returning() {
		
		return "fine";
		
	}
}
