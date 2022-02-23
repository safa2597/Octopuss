package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.ITrainingService;

@RestController
public class TrainingController {
	
	@Autowired
	ITrainingService ts;

	@PostMapping("/add-Training")
	public Training addTraining(@RequestBody Training tr) {
	Training Training = ts.addTraining(tr);
	return Training;
	}
	
	@DeleteMapping("/remove-Training/{Training-id}")
	public void removeTraining(@PathVariable("Training-id") Long idTrain) {
	ts.deleteTraining(idTrain);
	}
	
	@PutMapping("/modify-Training")
	public Training modifyTraining(@RequestBody Training tr) {
	return ts.updateTraining(tr);
	}
	
	@GetMapping("/retrieve-all-Trainings")
	public List<Training> getTrainings() {
	List<Training> listTrainings = ts.findTrainings();
	return listTrainings;
	}
	/*@PostMapping("/add-training/{idUsers}")
	public void ajouterEtAffecterTrainingUsers(@RequestBody User user, @PathVariable("idTrainings")List<Long> idTrainings){
		ts.ajouterUserEtaffecterListeformations(user, idTrainings);
	}*/
	@PutMapping("/affecter-formation-user/{id}/{id-tr}")
	public void affecterUserAFormation(@PathVariable("id") Long id, @PathVariable("id-tr")Long idTrain){
		ts.affecterUserAFormation(id, idTrain);
	}


}
