package gameState;

import enums.AnimalTypeEnum;
import enums.BuildingTypeEnum;
import enums.GameStateEnum;
import enums.TileTypeEnum;
import model.BoardSpace;
import model.Goods;
import tiles.Animal;
import tiles.Black;
import tiles.Building;
import tiles.Castle;
import tiles.Knowledge;
import tiles.Ship;
import tiles.Tile;
import utils.ArrayList;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addTilesToGameBoard();
		addGoodsToDepotNumbers();
		setDiceValuesRed();
		addTilesToStorageSpaces();
//		addSilverlings(1);
//		addWorkers(2);
		setDiceModifiers();
//		removeDiceFromAction();
		setCanBePlacedIdenticalBuildingsTrue();
		setTextScore();
		addGroupActions();
//		addPlayerGoods();

//		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.RESOLVE_TILE_ADDED_KNOWLEDGE);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.RESOLVE_TILE_ADDED);

		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.START_NEW_PHASE);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	public void addTilesToGameBoard() {

		Tile tile = null;

		tile = new Castle();
		addTileToGameBoard(tile, 6);

		tile = new Ship();
		addTileToGameBoard(tile, 9);

		tile = new Black();
		addTileToGameBoard(tile, 10);

		tile = new Castle();
		addTileToGameBoard(tile, 17);

		tile = new Animal(AnimalTypeEnum.COW, 2);
		addTileToGameBoard(tile, 18);

		tile = new Animal(AnimalTypeEnum.HEN, 4);
		addTileToGameBoard(tile, 23);

		tile = new Animal(AnimalTypeEnum.COW, 3);
		addTileToGameBoard(tile, 14);

		tile = new Knowledge(4);
		addTileToGameBoard(tile, 7);

		tile = new Building(BuildingTypeEnum.CITY_HALL);
		addTileToGameBoard(tile, 2);

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
		super.controller.diceManager().testSetRedDiceValuesAndRelocate(4, 6);
	}

	public void addTilesToStorageSpaces() {

		addTileToStorageSpace(new Castle());
		addTileToStorageSpace(new Black());
		addTileToStorageSpace(new Building(BuildingTypeEnum.CARPENTERS_WORKSHOP));

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

		super.controller.gameModifiers().addDiceModifierTakeTileFromTheGameBoard();
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
