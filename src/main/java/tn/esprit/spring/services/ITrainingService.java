package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;

public interface ITrainingService {
	
	public Training addTraining(Training Training);
	public Training updateTraining(Training Training);
	public List<Training> findTrainings();
	public void deleteTraining(Long idTrain);
	void deleteTraining(Training Training);
	public void ajouterUserEtaffecterListeformations(User user, List<Long> idtraining);
	public void affecterUserAFormation(Long id, Long idTrain);

}
