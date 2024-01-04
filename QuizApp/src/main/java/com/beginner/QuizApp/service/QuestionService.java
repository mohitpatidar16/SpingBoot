package com.beginner.QuizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.beginner.QuizApp.dao.QuestionDao;
import com.beginner.QuizApp.model.Question;

@Service
public class QuestionService {
	@Autowired
    private QuestionDao questionDao;
	
	
	
	public ResponseEntity<List<Question>> getAllQuestion() {
		try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category){
		try {
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	
	
	public ResponseEntity<String> addQuestion(Question question) {
		try {
		questionDao.save(question);
		return new ResponseEntity<>("Question added Successfully",HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Question not addes",HttpStatus.INSUFFICIENT_STORAGE);
	}
	
	
	
	public ResponseEntity<String> deleteQuestion(int id) {

		
			if(questionDao.existsById(id))
			{
				questionDao.deleteById(id);
				return new ResponseEntity<>("Question deleted Successfully",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Question with id="+id+" not present in database",HttpStatus.BAD_REQUEST);
			}			
    }
}