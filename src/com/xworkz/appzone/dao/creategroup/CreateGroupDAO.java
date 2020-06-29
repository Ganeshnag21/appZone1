package com.xworkz.appzone.dao.creategroup;

import com.xworkz.appzone.entity.creategroup.GroupEntity;
import com.xworkz.appzone.exception.creategroup.CreateGroupDAOException;

public interface CreateGroupDAO {

	public GroupEntity CreateGroupDao(GroupEntity entity) throws CreateGroupDAOException;
}
