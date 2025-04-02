package com.demo.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.QuestionDao;
import com.demo.spring.model.Question;
import com.demo.spring.model.QuestionWrapper;
import com.demo.spring.model.Response;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<List<Question>>(questionDao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<List<Question>>(questionDao.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<String>("Add Success", HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<String>("Update Success", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<String> deleteQuestion(int id) {
		questionDao.deleteById(id);
		return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {
		List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
		return new ResponseEntity<List<Integer>>(questions,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		List<QuestionWrapper> wrappers = new ArrayList<QuestionWrapper>();
		
		List<Question> questions = new ArrayList<Question>();
		
		for(Integer id : questionIds) {
			questions.add(questionDao.findById(id).get());
		}
		
		for(Question question : questions) {
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			wrappers.add(wrapper);
		}
		return new ResponseEntity<List<QuestionWrapper>>(wrappers,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int right = 0;

        for(Response response : responses){
            Question question = questionDao.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer()))
            {
            	  right++;
            } 
        }
        return new ResponseEntity<Integer>(right, HttpStatus.OK);
	}
}
