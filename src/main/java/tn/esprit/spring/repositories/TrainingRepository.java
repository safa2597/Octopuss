package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Profile;
import tn.esprit.spring.entities.Training;

public interface TrainingRepository extends CrudRepository<Training, Long>{

	@Query("Select t From Training t, Profile p where t.domaine=p.domaine ")
	List<Training> suggererTraining();
	@Query("Select count(t) From Training t where t.idTrain=?1 ")
	public int compterParticipants(Long idTrain);

}
