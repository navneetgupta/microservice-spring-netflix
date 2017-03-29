package com.tacme.cloud.zuul.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled=true)
@Order(1)
public class ServiceSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired private AuthenticationService authenticationService;
	public ServiceSecurityConfig() {
		super(true);
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	    .antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint())
		.and()
		.addFilterBefore(new HeaderAuthenticationFilter(authenticationService), UsernamePasswordAuthenticationFilter.class)
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().csrf().disable().httpBasic().disable();
	}
	
	private AuthenticationEntryPoint unauthorizedEntryPoint() {
		return new ServiceAuthenticationEntryPoint();
	}

}
