package com.alex.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alex.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResources {

	@RequestMapping(method=RequestMethod.GET)
	// o de cima ou @GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		User alex = new User("1", "Alex Neto", "alex@gmail.com");
		User marcio = new User("2", "Marcio Neto", "marcio@gmail.com");		
		List<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(alex,marcio));
//		users.add(alex);
//		users.add(marcio);
		
		return ResponseEntity.ok().body(users);
	}

}
