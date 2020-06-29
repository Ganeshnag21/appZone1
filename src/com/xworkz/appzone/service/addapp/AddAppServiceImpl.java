package com.xworkz.appzone.service.addapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.appzone.dao.addapp.AddAppDAO;
import com.xworkz.appzone.dao.addapp.AddAppDAOImpl;
import com.xworkz.appzone.dto.AddAppDto;
import com.xworkz.appzone.dto.AddApptoAppZoneDTO;
import com.xworkz.appzone.entity.addapp.AddAppEntity;
import com.xworkz.appzone.entity.addapp.AddAppToAppZoneEntity;

@Service
public class AddAppServiceImpl implements AddAppService {

	@Autowired
	AddAppDAO dao;
	@Override
	public List<AddAppDto> getAppsFromDB() {

		List<AddAppEntity> list = dao.getAppFromDBDao();
		
		List<AddAppDto> listDto = new ArrayList<AddAppDto>();
		
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			AddAppDto dto = new AddAppDto();
			BeanUtils.copyProperties(itr.next(), dto);
			listDto.add(dto);
		}
		
		return listDto;
		
	}
	@Override
	public void addAppToAppZoneService(AddApptoAppZoneDTO dto) {
		
		AddAppToAppZoneEntity entityToDb = new AddAppToAppZoneEntity();
		
		BeanUtils.copyProperties(dto, entityToDb);
		System.out.println(dto+"Nodappaaa"+entityToDb);
		dao.addAppToAppZoneDao(entityToDb);
		
	}

}
