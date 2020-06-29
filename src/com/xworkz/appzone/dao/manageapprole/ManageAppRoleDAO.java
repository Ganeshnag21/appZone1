package com.xworkz.appzone.dao.manageapprole;

import java.util.List;

import com.xworkz.appzone.dto.ChangeUserRoleDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.manageapprole.ManageAppRoleDAOException;

public interface ManageAppRoleDAO {

	public List<LoginEntity> getUsers() throws ManageAppRoleDAOException;

	public void changeUserRoleDao(ChangeUserRoleDTO dto) throws ManageAppRoleDAOException;
}
