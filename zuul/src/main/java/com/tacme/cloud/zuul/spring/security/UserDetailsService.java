package com.tacme.cloud.zuul.spring.security;

import static com.tacme.cloud.zuul.spring.security.ZuulConstants.EMP_ADMIN;
import static com.tacme.cloud.zuul.spring.security.ZuulConstants.ROLE_EMP_ADMIN;
import static com.tacme.cloud.zuul.spring.security.ZuulConstants.ROLE_STU_ADMIN;
import static com.tacme.cloud.zuul.spring.security.ZuulConstants.STU_ADMIN;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(isValidUserName(username)) {
			User user = new User(username);
			user.setPassword(username);
			user.setAuthorities(getAuthority(username,username));
			return user;
		} else {
			throw new UsernameNotFoundException("User Not Present");
		}
	}
	private Set<UserAuthority> getAuthority(String username,String password) {
		Set<UserAuthority> userAuthorities=new HashSet<>();
		UserAuthority auth=new UserAuthority();
		if(username.equals(STU_ADMIN) && password.equals(STU_ADMIN)) {
			auth.setAuthority(ROLE_STU_ADMIN);
		} else {
			auth.setAuthority(ROLE_EMP_ADMIN);
		}
		userAuthorities.add(auth);
		return userAuthorities;
	}
	private boolean isValidUserName(String username) {
		return (username.equals(STU_ADMIN) || username.equals(EMP_ADMIN));
	}

}
