package gameState;

import enums.BuildingTypeEnum;
import enums.GameStateEnum;
import enums.TileTypeEnum;
import tiles.Knowledge;
import tiles.Tile;
import utils.Logger;

public class ResolveTileAddedKnowledge extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tile = super.controller.gameModifiers().getLastTileAddedToBoard();
		Knowledge tileKnowledge = (Knowledge) tile;

		int tileKnowledgeNumber = tileKnowledge.getTileNumber();

		switch (tileKnowledgeNumber) {

		case 1:
			resolveTileNumber1();
			break;

		case 2:
			resolveTileNumber2();
			break;

		case 3:
			resolveTileNumber3();
			break;

		case 4:
			resolveTileNumber4();
			break;

		case 5:
			resolveTileNumber5();
			break;

		case 6:
			resolveTileNumber6();
			break;

		case 7:
			resolveTileNumber7();
			break;

		case 8:
			resolveTileNumber8();
			break;

		case 9:
			resolveTileNumber9();
			break;

		case 10:
			resolveTileNumber10();
			break;

		case 11:
			resolveTileNumber11();
			break;

		case 12:
			resolveTileNumber12();
			break;

		case 13:
			resolveTileNumber13();
			break;

		case 14:
			resolveTileNumber14();
			break;

		case 15:
			resolveTileNumber15();
			break;

		case 16:
			resolveTileNumber16();
			break;

		case 17:
			resolveTileNumber17();
			break;

		case 18:
			resolveTileNumber18();
			break;

		case 19:
			resolveTileNumber19();
			break;

		case 20:
			resolveTileNumber20();
			break;

		case 21:
			resolveTileNumber21();
			break;

		case 22:
			resolveTileNumber22();
			break;

		case 23:
			resolveTileNumber23();
			break;

		case 24:
			resolveTileNumber24();
			break;

		case 25:
			resolveTileNumber25();
			break;

		case 26:
			resolveTileNumber26();
			break;

		}

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private void resolveTileNumber1() {
		Logger.logNewLine("can place identical buildings");
		super.controller.gameModifiers().setCanBePlacedIdenticalBuildingsTrue();
	}

	private void resolveTileNumber2() {
		Logger.logNewLine("reveive workers at the end of the phase");
		super.controller.gameModifiers().setReceiveWorkersAtTheEndOfThePhaseTrue();
	}

	private void resolveTileNumber3() {
		Logger.logNewLine("Not implemented");
	}

	private void resolveTileNumber4() {
		Logger.logNewLine("Not implemented");
	}

	private void resolveTileNumber5() {
		Logger.logNewLine("Not implemented");
	}

	private void resolveTileNumber6() {
		Logger.logNewLine("can buy from numbered depots");
		super.controller.gameModifiers().setCanOnlyBuyFromTheBlackDepotFalse();
	}

	private void resolveTileNumber7() {
		Logger.logNewLine("each animal tile worth 1 vp more");
		super.controller.gameModifiers().setAnimalTypeExtraPointsToOne();
	}

	private void resolveTileNumber8() {
		Logger.logNewLine("workers tile adjust +/- 2");
		super.controller.gameModifiers().addDiceModifierWorkersPlusOne();
	}

	// ->

	private void resolveTileNumber9() {
		addDiceModifierAddTileToYourEstate(TileTypeEnum.BUILDING);
	}

	private void resolveTileNumber10() {
		addDiceModifierAddTileToYourEstate(TileTypeEnum.ANIMAL);
		addDiceModifierAddTileToYourEstate(TileTypeEnum.SHIP);
	}

	private void resolveTileNumber11() {
		addDiceModifierAddTileToYourEstate(TileTypeEnum.CASTLE);
		addDiceModifierAddTileToYourEstate(TileTypeEnum.KNOWLEDGE);
		addDiceModifierAddTileToYourEstate(TileTypeEnum.MINE);
	}

	private void addDiceModifierAddTileToYourEstate(TileTypeEnum tileTypeEnum) {

		Logger.log("dice modifier +/- 1");
		Logger.logNewLine(tileTypeEnum);
		super.controller.gameModifiers().addDiceModifierAddTileToYourEstate(tileTypeEnum);

	}

	// <-

	private void resolveTileNumber12() {
		Logger.log("dice modifier +/- 1");
		Logger.logNewLine("take tile from numbered depots");
		super.controller.gameModifiers().setDiceModifierTakeTileFromTheGameBoardToOne();
	}

	private void resolveTileNumber13() {
		Logger.logNewLine("take workers action adds 1 silverling");
		super.controller.gameModifiers().setTakeWorkersTileActionAddsOneSilverlingTrue();
	}

	private void resolveTileNumber14() {
		Logger.logNewLine("take worker tiles action 4 workers");
		super.controller.gameModifiers().setTakeWorkersTileActionAmountOfWorkersToFour();
	}

	private void resolveTileNumber15() {
		Logger.logNewLine("Not implemented");
	}

	// ->

	private void resolveTileNumber16() {
		scoreFourPointsForEachBuildingType(BuildingTypeEnum.WAREHOUSE);
	}

	private void resolveTileNumber17() {
		scoreFourPointsForEachBuildingType(BuildingTypeEnum.WATCHTOWER);
	}

	private void resolveTileNumber18() {
		scoreFourPointsForEachBuildingType(BuildingTypeEnum.CARPENTERS_WORKSHOP);
	}

	private void resolveTileNumber19() {
		scoreFourPointsForEachBuildingType(BuildingTypeEnum.CHURCH);
	}

	private void resolveTileNumber20() {
		scoreFourPointsForEachBuildingType(BuildingTypeEnum.MARKET);
	}

	private void resolveTileNumber21() {
		scoreFourPointsForEachBuildingType(BuildingTypeEnum.BOARDING_HOUSE);
	}

	private void resolveTileNumber22() {
		scoreFourPointsForEachBuildingType(BuildingTypeEnum.BANK);
	}

	private void resolveTileNumber23() {
		scoreFourPointsForEachBuildingType(BuildingTypeEnum.CITY_HALL);
	}

	private void scoreFourPointsForEachBuildingType(BuildingTypeEnum buildingTypeEnum) {

		int buildingsAmount = super.controller.playerBoard().getAmountOfBuildingsPlacedOfChosenType(buildingTypeEnum);

		int victoryPoints = buildingsAmount * 4;

		Logger.log("buildings type amount - " + buildingTypeEnum);
		Logger.log(buildingsAmount);
		Logger.log("total victory points");
		Logger.log(victoryPoints);
		Logger.newLine();

		super.controller.victoryPointManager().addCurrentVictoryPoints(victoryPoints);

		if (!super.controller.victoryPointManager().currentVictoryPointsReachedTargetVictoryPoints())
			return;

		super.controller.groupActionsManager().addGroupAction(GameStateEnum.RESOLVE_VICTORY_POINTS_TARGET_REACHED);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.RESOLVE_GROUP_ACTIONS);
		super.controller.victoryPointManager().resetScoring();

	}

	// <-

	private void resolveTileNumber24() {

		int animalsTypeAmount = super.controller.playerBoard().getTypeOfAnimalsAmount();

		int victoryPoints = animalsTypeAmount * 4;

		Logger.log("animals type amount");
		Logger.log(animalsTypeAmount);
		Logger.log("total victory points");
		Logger.log(victoryPoints);
		Logger.newLine();

		super.controller.victoryPointManager().addCurrentVictoryPoints(victoryPoints);

		if (!super.controller.victoryPointManager().currentVictoryPointsReachedTargetVictoryPoints())
			return;

		super.controller.groupActionsManager().addGroupAction(GameStateEnum.RESOLVE_VICTORY_POINTS_TARGET_REACHED);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.RESOLVE_GROUP_ACTIONS);
		super.controller.victoryPointManager().resetScoring();

	}

	private void resolveTileNumber25() {
		Logger.logNewLine("Not implemented");
	}

	private void resolveTileNumber26() {
		Logger.logNewLine("Not implemented");
	}

}
