package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Offre;

@Repository
public interface OfffreRepository extends CrudRepository< Offre, Long>{

}
/*@Query("Select COUNT(u) FROM User u,Postulant p where   p.offres.idOffre=:offre and p.users=u ")
int nbrePosParOffre(@Param("offre") int offre);*/