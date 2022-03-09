package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Profile;
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
	
	@Query("select p from Profile p , Offre o where p.domaine=o.profile")
public List<Profile> compterProfile();

}
