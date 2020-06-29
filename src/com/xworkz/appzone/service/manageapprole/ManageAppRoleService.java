package com.xworkz.appzone.service.manageapprole;

import java.util.List;

import com.xworkz.appzone.dto.ChangeUserRoleDTO;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.dto.ManageAppRoleDTO;
import com.xworkz.appzone.exception.manageapprole.ManageAppRoleServiceException;

public interface ManageAppRoleService {

	public List<ManageAppRoleDTO> manageAppRoleService() throws ManageAppRoleServiceException;

	public void changeUserRoleService(ChangeUserRoleDTO dto) throws ManageAppRoleServiceException;
}
