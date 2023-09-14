package com.nissan.util;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.nissan.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	//secret key for token
	private static String secretA =" This_is_ADMIN";
	private static String secretB =" This_is_CUSTOMER";
	//expiration time
	private static long expiryDuration=60*60;
	//generate token: header.payload.signature
	public String generateJwtAdmin( User user)
	{long milliTime=System.currentTimeMillis();
	long expiryTime= milliTime + expiryDuration*1000;
	//set issuedTime and ExpiryTime in token
	Date issuedAt= new Date(milliTime);
	Date expiryAt=new Date(expiryTime);
		
	//claims
		Claims claim = Jwts.claims()
				.setIssuer(user.getUserId().toString())
				.setIssuedAt(issuedAt).setExpiration(expiryAt);
	//generate JWT token using claims
		
		return Jwts.builder().setClaims(claim)
				.signWith(SignatureAlgorithm.HS512,secretA).compact();
		
		
	}
	
	//checking token is valid or not
	public Claims verifyAdmin(String authorization) throws AccessDeniedException
	{try
	{
		Claims claim = Jwts.parser().setSigningKey(secretA).parseClaimsJws(authorization).getBody();
		return claim;
	}
	catch(Exception e)
	{
		throw new  AccessDeniedException("Sorry!Access Denied!!!!!!!!!!!!");
	}
		
	}

	public String generateJwtCustomer( User user)
	{long milliTime=System.currentTimeMillis();
	long expiryTime= milliTime + expiryDuration*1000;
	//set issuedTime and ExpiryTime in token
	Date issuedAt= new Date(milliTime);
	Date expiryAt=new Date(expiryTime);
		
	//claims
		Claims claim = Jwts.claims()
				.setIssuer(user.getUserId().toString())
				.setIssuedAt(issuedAt).setExpiration(expiryAt);
	//generate JWT token using claims
		
		return Jwts.builder().setClaims(claim)
				.signWith(SignatureAlgorithm.HS512,secretB).compact();
		
		
	}
	
	//checking token is valid or not
	public Claims verifyCustomer(String authorization) throws AccessDeniedException
	{try
	{
		Claims claim = Jwts.parser().setSigningKey(secretB).parseClaimsJws(authorization).getBody();
		return claim;
	}
	catch(Exception e)
	{
		throw new  AccessDeniedException("Sorry!Access Denied!!!!!!!!!!!!");
	}
		
	}

}
