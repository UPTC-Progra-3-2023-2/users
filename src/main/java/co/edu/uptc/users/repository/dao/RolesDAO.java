package co.edu.uptc.users.repository.dao;

import co.edu.uptc.users.model.entity.Role;

public interface RolesDAO {
	Role createRole(Role role);
	
	Role findRoleByName(String name);
}
