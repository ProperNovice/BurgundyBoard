package gameState;

public class ResolveTileAddedBlack extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
