package com.sofi.rest.webservices.restfulwebservices.helloworld;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	//GET
	//URI -/hello-world
	//Method - "Hello World"
//	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() { 
		//throw new RuntimeException("Some Error Has happened! Contact Support At *****!");
	  return new HelloWorldBean("Hello World-Welcome to Coding Universe");	
	}
	
	
	
	//hello-world/path-variable/in6hours
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

}

/*Remember:
 * We can replace RequestMapping() method with respective request like 
 * @GetMapping() , @PostMapping() etc. 
 * 
 */