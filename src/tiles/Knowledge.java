package tiles;

import enums.TileTypeEnum;

public class Knowledge extends Tile {

	private int tileNumber = -1;

	public Knowledge(int tileNumber) {

		super("knowledge/" + tileNumber);
		setCredentials(tileNumber);
	}

	protected Knowledge(int tileNumber, String filePath) {

		super("knowledge/" + tileNumber + filePath);
		setCredentials(tileNumber);

	}

	private void setCredentials(int tileNumber) {

		this.tileNumber = tileNumber;
		super.tileTypeEnum = TileTypeEnum.KNOWLEDGE;

	}

	public int getTileNumber() {
		return this.tileNumber;
	}

}
