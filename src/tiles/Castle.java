package tiles;

import enums.TileTypeEnum;

public class Castle extends Tile {

	public Castle() {

		super("castle");
		setCredentials();

	}

	protected Castle(String filePath) {

		super("castle" + filePath);
		setCredentials();

	}

	private void setCredentials() {
		super.tileTypeEnum = TileTypeEnum.CASTLE;
	}

}
