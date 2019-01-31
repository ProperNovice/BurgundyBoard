package enums;

import gameState.*;

public enum GameStateEnum {

	START_GAME(new StartGame()),
	START_NEW_PHASE(new StartNewPhase()),
	ROLL_DICE(new RollDice()),
	RESOLVE_GRAY_DICE(new ResolveGrayDice()),
	CHOOSE_AN_ACTION(new ChooseAnAction()),
	ACTION_TAKE_TILE_FROM_THE_GAME_BOARD(new ActionTakeTileFromTheGameBoard()),

	;

	private GameState gameState = null;

	private GameStateEnum(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return this.gameState;
	}

}
