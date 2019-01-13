package gameState;

import tiles.Sheep;
import tiles.Tile;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tile = new Sheep(4);
		tile.createImageView();

	}

}
