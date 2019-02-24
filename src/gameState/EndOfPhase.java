package gameState;

import enums.GameStateEnum;
import utils.Logger;

public class EndOfPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		Logger.log("removed tiles from numbered depots");
		removeTilesFromNumberedDepots();

		Logger.log("removed tiles from black depot");
		removeTilesFromBlackDepots();

		handleMinesIncome();

		Logger.log("set new phase indicator");
		setNewPhaseIndicator();

		Logger.newLine();

		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.START_NEW_PHASE);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private void removeTilesFromNumberedDepots() {
		super.controller.depotNumberedManager().removeTilesFromNumberedDepots();
	}

	private void removeTilesFromBlackDepots() {
		super.controller.depotBlackManager().removeTiles();
	}

	private void handleMinesIncome() {

		int numberOfMines = super.controller.playerBoard().getNumberOfMines();

		Logger.log("silverlings income - " + numberOfMines);

		super.controller.silverlingManager().addSilverlingsToPlayerBoardAndRelocate(numberOfMines);

	}

	private void setNewPhaseIndicator() {
		super.controller.phaseIndicatorManager().setNewPhaseIndicator();
	}

}
