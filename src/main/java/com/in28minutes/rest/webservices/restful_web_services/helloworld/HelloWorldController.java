package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController (MessageSource messageSource) {
		this.messageSource = messageSource;
	}
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
	
	// "Hello Word"
		@GetMapping(path="/hello-world-internationalized")
		public String helloWordInternationalized (){
			Locale locale= LocaleContextHolder.getLocale();
			return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
			//return "Hello World V2";
		}

}
