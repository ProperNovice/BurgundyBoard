package gameState;

public class ResolveBuildingBoardingHouse extends GameState {

	@Override
	public void handleGameStateChange() {
		
		super.controller.workersManager().addWorkersToPlayerBoardAndRelocate(4);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
