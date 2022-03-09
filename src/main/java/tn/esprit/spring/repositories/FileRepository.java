package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.File;

@Repository
public interface FileRepository extends CrudRepository<File, String> {

}
