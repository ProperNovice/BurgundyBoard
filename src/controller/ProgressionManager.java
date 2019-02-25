package controller;

import utils.Text;

public class ProgressionManager {

	private Text text = null;

	public ProgressionManager() {
		createText();
	}

	private void createText() {

		this.text = new Text();

		this.text.setHeight(Credentials.textHeight);
		this.text.relocate(Credentials.CoordinatesProgression.x, Credentials.CoordinatesProgression.y);

	}

	public void setProgression(String string) {
		this.text.setText(string);
	}

}
