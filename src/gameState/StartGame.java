package gameState;

import enums.AnimalTypeEnum;
import tiles.*;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tile = new AnimalBlack(AnimalTypeEnum.HEN, 4);
		tile.createImageView();

	}

}
