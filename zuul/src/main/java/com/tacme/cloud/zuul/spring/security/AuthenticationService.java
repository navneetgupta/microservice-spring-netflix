package com.tacme.cloud.zuul.spring.security;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import static com.tacme.cloud.zuul.spring.security.ZuulConstants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;

@Component
public class AuthenticationService {

	@Autowired private UserDetailsService userDetailsService;

	public Authentication getAuthentication(HttpServletRequest request) {
		final String username = request.getHeader(HEADER_USER_NAME);
		final String password = request.getHeader(HEADER_PASSWORD);
		User user = null;
		if(username !=null && password !=null && validUsernamePasssword(username,password)) {
			 user = userDetailsService.loadUserByUsername(username);
			 addHeadersForMicroServices(request,username);
			 return new UserAuthentication(user);
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	private void addHeadersForMicroServices(HttpServletRequest request, String checkRoles) {
		RequestContext ctx = RequestContext.getCurrentContext();
		if(checkRoles.equals(STU_ADMIN)) {
			ctx.addZuulRequestHeader(SERVICE_ROLES,ROLE_STU_ADMIN);
		} else {
			ctx.addZuulRequestHeader(SERVICE_ROLES,ROLE_EMP_ADMIN);
		}
	}
	
	private boolean validUsernamePasssword(String username, String password) {
		// TODO Auto-generated method stub
		return (username.equals(STU_ADMIN) || username.equals(EMP_ADMIN)) && (password.equals(STU_ADMIN) || password.equals(EMP_ADMIN));
	}

}
