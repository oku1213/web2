package model;

import java.io.Serializable;

public class Jyan implements Serializable {
	private String userHand;
	private String pcHand;
	private String result;
	private int win;
	private int lose;
	
	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public Jyan() {}

	public String getUserHand() {
		return userHand;
	}

	public void setUserHand(String userHand) {
		this.userHand = userHand;
	}

	public String getPcHand() {
		return pcHand;
	}

	public void setPcHand(String pcHand) {
		this.pcHand = pcHand;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
