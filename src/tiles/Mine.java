package tiles;

import enums.TileTypeEnum;

public class Mine extends Tile {
	
	public Mine() {
		
		super.tileTypeEnum = TileTypeEnum.MINE;
		super.filePath += "mine";
		
	}

}
