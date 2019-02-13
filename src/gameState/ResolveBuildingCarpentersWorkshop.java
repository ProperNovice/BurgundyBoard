package gameState;

import enums.TextEnum;
import enums.TileTypeEnum;

public class ResolveBuildingCarpentersWorkshop extends ResolveBuildingTakeTileFromTheGameBoard {

	public ResolveBuildingCarpentersWorkshop() {

		super.tileTypesToAdd.addLast(TileTypeEnum.BUILDING);
		super.textEnumToShow = TextEnum.CHOOSE_A_BUILDING;

	}

}
