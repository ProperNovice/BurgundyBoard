package gameState;

import enums.TextEnum;
import enums.TileTypeEnum;

public class ResolveBuildingChurch extends ResolveBuildingTakeTileFromTheGameBoard {

	public ResolveBuildingChurch() {

		super.tileTypesToAdd.addLast(TileTypeEnum.MINE);
		super.tileTypesToAdd.addLast(TileTypeEnum.KNOWLEDGE);
		super.tileTypesToAdd.addLast(TileTypeEnum.CASTLE);
		super.textEnumToShow = TextEnum.CHOOSE_A_MINE_KNOWLEDGE_OR_CASTLE;

	}

}
