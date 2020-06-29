package com.xworkz.appzone.service.managegroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xworkz.appzone.dao.managegroup.ManageGroupDAO;
import com.xworkz.appzone.dto.GroupDTO;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.dto.ManageGroupDTO;
import com.xworkz.appzone.entity.creategroup.GroupEntity;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.managegroup.ManageGroupServiceException;
import com.xworkz.appzone.util.MailServiceForUsers;

@Service
public class ManageGroupServiceImpl implements ManageGroupService {

	@Autowired
	ManageGroupDAO dao;

	@Autowired
	MailServiceForUsers mail;

	@Override
	public List<GroupDTO> manageGroupService() throws ManageGroupServiceException {

		try {
			List<GroupEntity> groupListEntity = dao.manageGroupDao();
			List<GroupDTO> groupListDTO = new ArrayList<>();
			System.out.println(groupListEntity);
			for (int i = 0; i < groupListEntity.size(); i++) {
				GroupDTO dto = new GroupDTO();
				System.out.println(groupListEntity.get(i));
				BeanUtils.copyProperties(groupListEntity.get(i), dto);
				groupListDTO.add(i, dto);
			}
			System.out.println(groupListDTO);
			return groupListDTO;
		} catch (Exception e) {
			throw new ManageGroupServiceException(e.getMessage());
		}
	}

	@Override
	public List<LoginDTO> registerUsersForGroup(ManageGroupDTO dto) throws ManageGroupServiceException {
		try {
			List<LoginDTO> validDto = new ArrayList<>();
			List<String> list = Arrays.asList(dto.getEmailList().split(","));
			GroupEntity group = dao.getGroup(dto.getGroupId());
			List<LoginEntity> validUsers = dao.getValidUserMail(list,group);
			//Sending mail to valid users
			mail.registerUsersForGroup(validUsers, group);
			
			//converting vaid users entity to DTO for UI result
			Iterator<LoginEntity> itr = validUsers.iterator();
			while (itr.hasNext()) {
				LoginDTO tempDto = new LoginDTO();
				BeanUtils.copyProperties(itr.next(), tempDto);
				validDto.add(tempDto);
			}
			return validDto;
			
			
		} catch (Exception e) {
			throw new ManageGroupServiceException(e.getMessage());
		}
	}

}
