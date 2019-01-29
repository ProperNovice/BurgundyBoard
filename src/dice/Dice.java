package dice;

import enums.DiceColor;
import utils.EventHandler.EventHandlerAble;
import utils.HashMap;
import utils.Image;
import utils.ImageView;

public class Dice implements EventHandlerAble {

	private DiceColor diceColor = null;
	private ImageView imageView = null;
	private HashMap<Integer, Image> sides = new HashMap<>();

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

//		this.imageView = new imagev
		
	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

}
