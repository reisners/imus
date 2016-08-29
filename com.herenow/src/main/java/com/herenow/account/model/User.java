package com.herenow.account.model;

import java.util.Set;

public class User {
	private long id;
	private String username;
	private String password;
	private String passwordConfirm;
	private Set<Role> roles;
}
