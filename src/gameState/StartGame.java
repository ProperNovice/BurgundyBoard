package gameState;

import test.Token;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Token token = new Token();
		token.relocate(50, 200);

	}

}
