package tiles;

import enums.BuildingTypeEnum;
import enums.TileTypeEnum;
import utils.Logger;

public class Building extends Tile {

	private BuildingTypeEnum buildingTypeEnum = null;

	public Building(BuildingTypeEnum buildingTypeEnum) {

		super("buildings/" + buildingTypeEnum.getText());
		setCredentials(buildingTypeEnum);

	}

	protected Building(BuildingTypeEnum buildingTypeEnum, String filePath) {

		super("buildings/" + buildingTypeEnum.getText() + filePath);
		setCredentials(buildingTypeEnum);

	}

	private void setCredentials(BuildingTypeEnum buildingTypeEnum) {
		this.buildingTypeEnum = buildingTypeEnum;
		super.tileTypeEnum = TileTypeEnum.BUILDING;
	}

	public BuildingTypeEnum getBuildingTypeEnum() {
		return this.buildingTypeEnum;
	}

	@Override
	protected void printTile() {
		super.printTile();
		Logger.log(this.buildingTypeEnum);
	}

}
