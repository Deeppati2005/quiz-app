package com.demo.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.spring.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);

	@Query(value = "select q.id from question q where q.category=:category order by random() limit :numQ",nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(String category, int numQ);

}
