package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{

}
