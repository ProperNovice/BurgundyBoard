package gameState;

public class ResolveTileAddedMine extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.gameModifiers().addOneSilverlingsReceivedAtTheEndOfThePhase();
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
