package co.edu.uptc.users.repository.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uptc.users.model.entity.User;
import co.edu.uptc.users.repository.UsersRepository;
import co.edu.uptc.users.repository.dao.UsersDAO;

@Repository
public class UsersDAOImpl implements UsersDAO {
	
	@Autowired
	private UsersRepository repository;

	@Override
	public User createUser(User user) {
		return this.repository.save(user);
	}

}
