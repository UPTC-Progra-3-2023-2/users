package co.edu.uptc.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.users.model.dtos.RolesDto;
import co.edu.uptc.users.model.entity.Role;
import co.edu.uptc.users.service.RolesService;
import jakarta.validation.Valid;

@RequestMapping(value = "/api/v1/roles")
@RestController
public class RolesController {
	@Autowired
	private RolesService service;
	
	@PostMapping("")
	public ResponseEntity<Role> createRole(@Valid @RequestBody RolesDto body) {
		Role newRole = this.service.createRole(body);
		return ResponseEntity.ok(newRole);
	}
}
