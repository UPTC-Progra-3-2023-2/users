package co.edu.uptc.users.repository.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uptc.users.model.entity.Role;
import co.edu.uptc.users.repository.RolesRepository;
import co.edu.uptc.users.repository.dao.RolesDAO;

@Repository
public class RolesDAOImpl implements RolesDAO{
	
	@Autowired
	private RolesRepository repository;
	
	@Override
	public Role createRole(Role role) {
		return this.repository.save(role);
	}

	@Override
	public Role findRoleByName(String name) {
		Optional<Role> role = this.repository.findByName(name);;
		return role.orElse(null);
	}

}
