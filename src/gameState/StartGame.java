package gameState;

import enums.BuildingTypeEnum;
import enums.GameStateEnum;
import enums.TileTypeEnum;
import model.BoardSpace;
import model.Goods;
import tiles.Building;
import tiles.Castle;
import tiles.Tile;
import utils.ArrayList;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

//		addTilesToGameBoard();
//		setTextScore();
//		addGoodsToDepotNumbers();
//		setDiceValuesRed();
		addTilesToStorageSpaces();
//		addSilverlings(4);
//		addWorkers(11);
//		setDiceModifiers();
//		removeDiceFromAction();
//		setCanBePlacedIdenticalBuildingsTrue();
//		addGroupActions();
//		addPlayerGoods();

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	public void addTilesToGameBoard() {

		Tile tile = null;

		tile = new Castle();
		addTileToGameBoard(tile, 6);

	}

	private void addTileToGameBoard(Tile tile, int boardSpaceInt) {

		tile.setVisible(true);
		BoardSpace boardSpace = null;

		boardSpace = super.controller.playerBoard().testGetBoardSpace(boardSpaceInt);
		boardSpace.addTileAndRelocate(tile);

		super.controller.gameModifiers().setLastTileAddedToBoardSpace(tile, boardSpace);

	}

	public void addGoodsToDepotNumbers() {

		addGoodsToDepotNumber(2);
		addGoodsToDepotNumber(3);
		addGoodsToDepotNumber(2);
		addGoodsToDepotNumber(5);
		addGoodsToDepotNumber(5);
		addGoodsToDepotNumber(5);

	}

	private void addGoodsToDepotNumber(int depotNumber) {

		Goods goods = super.controller.goodsManager().testRemoveRandomGoodsFromStack();
		goods.setVisible(true);
		super.controller.depotNumberedManager().addGoodsToDepotNumbered(goods, depotNumber);

	}

	public void setDiceValuesRed() {
		super.controller.diceManager().testSetRedDiceValuesAndRelocate(4, 3);
	}

	public void addTilesToStorageSpaces() {

//		addTileToStorageSpace(new Animal(AnimalTypeEnum.COW, 3));
		addTileToStorageSpace(new Building(BuildingTypeEnum.CITY_HALL));
//		addTileToStorageSpace(new Building(BuildingTypeEnum.CARPENTERS_WORKSHOP));

	}

	private void addTileToStorageSpace(Tile tile) {

		super.controller.storageSpaceManager().addTileAndRelocate(tile);
		tile.setVisible(true);

	}

	public void addSilverlings(int amount) {
		super.controller.silverlingManager().addSilverlingsToPlayerBoardAndRelocate(amount);
	}

	public void addWorkers(int amount) {
		super.controller.workersManager().addWorkersToPlayerBoardAndRelocate(amount);
	}

	public void setDiceModifiers() {

		super.controller.gameModifiers().setDiceModifierTakeTileFromTheGameBoardToOne();
		super.controller.gameModifiers().addDiceModifierAddTileToYourEstate(TileTypeEnum.ANIMAL);
//		super.controller.diceModifiersManager().addWorkersModifier();

	}

	public void removeDiceFromAction() {

		super.controller.diceManager().testRemoveDiceFromAction(0);

	}

	public void setCanBePlacedIdenticalBuildingsTrue() {
		super.controller.gameModifiers().setCanBePlacedIdenticalBuildingsTrue();
	}

	public void setTextScore() {

		super.controller.victoryPointManager().addCurrentVictoryPoints(0);
		super.controller.victoryPointManager().setTargetVictoryPoints(50);

	}

	public void addGroupActions() {

		super.controller.groupActionsManager().addGroupAction(GameStateEnum.RESOLVE_TILE_ADDED);
		super.controller.groupActionsManager().addGroupAction(GameStateEnum.RESOLVE_VICTORY_POINTS_TARGET_REACHED);
		super.controller.groupActionsManager().addGroupAction(GameStateEnum.RESOLVE_TILE_TYPE_IS_COMPLETED);

	}

	public void addPlayerGoods() {

		int randomGoodsToAdd = 4;

		ArrayList<Goods> goods = new ArrayList<>();
		Goods goodsTemp = null;

		for (int counter = 1; counter <= randomGoodsToAdd; counter++) {

			goodsTemp = super.controller.goodsManager().testRemoveRandomGoodsFromStack();
			goodsTemp.setVisible(true);
			goods.addLast(goodsTemp);

		}

		super.controller.goodsManager().addPlayerGoodsAndRelocate(goods);

	}

}
