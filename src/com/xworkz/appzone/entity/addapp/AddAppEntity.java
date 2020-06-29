package com.xworkz.appzone.entity.addapp;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="app_table")
public class AddAppEntity {

	@Id
	@Column(name="app_id")
	private int appId;
	@Column(name="app_name")
	private String appName;


	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Override
	public String toString() {
		return "AddAppEntity [app_id=" + appId + ", appName=" + appName + "]";
	}

	
	
	
	
}
