package org.nagarro.employee.service;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service("jwtTokenService")
public class JwtTokenServiceImpl implements JwtTokenService {
	
	private final String SECRET_KEY = "secret";
	
	private Claims extractClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	/* (non-Javadoc)
	 * @see org.nagarro.employee.service.JwtTokenService#extractUserName(java.lang.String)
	 */
	public String extractUserName(String token) {
		return extractClaims(token).getSubject();
	}
	
	private Date extractExpiration(String token) {
		return extractClaims(token).getExpiration();
	}
	
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	/* (non-Javadoc)
	 * @see org.nagarro.employee.service.JwtTokenService#validate(java.lang.String, org.springframework.security.core.userdetails.UserDetails)
	 */
	public boolean validate(String token , UserDetails userDetails) {
		String userName = extractUserName(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
