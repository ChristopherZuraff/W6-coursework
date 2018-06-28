package com.example.demo;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secret")
public class SecretController {

	@GetMapping()
	public String getSecret() {
		return "butts again";
	}
	
	@GetMapping("/bigbrother")
	public Principal getBigBrother(Principal principal) {
		return principal;
	}
}
