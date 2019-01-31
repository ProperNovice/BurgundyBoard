package gameState;

import enums.TextEnum;
import enums.TileTypeEnum;
import tiles.Tile;

public class ChooseTileToDiscard extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.CHOOSE_A_TILE_TO_DISCARD);

	}

	@Override
	protected void handleTileStorageSpacePriorPressed(Tile tile, TileTypeEnum tileTypeEnum) {

		super.controller.textManager().concealText();
		super.controller.storageSpaceManager().removeTileAndRelocate(tile);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
