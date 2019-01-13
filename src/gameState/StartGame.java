package gameState;

import tiles.Ship;
import tiles.ShipBlack;
import tiles.Tile;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tileA = new Ship();
		tileA.createImageView();

		System.out.println(tileA instanceof Tile);
		System.out.println(tileA instanceof Ship);
		System.out.println(tileA instanceof ShipBlack);

	}

}
