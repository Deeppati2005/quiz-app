package com.demo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.QuizDao;
import com.demo.spring.feign.QuizInterface;
import com.demo.spring.model.QuestionWrapper;
import com.demo.spring.model.Quiz;
import com.demo.spring.model.Response;

@Service
public class QuizService {

	@Autowired
	private QuizDao quizdao;
	
	@Autowired
	private QuizInterface quizInterface;
	
	public ResponseEntity<String> createQuiz(String categoryName, Integer numQuestions, String title) {
		
		List<Integer> questions = quizInterface.getQuestionsForQuiz(categoryName, numQuestions).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizdao.save(quiz);
		
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = quizdao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
	}
}
