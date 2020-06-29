package com.xworkz.appzone.dto;

public class AddGroupToUserDTO {

	private int groupId;
	private String emailList;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getEmailList() {
		return emailList;
	}
	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}
	
	@Override
	public String toString() {
		return "AddGroupToUserDTO [groupId=" + groupId + ", emailList=" + emailList + "]";
	}
	
	
}
