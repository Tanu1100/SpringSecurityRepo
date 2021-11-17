package com.secure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	
	@GetMapping("/Welcome")
	public String Welcome()
	{
		return "Welcome to Spring Security Page ...!!!";
	}
	
	@GetMapping("/balance")
	public String BalanceMethod()
	{
		return "Welcome to Balance Page ...!!!";
	}

	@GetMapping("/route")
	public String RouteMethod()
	{
		return "Welcome to Route Page ...!!!";
	}
}
