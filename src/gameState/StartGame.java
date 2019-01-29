package gameState;

import tiles.Castle;
import tiles.Tile;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addWorkersAndRelocate();
		addSilverlingsAndRelocate();

		testAddTilesToGameBoard();
		test();

		super.controller.flowManager().proceedToNextPhase();

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

}
