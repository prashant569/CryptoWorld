package com.cryptoworld.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/")
public class HelloResource {

	@GetMapping("/all")
	public String hello() {
		return new String("Hello user");
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin")
	public String helloAdmin() {
		return "Hello Admin";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/authenticated")
	public String helloAuthenticatedUser() {
		return "Hello authenticated user";
	}
	
}
