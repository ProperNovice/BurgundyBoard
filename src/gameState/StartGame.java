package gameState;

import enums.AnimalTypeEnum;
import tiles.*;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tile = new Animal(AnimalTypeEnum.HEN, 3);
		tile.createImageView();
		
	}

}
