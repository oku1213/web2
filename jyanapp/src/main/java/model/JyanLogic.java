package model;

import java.util.Random;

public class JyanLogic {
	public void execute(Jyan jyan) {
		Random rand = new Random();
		int idx = rand.nextInt(3);
		String[] hands = {"グー","チョキ","パー"};
		jyan.setPcHand(hands[idx]);
		
		String result;
		if(jyan.getUserHand().equals(jyan.getPcHand())) {
			result ="Draw";
		}else if(
			jyan.getUserHand().equals("グー") && jyan.getPcHand().equals("チョキ")
			|| jyan.getUserHand().equals("チョキ") && jyan.getPcHand().equals("パー")
			|| jyan.getUserHand().equals("パー") && jyan.getPcHand().equals("グー")
			) {
			result = "You Win!!";
			jyan.setWin(jyan.getWin()+1);
		}else {
			result = "You Lose...";
			jyan.setLose(jyan.getLose()+1);
		}
		jyan.setResult(result);

	}

}
