package gameState;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.flowManager().proceedToNextPhase();

		test();

	}

	private void test() {

	}

}
