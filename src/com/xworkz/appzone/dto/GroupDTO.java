package com.xworkz.appzone.dto;

public class GroupDTO {

	private int groupId;
	private String groupName;
	
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@Override
	public String toString() {
		return "GroupDTO [GroupId=" + groupId + ", groupName=" + groupName + "]";
	}
	
	
	
}

