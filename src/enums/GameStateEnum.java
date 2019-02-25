package enums;

import gameState.ActionAddTileToYourEstate;
import gameState.ActionBuyTileFromTheBlackDepot;
import gameState.ActionTakeTileFromTheGameBoard;
import gameState.ActionTakeWorkersTiles;
import gameState.ChooseAnAction;
import gameState.ChooseDifficulty;
import gameState.ChooseSpaceForStartingCastle;
import gameState.ChooseTileToDiscard;
import gameState.EndGame;
import gameState.EndOfAction;
import gameState.EndOfPhase;
import gameState.GameState;
import gameState.ProgressionUpdate;
import gameState.ResolveBuildingBank;
import gameState.ResolveBuildingBoardingHouse;
import gameState.ResolveBuildingCarpentersWorkshop;
import gameState.ResolveBuildingChurch;
import gameState.ResolveBuildingCityHall;
import gameState.ResolveBuildingMarket;
import gameState.ResolveBuildingWatchtower;
import gameState.ResolveGrayDice;
import gameState.ResolveGroupActions;
import gameState.ResolveTileAdded;
import gameState.ResolveTileAddedAnimal;
import gameState.ResolveTileAddedBlack;
import gameState.ResolveTileAddedBuilding;
import gameState.ResolveTileAddedCastle;
import gameState.ResolveTileAddedKnowledge;
import gameState.ResolveTileAddedMine;
import gameState.ResolveTileAddedShip;
import gameState.ResolveTileTypeIsCompleted;
import gameState.ResolveVictoryPointsTargetReached;
import gameState.StartGame;
import gameState.StartNewPhase;
import gameState.StartNewRound;

public enum GameStateEnum {

	START_GAME(new StartGame()),
	CHOOSE_SPACE_TO_PLACE_THE_CASTLE(new ChooseSpaceForStartingCastle()),
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
	RESOLVE_TILE_ADDED_BLACK(new ResolveTileAddedBlack()),
	RESOLVE_TILE_ADDED(new ResolveTileAdded()),
	RESOLVE_GROUP_ACTIONS(new ResolveGroupActions()),
	RESOLVE_VICTORY_POINTS_TARGET_REACHED(new ResolveVictoryPointsTargetReached()),
	RESOLVE_BUILDING_BANK(new ResolveBuildingBank()),
	RESOLVE_BUILDING_BOARDING_HOUSE(new ResolveBuildingBoardingHouse()),
	RESOLVE_BUILDING_CARPENTERS_WORKSHOP(new ResolveBuildingCarpentersWorkshop()),
	RESOLVE_BUILDING_CHURCH(new ResolveBuildingChurch()),
	RESOLVE_BUILDING_MARKET(new ResolveBuildingMarket()),
	RESOLVE_BUILDING_WATCHTOWER(new ResolveBuildingWatchtower()),
	RESOLVE_BUILDING_CITY_HALL(new ResolveBuildingCityHall()),
	RESOLVE_TILE_TYPE_IS_COMPLETED(new ResolveTileTypeIsCompleted()),
	END_OF_ACTION(new EndOfAction()),
	CHOOSE_DIFFICULTY(new ChooseDifficulty()),
	END_OF_PHASE(new EndOfPhase()),
	PROGRESSION_UPDATE(new ProgressionUpdate()),
	END_GAME(new EndGame()),

	;

	private GameState gameState = null;

	private GameStateEnum(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return this.gameState;
	}

}
