package co.edu.uptc.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uptc.users.model.entity.User;

public interface UsersRepository extends JpaRepository<User, String>{
}
