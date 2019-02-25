package controller;

import utils.SaveLoadAble;
import utils.Text;

public class VictoryPointManager implements SaveLoadAble {

	private int currentVictoryPoints = 0, targetVictoryPoints = -1;
	private int currentVictoryPointsSave = 0, targetVictoryPointsSave = -1;
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

	public void addCurrentVictoryPoints(int victoryPoints) {

		this.currentVictoryPoints += victoryPoints;
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
		return this.currentVictoryPoints >= this.targetVictoryPoints;
	}

	public void resetScoring() {

		this.currentVictoryPoints = 0;
		this.targetVictoryPoints -= 5;
		updateText();

	}

	@Override
	public void saveState() {

		this.currentVictoryPointsSave = currentVictoryPoints;
		this.targetVictoryPointsSave = targetVictoryPoints;

	}

	@Override
	public void loadState() {

		this.currentVictoryPoints = this.currentVictoryPointsSave;
		this.targetVictoryPoints = this.targetVictoryPointsSave;
		updateText();

	}

}
