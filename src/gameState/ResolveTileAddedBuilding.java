package gameState;

import enums.BuildingTypeEnum;
import tiles.Building;
import tiles.Tile;

public class ResolveTileAddedBuilding extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile lastTileAddedToBoard = super.controller.gameModifiers().getLastTileAddedToBoard();

		Building building = (Building) lastTileAddedToBoard;
		BuildingTypeEnum buildingTypeEnum = building.getBuildingTypeEnum();

		switch (buildingTypeEnum) {

		case BANK:
			resolveBank();
			break;

		case BOARDING_HOUSE:
			resolveBoardingHouse();
			break;

		case CARPENTERS_WORKSHOP:
			resolveCarpentersWorkshop();
			break;

		case CHURCH:
			resolveChurch();
			break;

		case CITY_HALL:
			resolveCityHall();
			break;

		case MARKET:
			resolveMarket();
			break;

		case WAREHOUSE:
			resolveWarehouse();
			break;

		case WATCHTOWER:
			resolveWatchtower();
			break;

		}

	}

	private void resolveBank() {

		super.controller.silverlingManager().addSilverlingsToPlayerBoardAndRelocate(2);

	}

	private void resolveBoardingHouse() {

		super.controller.workersManager().addWorkersToPlayerBoardAndRelocate(4);

	}

	private void resolveCarpentersWorkshop() {

	}

	private void resolveChurch() {

	}

	private void resolveCityHall() {

	}

	private void resolveMarket() {

	}

	private void resolveWarehouse() {

	}

	private void resolveWatchtower() {

	}

}
