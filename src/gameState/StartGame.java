package gameState;

import tiles.*;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tile = new SheepBlack(3);
		tile.createImageView();

	}

}
