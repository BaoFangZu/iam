
package com.exposure;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**","/swagger-ui.html","/webjars/springfox-swagger-ui/**","/swagger-resources/**","/v2/api-docs").permitAll()
		//.anyRequest().authenticated()
		.and()
		.httpBasic().disable()
		.csrf().disable();
	}

}