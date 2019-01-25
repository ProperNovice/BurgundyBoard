package tiles;

import enums.BuildingTypeEnum;
import utils.Logger;

public class BuildingBlack extends Building {

	public BuildingBlack(BuildingTypeEnum buildingTypeEnum) {
		super(buildingTypeEnum, "B");
	}

	@Override
	protected void printTile() {
		super.printTile();
		Logger.log("Black");
	}

}
