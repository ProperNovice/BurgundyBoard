package gameState;

import enums.TextEnum;
import enums.TileTypeEnum;

public class ResolveBuildingMarket extends ResolveBuildingTakeTileFromTheGameBoard {

	public ResolveBuildingMarket() {

		super.tileTypesToAdd.addLast(TileTypeEnum.ANIMAL);
		super.tileTypesToAdd.addLast(TileTypeEnum.SHIP);
		super.textEnumToShow = TextEnum.CHOOSE_AN_ANIMAL_OR_SHIP;

	}

}
