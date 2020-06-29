package com.xworkz.appzone.dao.creategroup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.appzone.entity.creategroup.GroupEntity;
import com.xworkz.appzone.exception.creategroup.CreateGroupDAOException;

@Repository
public class CreateGroupDAOImpl implements CreateGroupDAO {

	@Autowired
	SessionFactory factory;

	@Override
	public GroupEntity CreateGroupDao(GroupEntity entity) throws CreateGroupDAOException {

		String sql = "select entity from GroupEntity entity where groupName=:gn";
		try (Session session = factory.openSession()) {

			Query query = session.createQuery(sql);
			query.setParameter("gn", entity.getGroupName());
			GroupEntity entityFromDb = (GroupEntity) query.uniqueResult();
			System.out.println(entityFromDb);
			if (entityFromDb == null) {
				Transaction tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
				return entityFromDb;
			}
			return entityFromDb;

		} catch (Exception e) {
			throw new CreateGroupDAOException(e.getMessage());
		}

	}

}
