package com.xworkz.appzone.dao.manageapprole;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.appzone.dto.ChangeUserRoleDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.manageapprole.ManageAppRoleDAOException;

@Repository
public class ManageAppRoleDAOImpl implements ManageAppRoleDAO {

	@Autowired
	SessionFactory factory;
	
	@Override
	public List<LoginEntity> getUsers() throws ManageAppRoleDAOException {
		try(Session session = factory.openSession()) {
			String sql = "from LoginEntity";
			
			Query query =session.createQuery(sql);
			List<LoginEntity> list = query.list();
			System.out.println(list);
			return list;
		} catch (Exception e) {
			throw new ManageAppRoleDAOException(e.getMessage());
		}
	}

	@Override
	public void changeUserRoleDao(ChangeUserRoleDTO dto) throws ManageAppRoleDAOException {
		try (Session session = factory.openSession()){ 
			System.out.println("ttttttttttttttttt"+dto.getGroupId());
			System.out.println(dto);
			Transaction tx = session.beginTransaction();
			String sql = "update LoginEntity entity set entity.userGroup=:ut where entity.id=:id and entity.groupId=:gid";
			String sql1 = "select entity from LoginEntity entity where entity.id=:id and entity.groupId=:gg";
			Query query = session.createQuery(sql);
			Query query1 = session.createQuery(sql1);
			query1.setParameter("gg", dto.getGroupId());
			query1.setParameter("id", dto.getUserId());
			System.out.println("result"+query1.uniqueResult());
			query.setParameter("ut", dto.getUserType());
			query.setParameter("id", dto.getUserId());
			query.setParameter("gid", dto.getGroupId());
			int executeUpdate = query.executeUpdate();
			tx.commit();
			System.out.println(executeUpdate);
			
			
		} catch (Exception e) {
			throw new ManageAppRoleDAOException(e.getMessage());
		}
		
	}

}
