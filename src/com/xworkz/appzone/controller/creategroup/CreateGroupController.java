package com.xworkz.appzone.controller.creategroup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.appzone.constant.login.ApplicationConstants;
import com.xworkz.appzone.constant.login.StringConstants;
import com.xworkz.appzone.dto.GroupDTO;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.exception.creategroup.CreateGroupControllerException;
import com.xworkz.appzone.service.creategroup.CreateGroupService;

@Controller
@RequestMapping("/")
public class CreateGroupController {

	@Autowired
	CreateGroupService createGroupService;

	@GetMapping("/createGroup.do")
	public ModelAndView createGroup(HttpServletRequest req) throws CreateGroupControllerException {
		try{
		HttpSession session = req.getSession(false);
		LoginDTO dto = (LoginDTO) session.getAttribute("user");

		return new ModelAndView(ApplicationConstants.CREATEGROUP, StringConstants.USER, dto);
		}
		catch (Exception e) {
			throw new CreateGroupControllerException(e.getMessage());
		}
	}

	@GetMapping("/createGroupform.do")
	public ModelAndView createGroupinDB(GroupDTO dto, HttpServletRequest req) throws CreateGroupControllerException {
		try {
			System.out.println(dto.getGroupName());
			GroupDTO dtoFromDb = createGroupService.CeateGroupService(dto);
			if (dtoFromDb==null)
				return new ModelAndView(ApplicationConstants.CREATEGROUP, StringConstants.GROUP,
						StringConstants.GROUP_SUCCESS_MESSAGE);
			else
				return new ModelAndView(ApplicationConstants.CREATEGROUP, StringConstants.GROUP,
						StringConstants.GROUP_FAILURE_MESSAGE);

		} catch (Exception e) {
			throw new CreateGroupControllerException(e.getMessage());
		}

	}
}
