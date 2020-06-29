package com.xworkz.appzone.entity.login;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user_login")
public class LoginEntity implements Serializable {

	@Id
	@Column(name = "user_id")
	private int id;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_active")
	private String userActive;
	@Column(name = "user_type")
	private String userGroup;
	@Column(name="group_assigned")
	private Integer groupId;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public LoginEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserActive() {
		return userActive;
	}

	public void setUserActive(String userActive) {
		this.userActive = userActive;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	@Override
	public String toString() {
		return "LoginEntity [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", userActive=" + userActive + ", userGroup=" + userGroup + "]";
	}

}
