
package com.onecode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console/**").permitAll()// allow h2 console access to admins only
				/*
				 * .anyRequest().authenticated()//all other urls can be access by any
				 * authenticated role .and().formLogin()//enable form login instead of basic
				 * login
				 */
				.and().csrf().ignoringAntMatchers("**")// don't apply CSRF protection to /h2-console
				.and().headers().frameOptions().sameOrigin();// allow use of frame to same origin urls
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

		resources.resourceId("vehicle");
	}

}
