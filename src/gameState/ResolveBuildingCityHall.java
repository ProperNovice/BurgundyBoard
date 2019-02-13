package gameState;

import enums.TextEnum;

public class ResolveBuildingCityHall extends GameState {

	@Override
	public void handleGameStateChange() {
		
		super.controller.textManager().showText(TextEnum.CHOOSE_TILE_AND_BOARD_SPACE);

	}

}
