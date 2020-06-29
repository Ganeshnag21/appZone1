package com.xworkz.appzone.entity.creategroup;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="project_group")
public class GroupEntity implements Serializable{

	@Id
	@GenericGenerator(name="inc",strategy="increment")
	@GeneratedValue(generator="inc")
	@Column(name="group_id")
	private int groupId;
	@Column(name="group_name")
	private String groupName;
	
	public GroupEntity() {
		// TODO Auto-generated constructor stub
	}
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
		return "GroupEntity [groupId=" + groupId + ", groupName=" + groupName + "]";
	}
	
	
}
