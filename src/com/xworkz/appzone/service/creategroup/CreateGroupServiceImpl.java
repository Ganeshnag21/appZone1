package com.xworkz.appzone.service.creategroup;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xworkz.appzone.dao.creategroup.CreateGroupDAO;
import com.xworkz.appzone.dto.GroupDTO;
import com.xworkz.appzone.entity.creategroup.GroupEntity;
import com.xworkz.appzone.exception.creategroup.CreateGroupServiceException;

@Service
public class CreateGroupServiceImpl implements CreateGroupService {

	@Autowired
	CreateGroupDAO dao;

	@Override
	@Transactional
	public GroupDTO CeateGroupService(GroupDTO dto) throws CreateGroupServiceException {
		try {
			GroupEntity entity = new GroupEntity();
			BeanUtils.copyProperties(dto, entity);
			GroupEntity entityFromDb = dao.CreateGroupDao(entity);
			GroupDTO dtoFromDb = new GroupDTO();
			if (entityFromDb != null) {
				BeanUtils.copyProperties(entityFromDb, dtoFromDb);
				return dtoFromDb;
			} else {
				dtoFromDb = null;
				return dtoFromDb;

			}
		} catch (Exception e) {
			throw new CreateGroupServiceException(e.getMessage());
		}

	}

}
