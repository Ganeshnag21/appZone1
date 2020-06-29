package com.xworkz.appzone.dto;

public class AddApptoAppZoneDTO {
	
	private int appId;
	private String aliasName;
	private String description;
	private String groupMail;
	private Boolean isActive;
	private Boolean isCloud;
	
	public AddApptoAppZoneDTO() {
		System.out.println("DTO created");
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
		return "AddApptoAppZoneDTO [appId=" + appId + ", aliasName=" + aliasName + ", description=" + description
				+ ", groupMail=" + groupMail + ", isActive=" + isActive + ", isCloud=" + isCloud + "]";
	}
	
	
	

}
