package com.herenow.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.herenow.account.model.Profile;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Profile profile = userService.findByUsername(username);
		if (profile == null) {
			throw new UsernameNotFoundException(username);
		}
		Collection<? extends GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		return new User(username, profile.getPassword(), authorities);
	}
}
