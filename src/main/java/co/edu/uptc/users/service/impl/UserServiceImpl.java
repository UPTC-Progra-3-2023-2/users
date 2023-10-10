package co.edu.uptc.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uptc.users.model.dtos.UserDto;
import co.edu.uptc.users.model.entity.Role;
import co.edu.uptc.users.model.entity.User;
import co.edu.uptc.users.repository.dao.UsersDAO;
import co.edu.uptc.users.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersDAO dao;

	@Override
	public String getUsers() {
		// TODO Auto-generated method stub
		return "Hello word by service";
	}

	@Override
	public User createUser(UserDto userData, Role role) {
		User user = new User();
		user.setFirstName(userData.getFirstName());
		user.setLastName(userData.getLastName());
		user.setPassword(userData.getPassword());
		user.setUserName(userData.getUserName());
		user.setEmail(userData.getEmail());
		user.setRole(role);
		
		return dao.createUser(user);
		
	}

}
