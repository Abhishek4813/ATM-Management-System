package com.atm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.atm.exceptions.AuthenticationException;
import com.atm.model.UserRequest;
import com.atm.model.Users;
import com.atm.service.UserService;


import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	/*
	 * { "pin":1111 }
	 */

	@PostMapping("/authenticate")
	public ResponseEntity<Map<String, String>> getAuthenticationToken( @RequestBody UserRequest userRequest) 
	throws AuthenticationException{
		Map<String,String> authToken= new HashMap<>();
		Users user= userService.getUserDetails(userRequest.getPin());
		if(user!=null) {
			authToken.put("token", generateJwt(Long.toString(user.getId())));
			return ResponseEntity.status(HttpStatus.OK).body(authToken);
		}
		else
			throw new AuthenticationException("This Pin Is Not Valid!...");
			
	}
	
	
	
	private String generateJwt(String user) {
		JwtBuilder builder=Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date(new Date().getTime()+(30*60*1000)));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		return builder.compact();
	}
}
