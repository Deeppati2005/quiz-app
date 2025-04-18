package com.demo.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
