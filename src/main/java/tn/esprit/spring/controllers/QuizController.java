package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.Model;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.services.IQuizService;

@RestController
public class QuizController {
	@Autowired
	IQuizService qzs;

	@PostMapping("/add-Quiz")
	public Quiz addQuiz(@RequestBody Quiz qz,@PathVariable("idTraining") Long idTraining) {
	Quiz Quiz = qzs.addQuiz(qz,idTraining);
	return Quiz;
	}
	
	@DeleteMapping("/remove-Quiz/{Quiz-id}")
	public void removeQuiz(@PathVariable("Quiz-id") Long idQ) {
	qzs.deleteQuiz(idQ);
	}
	
	@PutMapping("/modify-Quiz")
	public Quiz modifyQuiz(@RequestBody Quiz qz) {
	return qzs.updateQuiz(qz);
	}
	
	@GetMapping("/retrieve-all-Quizs")
	public List<Quiz> getQuizs() {
	List<Quiz> listQuizs = qzs.findQuizs();
	return listQuizs;
	}
	@PutMapping("/add-training/{idTraining}/{idQuiz}")
	public void ajouterEtAffecterTrainingQuiz(@PathVariable("idTraining") Long idTraining,@PathVariable("idQuiz") Long idQuiz){
		qzs.ajouterFormationEtaffecterListeQuizs(idTraining, idQuiz);
	}
	
	@PostMapping("/submit")
	public Quiz submit(@RequestBody Quiz quiz) {
			quiz.setScore(qzs.getResult(quiz));
			return qzs.updateQuiz(quiz);
	}
	
	
}
