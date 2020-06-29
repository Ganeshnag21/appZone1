package com.xworkz.appzone.service.managegroup;

import java.util.List;

import com.xworkz.appzone.dto.GroupDTO;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.dto.ManageGroupDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.managegroup.ManageGroupServiceException;

public interface ManageGroupService {

	public List<GroupDTO> manageGroupService() throws ManageGroupServiceException;

	public List<LoginDTO> registerUsersForGroup(ManageGroupDTO dto) throws ManageGroupServiceException;
}
