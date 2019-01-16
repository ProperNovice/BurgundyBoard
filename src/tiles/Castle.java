package tiles;

import enums.TileTypeEnum;

public class Castle extends Tile {

	public Castle() {
		
		super.tileTypeEnum = TileTypeEnum.CASTLE;
		super.filePath += "castle";
		
	}

}
