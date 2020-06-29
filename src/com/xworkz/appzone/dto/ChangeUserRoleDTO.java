package com.xworkz.appzone.dto;

public class ChangeUserRoleDTO {

	private int userId;
	private int groupId;
	private String userType;
	
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "ChangeUserRoleDTO [userId=" + userId + ", groupId=" + groupId + ", userType=" + userType + "]";
	}

	
}
