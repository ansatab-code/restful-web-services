package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	// /hello-word
	
	// "Hello Word"
	@GetMapping(path="/hello-world")
	public String helloWord (){
		return "Hello World";
	}
	
	// "Hello Word"
	@GetMapping(path="/hello-world-bean")
	public HelloWordBean helloWordBean (){
		return new HelloWordBean("Hello World");
	}

	//Path parameters
	// /users{id}/todos{id}
	// hello-world/path-variable/{name}
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWordBean helloWordPathVariable(@PathVariable String name ){
		
		return new HelloWordBean(String.format("Hello Word , %s", name));
	}

}
