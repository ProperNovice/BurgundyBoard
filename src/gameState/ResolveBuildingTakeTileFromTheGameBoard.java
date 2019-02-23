package gameState;

import enums.GameStateEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import tiles.Tile;
import utils.ArrayList;

public abstract class ResolveBuildingTakeTileFromTheGameBoard extends GameState {

	protected ArrayList<TileTypeEnum> tileTypesToAdd = new ArrayList<>();
	protected TextEnum textEnumToShow = null;

	public void handleGameStateChange() {

		super.controller.textManager().showText(this.textEnumToShow);

	}

	@Override
	protected void handleTileDepotNumberedPressed(Tile tile, TileTypeEnum tileTypeEnum, int depotNumberedValue) {

		if (!this.tileTypesToAdd.contains(tileTypeEnum))
			return;

		super.controller.textManager().concealText();

		super.controller.depotNumberedManager().removeTileAndRelocate(tile);
		super.controller.storageSpaceManager().addTileAndRelocate(tile);

		if (super.controller.storageSpaceManager().exceedsMaxedCapacity())
			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_TILE_TO_DISCARD);

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
