package gameState;

import enums.GameStateEnum;
import model.Goods;
import tiles.Castle;
import tiles.Mine;
import tiles.Tile;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addTilesToGameBoard();
//		addGoodsToDepotNumbers();
		setDiceValuesRed();
		addTilesToStorageSpaces();
		addSilverlings(4);
//		addWorkers(11);

		super.controller.flowManager().addGameStateFirst(GameStateEnum.START_NEW_PHASE);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private void addTilesToGameBoard() {

		Tile tile = null;

		tile = new Castle();
		super.controller.playerBoard().testAddTileToBoardSpace(tile, 6);

	}

	private void addGoodsToDepotNumbers() {

		int depotNumbered = 1;

		Goods a = new Goods(1);
		a.setVisible(true);
		Goods b = new Goods(6);
		b.setVisible(true);
		Goods c = new Goods(4);
		c.setVisible(true);

		super.controller.depotNumberedManager().addGoodsToDepotNumbered(a, depotNumbered);
		super.controller.depotNumberedManager().addGoodsToDepotNumbered(b, depotNumbered);
		super.controller.depotNumberedManager().addGoodsToDepotNumbered(c, depotNumbered);

	}

	private void setDiceValuesRed() {
		super.controller.diceManager().testSetRedDiceValuesAndRelocate(5, 4);
	}

	private void addTilesToStorageSpaces() {

		Tile tile = null;

		tile = new Castle();
		super.controller.storageSpaceManager().addTileAndRelocate(tile);
		tile.setVisible(true);

		tile = new Mine();
		super.controller.storageSpaceManager().addTileAndRelocate(tile);
		tile.setVisible(true);

	}

	private void addSilverlings(int amount) {
		super.controller.silverlingManager().addSilverlingsAndRelocate(amount);
	}

	private void addWorkers(int amount) {
		super.controller.workerManager().addWorkersAndRelocate(amount);
	}

}
