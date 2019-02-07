package gameState;

import enums.ActionEnum;
import enums.TileTypeEnum;
import model.BoardSpace;
import tiles.Tile;

public class ActionAddTileToYourEstate extends ExecuteDiceActions {

	public ActionAddTileToYourEstate() {
		super.actionEnumToShow = ActionEnum.ADD_TILE_TO_YOUR_ESTATE;
	}

	@Override
	public void handleBoardSpacePressed(BoardSpace boardSpacePressed, TileTypeEnum tileTypeEnum, int diceValue) {

	}

	@Override
	protected void handleTileStorageSpacePriorPressed(Tile tile, TileTypeEnum tileTypeEnum) {

	}

	@Override
	protected void checkSelected() {

	}

	@Override
	protected void executeAction() {

	}

}
