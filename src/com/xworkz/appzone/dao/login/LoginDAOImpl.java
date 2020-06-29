package com.xworkz.appzone.dao.login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.login.LoginDAOException;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	SessionFactory factory;

	//public static final Logger logger = LoggerFactory.getLogger(LoginDAO.class);
	public LoginDAOImpl() {
	//	logger.info("Created "+this.getClass().getSimpleName());
	}
	@Override
	public LoginEntity loginDao(LoginEntity entity) throws LoginDAOException {
		
		try(Session session = factory.openSession()){
			String sql = "select entity from LoginEntity entity where userName=:un and password=:pass";
			Query query = session.createQuery(sql);
			query.setParameter("un", entity.getUserName());
			query.setParameter("pass",entity.getPassword());
			LoginEntity entityFromDb= (LoginEntity) query.uniqueResult();
			
			return entityFromDb;
		}
		catch (Exception e) {
			throw new LoginDAOException(e.getMessage());
		}
		
	}

}
