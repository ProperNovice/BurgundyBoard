package board;

import enums.Dimensions;
import enums.TileTypeEnum;

public class SpaceBuilder {

	private TileTypeEnum tileTypeEnum = null;
	private int diceValue = -1;
	private double centerX, centerY;

	public SpaceBuilder() {

	}

	public SpaceBuilder tileTypeEnum(TileTypeEnum tileTypeEnum) {
		this.tileTypeEnum = tileTypeEnum;
		return this;
	}

	public SpaceBuilder diceValue(int diceValue) {
		this.diceValue = diceValue;
		return this;
	}

	public SpaceBuilder topLeftX(double topLeftX) {
		this.centerX = topLeftX + Dimensions.DICE_AREA_IN_SPACE.x() / 2;
		return this;
	}

	public SpaceBuilder topLeftY(double topLeftY) {
		this.centerY = topLeftY + Dimensions.DICE_AREA_IN_SPACE.y() / 2;
		return this;
	}

	public Space create() {
		return new Space(this.tileTypeEnum, this.diceValue, this.centerX, this.centerY);
	}

}
