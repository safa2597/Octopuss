package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.QuestionRepository;
import tn.esprit.spring.repositories.QuizRepository;
import tn.esprit.spring.repositories.TrainingRepository;

@Service
public class QuizService implements IQuizService{

	@Autowired
	QuizRepository quizr;
	@Autowired
	TrainingRepository tr;
	@Autowired
	Quiz quiz;
	
	@Autowired
	Question question;
	@Autowired
	QuestionRepository qRepo;
	
	
	
	
	
	@Override
	public Quiz addQuiz(Quiz quiz,Long idTrain) {
		
		Training training=tr.findById(idTrain).get();
		quiz.setTraining(training);
		return quizr.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return quizr.save(quiz);
	}

	@Override
	public List<Quiz> findQuizs() {
		
		return(List<Quiz>)quizr.findAll();
	}

	@Override
	public void deleteQuiz(Long idQuiz) {
		quizr.deleteById(idQuiz);
		
	}

	@Override
	public void deleteQuiz(Quiz quiz) {
		quizr.delete(quiz);
		
	}
	@Override
	public void ajouterFormationEtaffecterListeQuizs(Long idTraining, Long idQuiz) {
		Training train = tr.findById(idTraining).orElse(null);
		Quiz quiz = quizr.findById(idQuiz).orElse(null);
		quiz.setTraining(train);
		quizr.save(quiz);
	}
	

	@Transactional
	public void ajouterQuestionsEtAffecterAquiz(long idQuiz, List<Question> questions) {
		Quiz q = quizr.findById(idQuiz).get();
		q.getQuestions().addAll(questions);
		//ur.save(u);
	}
	
	
	
	@Override
	public Quiz getQuestions() {
		List<Question> allQues = (List<Question>) qRepo.findAll();
		List<Question> qList = new ArrayList<Question>();
		
		Random random = new Random();
		
		for(int i=0; i<5; i++) {
			int rand = random.nextInt(allQues.size());
			qList.add(allQues.get(rand));
			allQues.remove(rand);
		}

		quiz.setQuestions(qList);
		quizr.save(quiz);
		
		return quiz;
	}
	@Override
	public int getResult(Quiz quiz) {
		int correct = 0;
		
		for(Question q: quiz.getQuestions())
			if(q.getAns() == q.getChose())
				correct++;
		
		return correct;
	}
	
}
