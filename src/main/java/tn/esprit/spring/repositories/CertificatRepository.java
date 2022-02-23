package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Certificat;

@Repository
public interface CertificatRepository extends CrudRepository<Certificat, Long>{

}
