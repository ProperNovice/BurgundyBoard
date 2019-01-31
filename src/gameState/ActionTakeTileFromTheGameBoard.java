package gameState;

import enums.ActionEnum;
import enums.TextEnum;

public class ActionTakeTileFromTheGameBoard extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.actionManager().showAction(ActionEnum.TAKE_TILE_FROM_THE_GAME_BOARD);
		super.controller.textManager().showText(TextEnum.CHOOSE_A_TILE);

	}

}
