package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Long>{

}
