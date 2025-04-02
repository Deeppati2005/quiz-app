package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.Question;
import com.demo.spring.model.QuestionWrapper;
import com.demo.spring.model.Response;
import com.demo.spring.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@Autowired
    Environment environment;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello alien";
	}
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return service.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
		return service.getQuestionsByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
	   return service.addQuestion(question);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
	   return service.updateQuestion(question);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
	   return service.deleteQuestion(id);
	}
	
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam int numQuestions){
		return service.getQuestionsForQuiz(categoryName,numQuestions);
	}
	
	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
		System.out.println(environment.getProperty("local.server.port"));
		return service.getQuestionsFromId(questionIds);
	}
	
	@PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return service.getScore(responses);
    }
}
