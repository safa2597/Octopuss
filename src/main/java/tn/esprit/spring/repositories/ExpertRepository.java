package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Expert;
import tn.esprit.spring.entities.User;

public interface ExpertRepository extends JpaRepository<Expert, Long> {

	List<Expert> findByExpertType(String expertType);

}
