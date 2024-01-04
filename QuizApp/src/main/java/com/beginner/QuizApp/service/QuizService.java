package com.beginner.QuizApp.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.beginner.QuizApp.dao.QuestionDao;
import com.beginner.QuizApp.dao.QuizDao;
import com.beginner.QuizApp.model.Question;
import com.beginner.QuizApp.model.QuestionWrapper;
import com.beginner.QuizApp.model.Quiz;
import com.beginner.QuizApp.model.Response;

@Service
public class QuizService {
	
	@Autowired 
	private QuizDao quizDao;
	@Autowired
	private QuestionDao questionDao;
	
	public ResponseEntity<String> createQuiz(String category, int numberOfQue, String title) {
		
		List<Question> questions=questionDao.findRandomQuestionByCategory(category,numberOfQue);
		
	    Quiz quiz=new Quiz();
	    quiz.setTitle(title);
	    quiz.setQuestion(questions);
	    quizDao.save(quiz);
	    
	    return new ResponseEntity<>("quiz created",HttpStatus.CREATED);
	    
	}
	
	

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
		Optional<Quiz> quiz=quizDao.findById(id);
		
		List<Question> questionFromDb=quiz.get().getQuestion();
		
		List<QuestionWrapper> questionForUser=new ArrayList<>();
		
		for(Question q:questionFromDb) {
		QuestionWrapper qr=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qr);
		}
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
	     
		int marks=0;
		for(Response r:responses) {
			Question q=questionDao.findById(r.getId()).get();
	        
			if(r.getResponse().equals(q.getRightAnswer()))
			{
				marks++;
			}
			
		}
		return new ResponseEntity<>(marks,HttpStatus.OK);	
	}
}
//The get() method of java.util.Optional class in Java is used to get the value of this Optional instance. If there is no value present in this Optional instance, then this method throws NullPointerException.
