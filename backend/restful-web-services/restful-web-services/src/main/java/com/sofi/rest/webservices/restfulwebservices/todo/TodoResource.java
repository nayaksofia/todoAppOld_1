package com.sofi.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

	@Autowired
	private TodoHardcodedService todoService; // Create a service

	// To take the list of todos of one user
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoService.findAll();
	}

	// To retrive todos of one user by id
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		return todoService.findById(id);
	}

	// Focus On Delete Method
	// users/{username}/todos/{id}
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		Todo todo = todoService.deleteById(id); // assign the statement to new local variable todo
		if (todo != null) {
			return ResponseEntity.noContent().build(); // ResponseEntity uses Builder Pattern
		}

		return ResponseEntity.notFound().build();
	}

	// Edit/ Update a Todo→ PUT/users/{username}/todos/{id}
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {
		Todo todoUpdated = todoService.save(todo); // this take updated todo
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	// Create a New Todo→ POST/users/{username}/todos
	
	@PostMapping("/users/{username}/todos") //no need to pass the id, you will pass the id inside the application
    public ResponseEntity<Void> updateTodo(
    		@PathVariable String username, @RequestBody Todo todo ){
		
		Todo createdTodo = todoService.save(todo);
		
		//location
		//Get current resource url
		//{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	

}

/*
 * Deciding what status to use
 * 
 * 3. Edit/ Update a Todo→ PUT/users/{username}/todos/{id}
 * 
 * 4. Create a new Todo→ POST/users/{username}/todos
 * 
 */
