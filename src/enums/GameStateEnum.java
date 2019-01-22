package enums;

import gameState.GameState;
import gameState.StartGame;
import gameState.StartNewPhase;

public enum GameStateEnum {

	START_GAME(new StartGame()),
	START_NEW_PHASE(new StartNewPhase())

	;

	private GameState gameState = null;

	private GameStateEnum(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return this.gameState;
	}

}
