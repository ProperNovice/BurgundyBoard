package gameState;

import controller.Credentials;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {
		
		System.out.println(Credentials.DimensionsFrame.y);

	}

}
