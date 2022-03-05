package tn.esprit.spring.repositories;


import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Abonnement;



public interface AbonnementRepository extends CrudRepository<Abonnement, Long> {
	Abonnement findByFrais(float frais);

}
