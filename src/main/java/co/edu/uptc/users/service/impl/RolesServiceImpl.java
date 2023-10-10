package co.edu.uptc.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uptc.users.model.dtos.RolesDto;
import co.edu.uptc.users.model.entity.Role;
import co.edu.uptc.users.repository.dao.RolesDAO;
import co.edu.uptc.users.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {
	
	@Autowired
	private RolesDAO dao;
	
	@Override
	public Role createRole(RolesDto rolesDto) {
		Role role = new Role();
		role.setName(rolesDto.getRoleName().toUpperCase());
		
		return this.dao.createRole(role);
	}

	@Override
	public Role findRoleByname(String name) {
		return dao.findRoleByName(name);
	}

}
