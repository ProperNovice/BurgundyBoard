package tiles;

import enums.TileTypeEnum;

public class Knowledge extends Tile {

	private int tileNumber = -1;

	public Knowledge(int tileNumber) {

		this.tileNumber = tileNumber;
		super.tileTypeEnum = TileTypeEnum.KNOWLEDGE;

		super.filePath += "knowledge/";
		super.filePath += this.tileNumber;

	}

	public int getTileNumber() {
		return this.tileNumber;
	}

}
