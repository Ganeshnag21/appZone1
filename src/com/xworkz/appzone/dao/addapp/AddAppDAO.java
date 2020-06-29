package com.xworkz.appzone.dao.addapp;

import java.util.List;

import com.xworkz.appzone.entity.addapp.AddAppEntity;
import com.xworkz.appzone.entity.addapp.AddAppToAppZoneEntity;

public interface AddAppDAO {

	public List<AddAppEntity> getAppFromDBDao();

	public void addAppToAppZoneDao(AddAppToAppZoneEntity entityToDb);
}
