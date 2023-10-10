package co.edu.uptc.users.interactor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.uptc.users.interactor.UserInteractor;
import co.edu.uptc.users.model.dtos.UserDto;
import co.edu.uptc.users.model.entity.Role;
import co.edu.uptc.users.model.entity.User;
import co.edu.uptc.users.service.RolesService;
import co.edu.uptc.users.service.UserService;

@Component
public class UserInteractorImpl implements UserInteractor {

	@Autowired
	private RolesService rolesService;
	
	@Autowired
	private UserService userService;

	@Override
	public User createUser(UserDto userData) {
		
		Role role = this.rolesService.findRoleByname(userData.getRoleName());
		
		User newUser = this.userService.createUser(userData, role);
		return newUser;
	}

}
