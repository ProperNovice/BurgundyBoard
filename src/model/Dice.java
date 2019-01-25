package model;

import enums.DiceColor;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public class Dice implements EventHandlerAble {

	private DiceColor diceColor = null;
	private int value;
	private ImageView imageView = null;

	public Dice(DiceColor diceColor, int value) {

		this.diceColor = diceColor;
		this.value = value;
		createImageView();

	}

	private void createImageView() {

		String path = "dice/";
		path += this.diceColor.getText();
		path += this.value;
		path += ".png";

		this.imageView = new ImageView(path, this);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

}
