package controller;

import utils.Text;

public class VictoryPointManager {

	private int currentScore = 0, targetScore = -1;
	private String victoryPointIndicator = "VP: ", seperator = " / ";
	private Text text = null;

	public VictoryPointManager() {
		createTextScore();
	}

	private void createTextScore() {

		this.text = new Text();

		this.text.setHeight(Credentials.textHeight);
		this.text.relocate(Credentials.CoordinatesVictoryPointText.x, Credentials.CoordinatesVictoryPointText.y);

	}

	public void updateCurrentScore(int value) {

		this.currentScore += value;
		updateScore();

	}

	public void updateTargetScore(int value) {

		this.targetScore = value;
		updateScore();

	}

	private void updateScore() {

		String currentScoreText = Integer.toString(this.currentScore);

		if (currentScoreText.length() == 1)
			currentScoreText = "0" + currentScoreText;

		String targetScoreText = Integer.toString(this.targetScore);

		if (targetScoreText.length() == 1)
			targetScoreText = "0" + targetScoreText;

		String updateScoreText = this.victoryPointIndicator;
		updateScoreText += currentScoreText;
		updateScoreText += this.seperator;
		updateScoreText += targetScoreText;

		this.text.setText(updateScoreText);

	}

	public boolean currentScoreReachesToargerScore() {
		return this.currentScore >= this.targetScore;
	}

}
