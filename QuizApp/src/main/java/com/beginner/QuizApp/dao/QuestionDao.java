package com.beginner.QuizApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beginner.QuizApp.model.Question;

public interface QuestionDao extends JpaRepository<Question,Integer>{

	List<Question> findByCategory(String string);
 
	@Query(value="SELECT * FROM question q WHERE q.category =:category ORDER BY RAND() LIMIT :numberOfQue",nativeQuery=true)
	List<Question> findRandomQuestionByCategory(String category,int numberOfQue);
}

//It is redundant to annotate the interfaces/classes with @Repository which extend/implement JpaRepository or some other predefined interfaces extending Repository, both because of @EnableJpaRepositories and the fact that they extend/implement Repository interface.

//to specify the variable in query then use colon before it

