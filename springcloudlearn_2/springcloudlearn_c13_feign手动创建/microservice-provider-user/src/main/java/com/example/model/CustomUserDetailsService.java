package com.example.model;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("user".equals(username)){
			return new SecurityUser("user", "user", "user-role");
		}else if("admin".equals(username)){
			return new SecurityUser("admin", "admin", "admin-role");
		}
		return null;
	}

}
