package com.example.web;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
public class UserController {
	
	private final Logger logger=LoggerFactory.getLogger(getClass());

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id){
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails){
			UserDetails user=(UserDetails)principal;
			Collection<? extends GrantedAuthority> collection =user.getAuthorities();
			for (GrantedAuthority c : collection) {
				logger.info("当前用户是[{}],角色是[{}]",user.getUsername(),c.getAuthority());
			}
		}
		User findOne=userRepository.findOne(id);
		return findOne;
	}
}
