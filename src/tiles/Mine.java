package tiles;

import enums.TileTypeEnum;

public class Mine extends Tile {

	public Mine() {

		super("mine");
		setCredentials();

	}

	protected Mine(String filePath) {

		super("mine" + filePath);
		setCredentials();

	}

	private void setCredentials() {
		super.tileTypeEnum = TileTypeEnum.MINE;
	}

}
