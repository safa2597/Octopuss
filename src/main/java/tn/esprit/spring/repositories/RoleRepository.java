package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
