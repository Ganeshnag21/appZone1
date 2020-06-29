package com.xworkz.appzone.service.creategroup;

import org.springframework.stereotype.Service;

import com.xworkz.appzone.dto.GroupDTO;
import com.xworkz.appzone.exception.creategroup.CreateGroupServiceException;


public interface CreateGroupService {

	GroupDTO CeateGroupService(GroupDTO dto) throws CreateGroupServiceException;
}
