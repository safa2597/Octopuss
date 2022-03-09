package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Fiche;

@Repository
public interface FichierRepository extends CrudRepository<Fiche, String> {

}

