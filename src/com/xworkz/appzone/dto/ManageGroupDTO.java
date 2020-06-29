package com.xworkz.appzone.dto;

public class ManageGroupDTO {

	private int groupId;
	private String emailList;

	public ManageGroupDTO() {
		System.out.println(this.getClass().getSimpleName());
	}

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

}
