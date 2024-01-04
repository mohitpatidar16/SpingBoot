package com.beginner.QuizApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beginner.QuizApp.model.Quiz;


public interface QuizDao extends JpaRepository<Quiz,Integer>{
    	
}

