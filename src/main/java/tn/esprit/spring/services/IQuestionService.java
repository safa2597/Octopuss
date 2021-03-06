package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Question;

public interface IQuestionService {

	public Question addQuestion(Question q,Long idQuiz);
	public Question updateQuestion(Question q);
	public List<Question> findQuestions();
	public void deleteQuestion(Long idQ);
	void deleteQuestion(Question q);
	void affecterQuestionaQuiz(Long idQ, Long idQuiz);
	public void ajouterQuestionEtAffecterQuiz(Question q, Long idQuiz);
}
