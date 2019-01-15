package board;

import enums.Dimensions;
import enums.TileTypeEnum;
import utils.Logger;

public class Space {

	private TileTypeEnum tileTypeEnum = null;
	private int diceValue;
	private double centerX, centerY;

	public Space(TileTypeEnum tileTypeEnum, int diceValue, double centerX, double centerY) {

		this.tileTypeEnum = tileTypeEnum;
		this.diceValue = diceValue;
		this.centerX = centerX;
		this.centerY = centerY;

	}

	public boolean contains(double x, double y) {

		double topX = centerX - Dimensions.DICE_AREA_IN_SPACE.x() / 2;
		double topY = centerY - Dimensions.DICE_AREA_IN_SPACE.y() / 2;

		if (x < topX)
			return false;

		if (x > topX + Dimensions.DICE_AREA_IN_SPACE.x())
			return false;

		if (y < topY)
			return false;

		if (y > topY + Dimensions.DICE_AREA_IN_SPACE.y())
			return false;

		return true;

	}

	public void print() {
		Logger.log(this.tileTypeEnum + " - " + this.diceValue);
	}

}
