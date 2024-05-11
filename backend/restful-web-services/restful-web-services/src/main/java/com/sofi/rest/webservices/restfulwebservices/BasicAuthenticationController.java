package com.sofi.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {
	
	
	@GetMapping(path = "/basicauth")
	public AuthenticationBean helloWorldBean() { 
		//throw new RuntimeException("Some Error Has happened! Contact Support At *****!");
	  return new AuthenticationBean("You are Authenticated ");	
	}
	
}

