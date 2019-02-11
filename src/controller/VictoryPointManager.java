package controller;

import utils.Text;

public class VictoryPointManager {

	private int currentVictoryPoints = 0, targetVictoryPoints = -1;
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

	public void addCurrentVictoryPoints(int value) {

		this.currentVictoryPoints += value;
		updateText();

	}

	public void setTargetVictoryPoints(int value) {

		this.targetVictoryPoints = value;
		updateText();

	}

	private void updateText() {

		String currentScoreText = Integer.toString(this.currentVictoryPoints);

		if (currentScoreText.length() == 1)
			currentScoreText = "0" + currentScoreText;

		String targetScoreText = Integer.toString(this.targetVictoryPoints);

		if (targetScoreText.length() == 1)
			targetScoreText = "0" + targetScoreText;

		String updateScoreText = this.victoryPointIndicator;
		updateScoreText += currentScoreText;
		updateScoreText += this.seperator;
		updateScoreText += targetScoreText;

		this.text.setText(updateScoreText);

	}

	public boolean currentVictoryPointsReachedTargetVictoryPoints() {
		
		System.out.println(this.currentVictoryPoints);
		System.out.println(this.targetVictoryPoints);
		
		return this.currentVictoryPoints >= this.targetVictoryPoints;
	}

}
