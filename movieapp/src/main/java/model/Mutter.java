package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private String userName;
	private String title;
	private String text;
	
	public Mutter() {}
	public Mutter(String userName, String title, String text) {
		this.userName = userName;
		this.title = title;
		this.text = text;
	}
	public String getUserName() {
		return userName;
	}
	public String getTitle() {
		return title;
	}
	public String getText() {
		return text;
	}
}