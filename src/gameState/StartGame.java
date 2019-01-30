package gameState;

import enums.GameStateEnum;
import model.Goods;
import tiles.Castle;
import tiles.Tile;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addWorkersAndRelocate();
		addSilverlingsAndRelocate();

		testAddTilesToGameBoard();
		testAddGoodsToDepotNumbers();
		test();

		super.controller.flowManager().addGameStateFirst(GameStateEnum.START_NEW_PHASE);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private void addWorkersAndRelocate() {
		super.controller.workerManager().addWorkersAndRelocate(2);
	}

	private void addSilverlingsAndRelocate() {
		super.controller.silverlingManager().addSilverlingsAndRelocate(1);
	}

	private void test() {

	}

	private void testAddTilesToGameBoard() {

		Tile tile = null;

		tile = new Castle();
		super.controller.playerBoard().testAddTileToBoardSpace(tile, 6);

	}

	private void testAddGoodsToDepotNumbers() {

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

}
