package com.xworkz.appzone.dao.managegroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.dto.ManageGroupDTO;
import com.xworkz.appzone.entity.creategroup.GroupEntity;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.managegroup.ManageGroupDAOException;

@Repository
public class ManageGroupDAOImpl implements ManageGroupDAO {

	@Autowired
	SessionFactory factory;

	@Override
	public List<GroupEntity> manageGroupDao() throws ManageGroupDAOException {
		try (Session session = factory.openSession()) {
			String sql = "from GroupEntity";
			Query query = session.createQuery(sql);
			List<GroupEntity> groupList = query.list();
			System.out.println(groupList);
			return groupList;
		} catch (Exception e) {
			throw new ManageGroupDAOException(e.getMessage());
		}

	}

	@Override
	public List<LoginEntity> getValidUserMail(List list, GroupEntity group) throws ManageGroupDAOException {
		try (Session session = factory.openSession()) {

			String sql = "select entity from LoginEntity entity where entity.email in (:emailList)";
			Query query = session.createQuery(sql);
			query.setParameter("emailList", list);
			List resultList = query.getResultList();
			System.out.println(resultList); // Taking valid emails

			// ==========================================================================

			// updating user_login table with appropriate group_id and returning
			// valid email lists
			Transaction tx = session.beginTransaction();
			String sqlUpdate = "update LoginEntity entity set entity.groupId =:gid where entity.email in(:emailList)";
			Query queryUpdate = session.createQuery(sqlUpdate);
			queryUpdate.setParameter("emailList", list);
			queryUpdate.setParameter("gid", group.getGroupId());
			int executeUpdate = queryUpdate.executeUpdate();
			System.out.println(executeUpdate);
			tx.commit();
			return resultList;

		} catch (Exception e) {
			throw new ManageGroupDAOException(e.getMessage());
		}

	}

	@Override
	public GroupEntity getGroup(int groupId) {
		GroupEntity groupEntity = new GroupEntity();
		try (Session session = factory.openSession()) {
			groupEntity = session.get(GroupEntity.class, groupId);

		} catch (Exception e) {
		}
		return groupEntity;
	}

}
