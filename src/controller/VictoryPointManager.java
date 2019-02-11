package controller;

import utils.Text;

public class VictoryPointManager {

	private int currentScore = -1, targetScore = -1;
	private String scoreString = null, seperator = null;
	private Text text = null;

	public VictoryPointManager() {

		createTextScore();

		this.scoreString = "ls";
		this.scoreString += "ls";
		System.out.println(this.scoreString);

	}

	private void createTextScore() {

		this.seperator = "/";

		this.text = new Text();
		this.text.setHeight(50);
		this.text.relocate(20, 20);

	}

	public void updateCurrentScore(int value) {
		this.currentScore = currentScore;
		updateScore();
	}

	public void updateTargetScore(int value) {
		this.targetScore = targetScore;
		updateScore();
	}

	private void updateScore() {

	}

}
