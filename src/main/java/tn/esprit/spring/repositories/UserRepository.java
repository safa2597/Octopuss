package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserName(String UserName);
	
}
