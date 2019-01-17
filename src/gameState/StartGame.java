package gameState;

import utils.Credentials;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {
		
		System.out.println(Credentials.DimensionsFrame.y);

	}

}
