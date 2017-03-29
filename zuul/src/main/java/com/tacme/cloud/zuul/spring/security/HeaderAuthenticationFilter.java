package com.tacme.cloud.zuul.spring.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class HeaderAuthenticationFilter extends GenericFilterBean {
	private AuthenticationService authenticationService;
	
	public HeaderAuthenticationFilter(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		if(SecurityContextHolder.getContext().getAuthentication()==null){
			Authentication auth=authenticationService.getAuthentication(request);
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		logger.info("Continuing with Filter chain");
		arg2.doFilter(request, response);
		
	}

}
