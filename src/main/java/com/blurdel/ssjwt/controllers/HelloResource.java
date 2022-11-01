package com.blurdel.ssjwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloResource {

	@GetMapping({ "/hello" })
	public String getHello() {
		return "Hello World with JWT";
	}
	
}
