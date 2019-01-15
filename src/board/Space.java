package board;

import enums.TileTypeEnum;

public class Space {

	private TileTypeEnum tileTypeEnum = null;
	private int diceValue = -1;

	public Space(TileTypeEnum tileTypeEnum, int diceValue) {

		this.tileTypeEnum = tileTypeEnum;
		this.diceValue = diceValue;

	}

}
