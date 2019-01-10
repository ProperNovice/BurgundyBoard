package controller;

import enums.GameStateEnum;
import gameState.GameState;
import utils.Logger;

public class GameStateController {

	private GameState currentGameState = null;

	public GameStateController() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		this.currentGameState = gameStateEnum.getGameState();

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum);

		this.currentGameState.handleGameStateChange();

	}

	public GameState getCurrentGameState() {
		return this.currentGameState;
	}

}
