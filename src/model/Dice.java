package model;

import controller.Credentials;
import enums.DiceColor;
import instances.Instances;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
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
	private ImageView selectImageView = null;

	public Dice(DiceColor diceColor) {

		this.diceColor = diceColor;
		createSides();
		createImageViews();

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

	private void createImageViews() {

		this.imageView = new ImageView(this.sides.get(1), this);
		this.imageView.setVisible(false);

		this.selectImageView = new ImageView("select.png");
		this.selectImageView.setVisible(false);
		this.selectImageView.setWidth(Credentials.DimensionsSelectImageViewDice.x);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
		this.selectImageView.relocate(x, y);
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

	public void setSelected(boolean value) {
		this.selectImageView.setVisible(value);
	}

	public int getDiceValue() {
		return this.diceValue;
	}

	public void setValue(int diceValue) {

		this.diceValue = diceValue;
		this.imageView.setImage(this.sides.get(this.diceValue));
		this.imageView.setVisible(false);

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Logger.logNewLine(this.diceValue + " - dice value");

		Executor.runLater(() -> Instances.getControllerInstance().gameStateManager().getCurrentGameState()
				.handleDiceRedPressed(this, this.diceValue));

	}

}
