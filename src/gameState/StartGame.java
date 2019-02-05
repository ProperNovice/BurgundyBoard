package gameState;

import enums.GameStateEnum;
import enums.TileTypeEnum;
import model.Goods;
import tiles.Castle;
import tiles.Mine;
import tiles.Ship;
import tiles.Tile;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addTilesToGameBoard();
//		addGoodsToDepotNumbers();
		setDiceValuesRed();
//		addTilesToStorageSpaces();
		addSilverlings(4);
//		addWorkers(1);
		setDiceModifiers();
//		removeDiceFromAction();

		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.ACTION_BUY_TILE_FROM_THE_BLACK_DEPOT);

		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.START_NEW_PHASE);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	public void addTilesToGameBoard() {

		Tile tile = null;

		tile = new Castle();
		super.controller.playerBoard().testAddTileToBoardSpace(tile, 6);

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
		super.controller.diceManager().testSetRedDiceValuesAndRelocate(3, 6);
	}

	public void addTilesToStorageSpaces() {

		Tile tile = null;

		tile = new Ship();
		super.controller.storageSpaceManager().addTileAndRelocate(tile);
		tile.setVisible(true);

		tile = new Mine();
		super.controller.storageSpaceManager().addTileAndRelocate(tile);
		tile.setVisible(true);

		tile = new Castle();
		super.controller.storageSpaceManager().addTileAndRelocate(tile);
		tile.setVisible(true);

	}

	public void addSilverlings(int amount) {
		super.controller.silverlingManager().addSilverlingsAndRelocate(amount);
	}

	public void addWorkers(int amount) {
		super.controller.workersManager().addWorkersToPlayerBoardAndRelocate(amount);
	}

	public void setDiceModifiers() {

		super.controller.diceModifiersManager().addDiceModifierTakeTileFromTheGameBoard(TileTypeEnum.BUILDING);
//		super.controller.diceModifiersManager().addWorkersModifier();

	}

	public void removeDiceFromAction() {

		super.controller.diceManager().testRemoveDiceFromAction(0);

	}

}
