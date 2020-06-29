package com.xworkz.appzone.dao.addapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.appzone.entity.addapp.AddAppEntity;
import com.xworkz.appzone.entity.addapp.AddAppToAppZoneEntity;

@Repository
public class AddAppDAOImpl implements AddAppDAO {

	@Autowired
	SessionFactory factory;
	
	@Override
	public List<AddAppEntity> getAppFromDBDao() {

		try (Session session = factory.openSession()){
			
			String sql = "from AddAppEntity";
			Query query = session.createQuery(sql);
			List<AddAppEntity> list = query.list();
			return list;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public void addAppToAppZoneDao(AddAppToAppZoneEntity entity) {

		try(Session session = factory.openSession()) {
			session.save(entity);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
