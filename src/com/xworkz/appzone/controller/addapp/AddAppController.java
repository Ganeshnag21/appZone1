package com.xworkz.appzone.controller.addapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.appzone.dto.AddAppDto;
import com.xworkz.appzone.dto.AddApptoAppZoneDTO;
import com.xworkz.appzone.service.addapp.AddAppService;

@Controller
@RequestMapping("/")
public class AddAppController {

	@Autowired
	AddAppService service;
	
	@RequestMapping("/addapp.do")
	public ModelAndView getExistingAppsFromDB(){
		List<AddAppDto> appsFromDB = service.getAppsFromDB();	
		return new ModelAndView("addapp", "listofapp", appsFromDB);
	}
	
	@RequestMapping("/addtoappzone.do")
	public String addAppController(AddApptoAppZoneDTO dto){
		System.out.println("Add App Calledddddddddddddddddddd");
		System.out.println(dto);
		service.addAppToAppZoneService(dto);
		return "";
	}
}
