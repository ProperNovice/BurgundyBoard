package gameState;

public class StartNewPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.phaseIndicatorManager().setNewPhaseIndicator();
		super.controller.goodsManager().createNewPhaseGoodsAndRelocate();

	}

}
