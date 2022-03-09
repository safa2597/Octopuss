package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Quiz;

@Service
public interface IQuizService {
	public Quiz addQuiz(Quiz quiz,Long idTrain);
	public Quiz updateQuiz(Quiz quiz);
	public List<Quiz> findQuizs();
	public void deleteQuiz(Long idQuiz);
	void deleteQuiz(Quiz quiz);
	public void ajouterFormationEtaffecterListeQuizs(Long idTraining, Long idQuiz);
	public Quiz getQuestions();
	public int getResult(Quiz quiz);
}
