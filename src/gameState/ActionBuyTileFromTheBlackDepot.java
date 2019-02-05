package gameState;

import enums.ActionEnum;
import tiles.Tile;

public class ActionBuyTileFromTheBlackDepot extends GameState {

	private Tile tileSelected = null;
	private boolean actionCanBeExecuted;

	@Override
	public void handleGameStateChange() {

		super.controller.actionManager().showAction(ActionEnum.BUY_TILE_FROM_THE_BLACK_DEPOT);

	}

}
