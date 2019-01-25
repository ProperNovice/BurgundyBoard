package gameState;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addWorkersAndRelocate();

		test();

		super.controller.flowManager().proceedToNextPhase();

	}

	private void addWorkersAndRelocate() {
		super.controller.workerManager().addWorkersAndRelocate(2);
	}

	private void test() {

	}

}
