package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private int id;
	private String userName;
	private String userText;
	
	public Mutter() {}

	public Mutter(int id, String userName, String userText) {
		this(userName, userText);
		this.id = id;
	}

	public Mutter(String userName, String userText) {
		this.userName = userName;
		this.userText = userText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserText() {
		return userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
	}
	

}
