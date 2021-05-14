package org.nagarro.employee.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenService {

	String extractUserName(String token);

	boolean validate(String token, UserDetails userDetails);

}