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

import tn.esprit.spring.entities.Question;
import tn.esprit.spring.services.IQuestionService;

@RestController
public class QuestionController {

	@Autowired
	IQuestionService qs;

	@PostMapping("/add-Question")
	public Question addQuestion(@RequestBody Question q,@PathVariable("idQuiz") Long idQuiz) {
	Question Question = qs.addQuestion(q,idQuiz);
	return Question;
	}
	
	@DeleteMapping("/remove-Question/{Question-id}")
	public void removeQuestion(@PathVariable("Question-id") Long idQ) {
	qs.deleteQuestion(idQ);
	}
	
	@PutMapping("/modify-Question")
	public Question modifyQuestion(@RequestBody Question m) {
	return qs.updateQuestion(m);
	}
	
	@GetMapping("/retrieve-all-Questions")
	public List<Question> getQuestions() {
	List<Question> listQuestions = qs.findQuestions();
	return listQuestions;
	}
	@PutMapping("/affect-question-quiz/{idQ}/{idQuiz}")
	public void AffecterQuestionToQuiz(@PathVariable("idQ") Long idQ,@PathVariable("idQuiz") Long idQuiz){
		qs.affecterQuestionaQuiz(idQ, idQuiz);
	}
}
