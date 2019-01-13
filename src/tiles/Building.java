package tiles;

import enums.BuildingTypeEnum;
import enums.TileTypeEnum;

public class Building extends Tile {

	private BuildingTypeEnum buildingTypeEnum = null;

	public Building(BuildingTypeEnum buildingTypeEnum) {

		this.buildingTypeEnum = buildingTypeEnum;
		super.tileTypeEnum = TileTypeEnum.BUILDING;

		super.path += "buildings/";
		super.path += this.buildingTypeEnum.getText();

	}

	public BuildingTypeEnum getBuildingTypeEnum() {
		return this.buildingTypeEnum;
	}

}
