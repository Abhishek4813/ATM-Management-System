package com.atm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

@Service
public class TokenFetch {

	public boolean authorizeToken(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)  {
		String jwtToken = null;
		String userId = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				userId = getIdFromToken(jwtToken);
			}

			catch(SignatureException | MalformedJwtException|IllegalArgumentException | ExpiredJwtException e) {
				return false;
			}

		}
		return userId != null;

	}
	
	
	private String getIdFromToken(String token) {
		Jws<Claims> jws=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token.replace("Bearer ", ""));
		return jws.getBody().getSubject();
		}
}
