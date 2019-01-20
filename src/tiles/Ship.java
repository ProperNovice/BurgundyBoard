package tiles;

import enums.TileTypeEnum;

public class Ship extends Tile {

	public Ship() {

		super("ship");
		setCredenetials();

	}

	protected Ship(String filePath) {

		super("ship" + filePath);
		setCredenetials();

	}

	private void setCredenetials() {
		super.tileTypeEnum = TileTypeEnum.SHIP;
	}

}
