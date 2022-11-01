package com.blurdel.ssjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blurdel.ssjwt.model.AuthenticationRequest;
import com.blurdel.ssjwt.model.AuthenticationResponse;
import com.blurdel.ssjwt.util.JwtTokenUtil;


@RestController
public class HelloResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil JwtTokenUtil;
	
	
	@GetMapping({ "/hello" })
	public String getHello() {
		return "Hello World with JWT";
	}
	
	/*	Make a POST request
	 * 
	 * 	{
	 *      "username": "foo",
	 * 	    "password": "foo"
	 * 	}
	 * 
	 *  It returns a jwt
	 *  Use that jwt in a GET Header with Authorization value "Bearer jwt"  
	 */
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
		
		try {
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
			);
			
		} 
		catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authRequest.getUsername());
		
		final String jwt = JwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
}
