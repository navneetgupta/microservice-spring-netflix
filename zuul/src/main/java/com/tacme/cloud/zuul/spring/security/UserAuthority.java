package com.tacme.cloud.zuul.spring.security;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthority implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	private String authority;
	
	@Override
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
