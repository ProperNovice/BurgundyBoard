package tiles;

import enums.TileTypeEnum;

public class Ship extends Tile {

	public Ship() {

		super.tileTypeEnum = TileTypeEnum.SHIP;
		super.filePath += "ship";

	}

}
