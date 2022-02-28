package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole(String role);
}
