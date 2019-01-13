package tiles;

import enums.BuildingTypeEnum;

public class Building extends Tile {

	private BuildingTypeEnum buildingTypeEnum = null;

	public Building(BuildingTypeEnum buildingTypeEnum) {

		this.buildingTypeEnum = buildingTypeEnum;

		super.path += "buildings/";
		super.path += this.buildingTypeEnum.getText();

	}

	public BuildingTypeEnum getBuildingTypeEnum() {
		return this.buildingTypeEnum;
	}

}
