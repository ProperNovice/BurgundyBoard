package gameState;

public class ResolveBuildingBank extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.silverlingManager().addSilverlingsToPlayerBoardAndRelocate(2);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
