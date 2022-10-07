package com.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.entity.JWTRequest;
import com.adminservice.entity.JwtResponse;
import com.adminservice.service.CustomUserDetailsService;
import com.adminservice.utility.JwtUtil;

@RestController
public class AuthenticatonController {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/token")
	public ResponseEntity<?> getToken(@RequestBody JWTRequest jwtRequest) throws Exception {
	
		System.out.println("Jwt Request --------> "+ jwtRequest);
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
		}catch (Exception e) {
		 throw new Exception("Bad Exception");
		}
		
		UserDetails user=  userDetailsService.loadUserByUsername(jwtRequest.getUserName());
	
		String token= jwtUtil.generateToken(user);
		
		System.out.println("token ---------->>>>>>>>> "+token);
		
		return  ResponseEntity.ok(new JwtResponse(token));

	}
	
      @GetMapping("/getMessage")	
	  private String getMessage() {
    	  
    	  return "GET MESSAGE";
		
	}

}
