package gameState;

import enums.TextEnum;
import enums.TileTypeEnum;
import model.BoardSpace;
import tiles.Tile;

public class ChooseSpaceForStartingCastle extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.CHOOSE_SPACE_FOR_STARTING_CASTLE);

	}

	@Override
	public void handleBoardSpacePressed(BoardSpace boardSpacePressed, TileTypeEnum tileTypeEnum, int diceValue) {

		if (tileTypeEnum != TileTypeEnum.CASTLE)
			return;

		super.controller.textManager().concealText();

		Tile tile = super.controller.tileManager().getRandomTileNormalSetVisibleTrue(TileTypeEnum.CASTLE);
		boardSpacePressed.addTileAndRelocate(tile);

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
