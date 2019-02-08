package gameState;

import enums.AnimalTypeEnum;
import enums.BuildingTypeEnum;
import enums.GameStateEnum;
import enums.TileTypeEnum;
import model.Goods;
import tiles.Animal;
import tiles.Building;
import tiles.Castle;
import tiles.Tile;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addTilesToGameBoard();
//		addGoodsToDepotNumbers();
		setDiceValuesRed();
		addTilesToStorageSpaces();
		addSilverlings(5);
		addWorkers(3);
		setDiceModifiers();
//		removeDiceFromAction();
		setCanBePlacedIdenticalBuildingsTrue();

//		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.ACTION_TAKE_TILE_FROM_THE_GAME_BOARD);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.ACTION_ADD_TILE_TO_YOUR_ESTATE);

		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.START_NEW_PHASE);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	public void addTilesToGameBoard() {

		Tile tile = null;

		tile = new Castle();
		super.controller.playerBoard().testAddTileToBoardSpace(tile, 6);

		tile = new Building(BuildingTypeEnum.MARKET);
		super.controller.playerBoard().testAddTileToBoardSpace(tile, 3);

	}

	public void addGoodsToDepotNumbers() {

		int depotNumbered = 2;

		Goods a = new Goods(1);
		a.setVisible(true);
		Goods b = new Goods(6);
		b.setVisible(true);
		Goods c = new Goods(4);
		c.setVisible(true);

		super.controller.depotNumberedManager().addGoodsToDepotNumbered(a, depotNumbered);
		super.controller.depotNumberedManager().addGoodsToDepotNumbered(b, depotNumbered + 1);
		super.controller.depotNumberedManager().addGoodsToDepotNumbered(c, depotNumbered);

	}

	public void setDiceValuesRed() {
		super.controller.diceManager().testSetRedDiceValuesAndRelocate(4, 6);
	}

	public void addTilesToStorageSpaces() {

		Tile tile = null;

//		tile = new Ship();
//		super.controller.storageSpaceManager().addTileAndRelocate(tile);
//		tile.setVisible(true);

		tile = new Building(BuildingTypeEnum.BANK);
		super.controller.storageSpaceManager().addTileAndRelocate(tile);
		tile.setVisible(true);

		tile = new Building(BuildingTypeEnum.MARKET);
		super.controller.storageSpaceManager().addTileAndRelocate(tile);
		tile.setVisible(true);

		tile = new Animal(AnimalTypeEnum.PIG, 3);
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

		super.controller.diceModifiersManager().addDiceModifierTakeTileFromTheGameBoard(TileTypeEnum.BUILDING);
		super.controller.diceModifiersManager().addDiceModifierAddTileToYourEstate(TileTypeEnum.ANIMAL);
//		super.controller.diceModifiersManager().addWorkersModifier();

	}

	public void removeDiceFromAction() {

		super.controller.diceManager().testRemoveDiceFromAction(0);

	}

	public void setCanBePlacedIdenticalBuildingsTrue() {
		super.controller.playerBoard().setCanBePlacedIdenticalBuildingsTrue();
	}

}
