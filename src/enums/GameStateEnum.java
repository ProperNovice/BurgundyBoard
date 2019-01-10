package enums;

import gameState.GameState;
import gameState.StartGame;

public enum GameStateEnum {

	START_GAME(new StartGame());

	private GameState gameState = null;

	private GameStateEnum(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return this.gameState;
	}

}
