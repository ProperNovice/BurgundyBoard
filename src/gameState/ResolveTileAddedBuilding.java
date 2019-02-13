package gameState;

import enums.BuildingTypeEnum;
import enums.GameStateEnum;
import tiles.Building;
import tiles.Tile;

public class ResolveTileAddedBuilding extends GameState {

	@Override
	public void handleGameStateChange() {

		GameStateEnum gameStateEnum = null;

		Tile lastTileAddedToBoard = super.controller.gameModifiers().getLastTileAddedToBoard();

		Building building = (Building) lastTileAddedToBoard;
		BuildingTypeEnum buildingTypeEnum = building.getBuildingTypeEnum();

		switch (buildingTypeEnum) {

		case BANK:
			gameStateEnum = GameStateEnum.RESOLVE_BUILDING_BANK;
			break;

		case BOARDING_HOUSE:
			gameStateEnum = GameStateEnum.RESOLVE_BUILDING_BOARDING_HOUSE;
			break;

		case CARPENTERS_WORKSHOP:
			gameStateEnum = GameStateEnum.RESOLVE_BUILDING_CARPENTERS_WORKSHOP;
			break;

		case CHURCH:
			gameStateEnum = GameStateEnum.RESOLVE_BUILDING_CHURCH;
			break;

		case CITY_HALL:
			break;

		case MARKET:
			gameStateEnum = GameStateEnum.RESOLVE_BUILDING_MARKET;
			break;

		case WAREHOUSE:
			break;

		case WATCHTOWER:
			gameStateEnum = GameStateEnum.RESOLVE_BUILDING_WATCHTOWER;
			break;

		}

		super.controller.flowManager().addGameStateResolvingFirst(gameStateEnum);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
