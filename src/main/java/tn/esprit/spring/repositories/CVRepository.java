package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CV;

@Repository
public interface CVRepository extends CrudRepository<CV, String> {

}
