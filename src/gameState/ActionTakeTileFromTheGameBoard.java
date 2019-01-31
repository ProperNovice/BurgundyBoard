package gameState;

import enums.ActionEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import tiles.Tile;

public class ActionTakeTileFromTheGameBoard extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.actionManager().showAction(ActionEnum.TAKE_TILE_FROM_THE_GAME_BOARD);
		super.controller.textManager().showText(TextEnum.CHOOSE_A_TILE);

	}

	@Override
	protected void handleTileDepotNumberedPressed(Tile tile, TileTypeEnum tileTypeEnum) {

		super.controller.textManager().concealText();

		if (super.controller.storageSpaceManager().isMaxedCapacty()) {
			System.out.println("maxed");
			return;
		}

		super.controller.depotNumberedManager().removeTile(tile);

		super.controller.storageSpaceManager().addTileAndRelocate(tile);

	}

}
