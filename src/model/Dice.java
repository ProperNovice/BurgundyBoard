package model;

import enums.DiceColor;
import utils.EventHandler.EventHandlerAble;
import utils.HashMap;
import utils.Image;
import utils.ImageView;
import utils.Logger;
import utils.Random;

public class Dice implements EventHandlerAble {

	private DiceColor diceColor = null;
	private ImageView imageView = null;
	private HashMap<Integer, Image> sides = new HashMap<>();
	private int diceValue;

	public Dice(DiceColor diceColor) {

		this.diceColor = diceColor;
		createSides();
		createImageView();

	}

	private void createSides() {

		String directoryPath = "dice/";
		directoryPath += this.diceColor.getText();
		directoryPath += "/";

		String png = ".png";

		for (int counter = 1; counter <= 6; counter++) {
			this.sides.put(counter, new Image(directoryPath + counter + png));
		}

	}

	private void createImageView() {
		this.imageView = new ImageView(this.sides.get(1), this);
		this.imageView.setVisible(false);
	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

	public void rollDice() {

		this.diceValue = Random.getRandomNumber(1, 6);
		this.imageView.setImage(this.sides.get(this.diceValue));
		this.imageView.setVisible(true);

		Logger.log(this.diceColor + " - " + this.diceValue);

	}

	public int getDiceValue() {
		return this.diceValue;
	}

	public void testSetValue(int diceValue) {

		this.diceValue = diceValue;
		this.imageView.setImage(this.sides.get(this.diceValue));
		this.imageView.setVisible(true);

		Logger.log("dice set value " + this.diceColor + " - " + this.diceValue);

	}

}
