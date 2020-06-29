package com.xworkz.appzone.controller.manageapprole;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.appzone.dto.ChangeUserRoleDTO;
import com.xworkz.appzone.dto.GroupDTO;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.dto.ManageAppRoleDTO;
import com.xworkz.appzone.exception.manageapprole.ManageAppRoleControllerException;
import com.xworkz.appzone.exception.managegroup.ManageGroupServiceException;
import com.xworkz.appzone.service.manageapprole.ManageAppRoleService;
import com.xworkz.appzone.service.managegroup.ManageGroupService;

@Controller
@RequestMapping("/")
public class ManageAppRoleController {

	@Autowired
	ManageAppRoleService service;

	@Autowired
	ManageGroupService groupService;

	@GetMapping("/manageapprole.do")
	public ModelAndView manageAppRoleController(HttpServletRequest req) throws ManageGroupServiceException, ManageAppRoleControllerException {
		try{
		HttpSession session = req.getSession(false);
		List<GroupDTO> groupList = groupService.manageGroupService();
		List<ManageAppRoleDTO> listUsers = service.manageAppRoleService();
		// session.setAttribute("listOfUsers", listUsers);
		System.out.println(listUsers);
		return new ModelAndView("manageapprole", "listOfUsers", listUsers).addObject("groupList", groupList);
		}
		catch (Exception e) {
			throw new ManageAppRoleControllerException(e.getMessage());
		}
	}

	@GetMapping("/changeroleofuser.do")
	public String changeUserRoleController(ChangeUserRoleDTO dto, HttpServletRequest req) throws ManageAppRoleControllerException {
		try{
		System.out.println(dto);
		service.changeUserRoleService(dto);

		return "redirect:manageapprole.do";
		}
		catch (Exception e) {
			throw new ManageAppRoleControllerException(e.getMessage());
		}

	}

}
