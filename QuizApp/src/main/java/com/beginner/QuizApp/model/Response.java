package com.beginner.QuizApp.model;

public class Response {
  private int id;
  public Response(int id, String respone) {
	super();
	this.id = id;
	this.response = respone;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getResponse() {
	return response;
}
public void setRespone(String respone) {
	this.response = respone;
}
private String response;
}
