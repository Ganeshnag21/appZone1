package com.xworkz.appzone.controller.managegroup;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.appzone.dto.GroupDTO;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.dto.ManageGroupDTO;
import com.xworkz.appzone.exception.managegroup.ManageGroupControllerException;
import com.xworkz.appzone.service.managegroup.ManageGroupService;

@Controller
@RequestMapping("/")
public class ManageGroupController {

	@Autowired
	ManageGroupService service;

	@RequestMapping("/managegroup.do")
	public ModelAndView manageGroupController(HttpServletRequest req) throws ManageGroupControllerException {
		try{
		HttpSession session = req.getSession(false);
		List<GroupDTO> groupList = service.manageGroupService();
		return new ModelAndView("managegroup", "groupList", groupList);
		}
		catch (Exception e) {
			throw new ManageGroupControllerException(e.getMessage());
		}
	}
	
	@RequestMapping("/addgrouptouser.do")
	public String inviteUserToGroup(ManageGroupDTO dto,HttpServletRequest req) throws ManageGroupControllerException{
		try{
		HttpSession session = req.getSession(false);
		List<LoginDTO> registerUsersForGroup = service.registerUsersForGroup(dto);
		
		List<String> result = registerUsersForGroup.stream().map(e -> e.getUserName()).collect(Collectors.toList());
		String resultString = "Succesfully added ";
		String finalString = resultString.join(",", result);
		System.out.println(result);
		req.setAttribute("manageGroupDetails", finalString);
		return "redirect:managegroup.do";
		}
		catch (Exception e) {
			throw new ManageGroupControllerException(e.getMessage());
		}
	}
}
