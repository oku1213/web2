package model;

import java.io.Serializable;

public class Todo implements Serializable {
	private String title;
	private int degree;
	private int id;
	
	public Todo() {}
	public Todo(String title, int degree) {
		this.title = title;
		this.degree = degree;
	}
	public Todo(int id, String title, int degree) {
		this(title, degree);
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}