package enums;

import gameState.*;

public enum GameStateEnum {

	START_GAME(new StartGame()),
	CHOOSE_SPACE_TO_PLACE_THE_CASTLE(new ChooseSpaceToPlaceTheCastle()),
	START_NEW_PHASE(new StartNewPhase()),
	START_NEW_ROUND(new StartNewRound()),
	RESOLVE_GRAY_DICE(new ResolveGrayDice()),
	CHOOSE_AN_ACTION(new ChooseAnAction()),
	ACTION_TAKE_TILE_FROM_THE_GAME_BOARD(new ActionTakeTileFromTheGameBoard()),
	ACTION_TAKE_WORKERS_TILES(new ActionTakeWorkersTiles()),
	CHOOSE_TILE_TO_DISCARD(new ChooseTileToDiscard()),

	;

	private GameState gameState = null;

	private GameStateEnum(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return this.gameState;
	}

}
