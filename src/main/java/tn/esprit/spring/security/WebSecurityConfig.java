package tn.esprit.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.esprit.spring.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				
	
		.antMatchers("/user/add-user").permitAll()
		.antMatchers("/user/get-all-users").access("hasRole('ADMIN')")//permitAll()
		.antMatchers("/role/**").permitAll()
		.antMatchers("/user/delete-user/{user-id}").access("hasRole('SUPERADMIN')")
		.anyRequest().authenticated().and().httpBasic().and().csrf().disable();
	}
}