package gameState;

import enums.GameStateEnum;
import utils.Logger;

public class EndOfPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		GameStateEnum gameStateEnumToResolve = null;

		if (super.controller.phaseIndicatorManager().getPhaseIndicatorsSize() > 0) {

			Logger.log("removed tiles from numbered depots");
			removeTilesFromNumberedDepots();

			Logger.log("removed tiles from black depot");
			removeTilesFromBlackDepots();

			handleMinesIncome();

			Logger.log("set new phase indicator");
			setNewPhaseIndicator();

			Logger.newLine();

			gameStateEnumToResolve = GameStateEnum.START_NEW_PHASE;

		} else {
			gameStateEnumToResolve = GameStateEnum.END_GAME;
		}

		super.controller.flowManager().addGameStateResolvingFirst(gameStateEnumToResolve);
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

		if (!super.controller.gameModifiers().getReceiveWorkersAtTheEndOfThePhase())
			return;

		super.controller.workersManager().addWorkersToPlayerBoardAndRelocate(numberOfMines);

	}

	private void setNewPhaseIndicator() {
		super.controller.phaseIndicatorManager().setNewPhaseIndicator();
	}

}
