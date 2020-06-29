package com.xworkz.appzone.entity.addapp;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class AddAppToAppZoneEntity implements Serializable {

	@Id
	@GenericGenerator(name = "inc", strategy = "increment")
	@GeneratedValue(generator = "inc")
	@Column(name = "id")
	private int id;
	@Column(name = "app_id")
	private int appId;
	@Column(name = "alias_name")
	private String aliasName;
	@Column(name = "description")
	private String description;
	@Column(name = "group_mail")
	private String groupMail;
	@Column(name = "active")
	private Boolean isActive;
	@Column(name = "is_cloud")
	private Boolean isCloud;

	public AddAppToAppZoneEntity() {
		System.out.println("AddApptoAppZone Entity created");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupMail() {
		return groupMail;
	}

	public void setGroupMail(String groupMail) {
		this.groupMail = groupMail;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsCloud() {
		return isCloud;
	}

	public void setIsCloud(Boolean isCloud) {
		this.isCloud = isCloud;
	}

	@Override
	public String toString() {
		return "AddAppToAppZoneEntity [id=" + id + ", appId=" + appId + ", aliasName=" + aliasName + ", description="
				+ description + ", groupMail=" + groupMail + ", isActive=" + isActive + ", isCloud=" + isCloud + "]";
	}

}
