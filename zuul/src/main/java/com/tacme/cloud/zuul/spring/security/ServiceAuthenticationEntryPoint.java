package com.tacme.cloud.zuul.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class ServiceAuthenticationEntryPoint  implements AuthenticationEntryPoint {

	public ServiceAuthenticationEntryPoint() {
		super();
	}
	
	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
			throws IOException, ServletException {
		String error="{ \"status\":\"FAILURE\",\"error\":{\"code\":\"401\",\"message\":\""+arg2.getMessage()+"\"} }";
		HttpServletResponse httpResponse = (HttpServletResponse) arg1;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setContentType("application/json");
        httpResponse.getOutputStream().println(error);
	}
}
