package com.beginner.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beginner.QuizApp.model.QuestionWrapper;
import com.beginner.QuizApp.model.Response;
import com.beginner.QuizApp.service.QuizService;

@RestController
@RequestMapping("Quiz")
public class QuizController {
  @Autowired
  private QuizService quizService;
  
  @PostMapping("create")
  public  ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numberOfQue,@RequestParam String title) {
	  return quizService.createQuiz(category,numberOfQue,title);
  }
  @GetMapping("getQuiz/{id}")
  public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id)
  {
	 return quizService.getQuizQuestion(id); 
  }
  @PostMapping("submit/{id}")
  public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
	  return quizService.calculateResult(id,responses);
  }
}
//@RequestParam and @PathVariable can both be used to extract values from the request URI, but they are a bit different.@RequestParams extract values from the query string, @PathVariables extract values from the URI path: