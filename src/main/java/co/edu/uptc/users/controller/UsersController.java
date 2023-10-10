package co.edu.uptc.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.users.interactor.UserInteractor;
import co.edu.uptc.users.model.dtos.UserDto;
import co.edu.uptc.users.model.entity.User;
import co.edu.uptc.users.service.UserService;
import jakarta.validation.Valid;

@RequestMapping(value = "/api/v1/users")
@RestController
@Validated
public class UsersController {
	
	@Autowired
	private UserInteractor interactor;
	
	@Autowired
	private UserService service;
	
	@GetMapping("")
	public String getUsers() {
		return this.service.getUsers();
	}
	
	@PostMapping("")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDto body) {
		User newUser = this.interactor.createUser(body);

		return ResponseEntity.ok(newUser);
	}
}
