package tn.esprit.spring.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.TrainingRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class TrainingService implements ITrainingService{
	
	@Autowired
	TrainingRepository tr;
	@Autowired
	UserRepository ur;

	@Override
	public Training addTraining(Training Training) {
		return tr.save(Training);
	}

	@Override
	public Training updateTraining(Training Training) {
		return tr.save(Training);
	}

	@Override
	public List<Training> findTrainings() {
		
		return (List<Training>)tr.findAll();
	}

	@Override
	public void deleteTraining(Long idTrain) {
		tr.deleteById(idTrain);
		
	}

	@Override
	public void deleteTraining(Training Training) {
		tr.delete(Training);
		
	}
	
	@Override
	public void ajouterUserEtaffecterListeformations(User user, List<Long> idtrainings) {
		ur.save(user);
		for (Long idtraining : idtrainings) {
			Training training = tr.findById(idtraining).orElse(null);
			training.getUsers().add(user);
		}
		
	}
	@Transactional
	@Override
	public void affecterUserAFormation(Long id, Long idTrain) {
		User u = ur.findById(id).get();
		Training t = tr.findById(idTrain).get();
		u.getTrainings().add(t);
		//sr.save(s);
	}

	@Override
	public List<Training> suggererTraining() {
		return tr.suggererTraining();
	}
	@Transactional
	@Override
	public int participer(Long id, Long idTrain){
		User u = ur.findById(id).get();
		Training t = tr.findById(idTrain).get();
		u.getTrainings().add(t);
		t.setNbParticipant(tr.compterParticipants(idTrain));
		return tr.compterParticipants(idTrain);
	}
	

}
