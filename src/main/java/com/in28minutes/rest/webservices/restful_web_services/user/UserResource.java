package com.in28minutes.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	private UserDaoService userDaoService;
	
	public UserResource(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	// /GET /users
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	// /GET /users
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable Integer id ){
		User user = userDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id:"+id);
		}
		return user;
	}
	
	// /POST /users
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		// location = /users/4
		return ResponseEntity.created(location).body(user);
		
	}
	
	// /GET /users
		@DeleteMapping(path = "/users/{id}")
		public void deleteUser(@PathVariable Integer id ){
			userDaoService.deleteById(id);
		}
	
}
