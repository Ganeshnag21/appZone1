package com.xworkz.appzone.service.addapp;

import java.util.List;

import com.xworkz.appzone.dto.AddAppDto;
import com.xworkz.appzone.dto.AddApptoAppZoneDTO;

public interface AddAppService {
	
	public List<AddAppDto> getAppsFromDB();

	public void addAppToAppZoneService(AddApptoAppZoneDTO dto);

}
