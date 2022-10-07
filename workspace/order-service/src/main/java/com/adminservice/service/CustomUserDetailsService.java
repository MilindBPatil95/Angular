package com.adminservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Inside loadUserByUsername--------->>>>>>>>> ");
		if(username.equals("Milind"))
			
		{
			return new User("Milind", "Patil123", new ArrayList<>() );
		}
		else {
			
			throw new UsernameNotFoundException("bad creadentials");
		}
		
	}

}
