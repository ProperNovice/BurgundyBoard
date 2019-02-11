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
	ACTION_ADD_TILE_TO_YOUR_ESTATE(new ActionAddTileToYourEstate()),
	ACTION_TAKE_WORKERS_TILES(new ActionTakeWorkersTiles()),
	ACTION_BUY_TILE_FROM_THE_BLACK_DEPOT(new ActionBuyTileFromTheBlackDepot()),
	CHOOSE_TILE_TO_DISCARD(new ChooseTileToDiscard()),
	RESOLVE_TILE_ADDED_CASTLE(new ResolveTileAddedCastle()),
	RESOLVE_TILE_ADDED_SHIP(new ResolveTileAddedShip()),
	RESOLVE_TILE_ADDED_MINE(new ResolveTileAddedMine()),
	RESOLVE_TILE_ADDED_BUILDING(new ResolveTileAddedBuilding()),
	RESOLVE_TILE_ADDED_ANIMAL(new ResolveTileAddedAnimal()),
	RESOLVE_TILE_ADDED_KNOWLEDGE(new ResolveTileAddedKnowledge()),
	RESOLVE_GROUP_ACTIONS(new ResolveGroupActions()),
	RESOLVE_VICTORY_POINTS_TARGET_REACHED(new ResolveVictoryPointsTargetReached()),

	;

	private GameState gameState = null;

	private GameStateEnum(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return this.gameState;
	}

}
