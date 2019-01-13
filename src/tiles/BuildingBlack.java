package tiles;

import enums.BuildingTypeEnum;

public class BuildingBlack extends Building {

	public BuildingBlack(BuildingTypeEnum buildingTypeEnum) {

		super(buildingTypeEnum);
		super.path += "B";

	}

}
