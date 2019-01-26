package gameState;

import enums.TileTypeEnum;
import model.BoardSpace;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addWorkersAndRelocate();
		addSilverlingsAndRelocate();

		test();

//		super.controller.flowManager().proceedToNextPhase();

	}

	private void addWorkersAndRelocate() {
		super.controller.workerManager().addWorkersAndRelocate(2);
	}

	private void addSilverlingsAndRelocate() {
		super.controller.silverlingManager().addSilverlingsAndRelocate(1);
	}

	private void test() {

	}

}
