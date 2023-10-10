package co.edu.uptc.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uptc.users.model.entity.Role;

public interface RolesRepository extends JpaRepository<Role, String>{
	Optional<Role> findByName(String name);
}
