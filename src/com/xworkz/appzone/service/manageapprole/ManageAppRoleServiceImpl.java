package com.xworkz.appzone.service.manageapprole;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.appzone.dao.manageapprole.ManageAppRoleDAO;
import com.xworkz.appzone.dto.ChangeUserRoleDTO;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.dto.ManageAppRoleDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.manageapprole.ManageAppRoleServiceException;

@Service
public class ManageAppRoleServiceImpl implements ManageAppRoleService {

	@Autowired
	ManageAppRoleDAO dao;

	@Override
	public List<ManageAppRoleDTO> manageAppRoleService() throws ManageAppRoleServiceException {

		try {
			List<ManageAppRoleDTO> listDto = new ArrayList<ManageAppRoleDTO>();
			List<LoginEntity> listFromDb = dao.getUsers();
			Iterator<LoginEntity> itr = listFromDb.iterator();
			while (itr.hasNext()) {
				ManageAppRoleDTO dto = new ManageAppRoleDTO();
				LoginEntity entity = itr.next();
				BeanUtils.copyProperties(entity, dto);
				listDto.add(dto);
			}
			return listDto;
		} catch (Exception e) {
			throw new ManageAppRoleServiceException(e.getMessage());
		}
	}

	@Override
	public void changeUserRoleService(ChangeUserRoleDTO dto) throws ManageAppRoleServiceException {
		try {
			dao.changeUserRoleDao(dto);
		} catch (Exception e) {
			throw new ManageAppRoleServiceException(e.getMessage());
		}
	}

}
