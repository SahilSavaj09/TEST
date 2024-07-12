package com.ACE9TechLab.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	@GetMapping("/firstCommand")
	public String getFirstCommand() {
		return "First Command";
	}
	
}
