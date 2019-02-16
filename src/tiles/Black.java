package tiles;

import enums.TileTypeEnum;

public class Black extends Tile {

	public Black() {

		super("black");
		setCredentials();

	}

	private void setCredentials() {
		super.tileTypeEnum = TileTypeEnum.BLACK;
	}

}
