package com.xworkz.appzone.dao.managegroup;

import java.util.List;

import com.xworkz.appzone.dto.ManageGroupDTO;
import com.xworkz.appzone.entity.creategroup.GroupEntity;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.managegroup.ManageGroupDAOException;

public interface ManageGroupDAO {

	public List<GroupEntity> manageGroupDao() throws ManageGroupDAOException;

	public GroupEntity getGroup(int groupId) throws ManageGroupDAOException;

	public List<LoginEntity> getValidUserMail(List<String> list, GroupEntity group) throws ManageGroupDAOException;
}
