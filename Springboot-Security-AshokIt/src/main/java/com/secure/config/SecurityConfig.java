package com.secure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

		/**  below commented  method is default method to secure all the api's */

		//		http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
		//		http.formLogin();
		//		http.httpBasic();


		/**  below method is customized method to secure the api's as per project need */

		http.authorizeRequests()
		.antMatchers("/balance").authenticated()  //this endpoint is secure need login
		.antMatchers("/route").authenticated()    //this endpoint is secure need login
		.antMatchers("/Welcome").permitAll()    //this endpoint is not secure it can be accessible by all users
		.and().formLogin()
		.and().httpBasic();


	}

	/** In-Memory Credentials ---- we used to configure user credentials for limited persons   */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Tanu").password("tanu").authorities("admin").and()
		.withUser("naya").password("naya").authorities("read").and()
		.withUser("yuvi").password("yuvi").authorities("read").and()
		.passwordEncoder(NoOpPasswordEncoder.getInstance());		

	}

}
