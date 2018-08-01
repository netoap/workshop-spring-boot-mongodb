package com.alex.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alex.workshopmongo.domain.User;
import com.alex.workshopmongo.dto.UserDTO;
import com.alex.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResources {
	
	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET)
	// o de cima ou @GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
//		User alex = new User("1", "Alex Neto", "alex@gmail.com");
//		User marcio = new User("2", "Marcio Neto", "marcio@gmail.com");		
		List<User> users = service.findAll();
		List<UserDTO> listDto = users.stream().map(x->new UserDTO(x)).collect(Collectors.toList());
//		users.addAll(Arrays.asList(alex,marcio));
//		users.add(alex);
//		users.add(marcio);
		
		return ResponseEntity.ok().body(listDto);
	}

}
