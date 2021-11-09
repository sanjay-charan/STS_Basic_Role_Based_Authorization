package com.example.demo.contoller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String helloAdmin() {
		return "hello admin";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
	public String helloUser() {
		return "hello user";
	}
	
	@GetMapping("/world")
	@PreAuthorize("hasAuthority('ROLE_TESTER')")
	public String helloWorld() {
		return "hello world";
	}
}
