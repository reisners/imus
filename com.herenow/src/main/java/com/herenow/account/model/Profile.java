package com.herenow.account.model;

import java.util.Set;

public class Profile {
	public static final Object USERNAME = "username";
	private long id;
	private String username;
	private String password;
	transient private String passwordConfirm;
	private Set<Role> roles;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
