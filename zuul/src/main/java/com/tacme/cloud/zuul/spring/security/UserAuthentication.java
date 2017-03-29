package com.tacme.cloud.zuul.spring.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication implements Authentication{

	private static final long serialVersionUID = 1L;
	
	private final User user;
	private boolean authenticated = true;
	
	public UserAuthentication(User user) {
		this.user = user;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return user.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public User getDetails() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return this.authenticated;
	}

	@Override
	public void setAuthenticated(boolean arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		this.authenticated = arg0;
	}
	public User getUser() {
		return user;
	}
}
