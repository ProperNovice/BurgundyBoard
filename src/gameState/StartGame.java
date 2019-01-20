package gameState;

import enums.AnimalTypeEnum;
import tiles.Animal;
import tiles.Tile;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tile = new Animal(AnimalTypeEnum.HEN, 2);
		tile.setVisible(true);
		tile.relocate(1000, 100);

	}

}
