package co.edu.uptc.users.service;

import co.edu.uptc.users.model.dtos.RolesDto;
import co.edu.uptc.users.model.entity.Role;

public interface RolesService {
	Role createRole(RolesDto rolesDto);
	
	Role findRoleByname(String name);
}
