package gameState;

import enums.BuildingTypeEnum;
import tiles.*;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tile = new BuildingBlack(BuildingTypeEnum.WATCHTOWER);
		tile.createImageView();

	}

}
