package co.edu.uptc.users.service;

import co.edu.uptc.users.model.dtos.UserDto;
import co.edu.uptc.users.model.entity.Role;
import co.edu.uptc.users.model.entity.User;

public interface UserService {
	String getUsers();
	
	User createUser(UserDto userData, Role role);
}
