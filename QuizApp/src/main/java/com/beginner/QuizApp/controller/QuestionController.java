package com.beginner.QuizApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beginner.QuizApp.model.Question;
import com.beginner.QuizApp.service.QuestionService;

@RestController
@RequestMapping("Question")
public class QuestionController {
	 @Autowired
	 private QuestionService questionService; 

     @GetMapping("allQuestion")
	 public ResponseEntity<List<Question>> getAllQuestion() {
		return questionService.getAllQuestion();
     }
     @GetMapping("category/{topic}")
     public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("topic") String category){
    	 return questionService.getQuestionByCategory(category);
     }
     
     @PostMapping(path="addQuestion")
     public ResponseEntity<String> addQuestion(@RequestBody Question question) {
     	 return questionService.addQuestion(question);
     }
     
     @DeleteMapping("deleteQuestion/{id}")
     public ResponseEntity<String> deleteQuestion(@PathVariable("id") int id) {
    	return questionService.deleteQuestion(id);
     }
}

//@RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object. Spring automatically deserializes the JSON into a Java type, assuming an appropriate one is specified.
//ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response. If we want to use it, we have to return it from the endpoint; Spring takes care of the rest. ResponseEntity is a generic type.