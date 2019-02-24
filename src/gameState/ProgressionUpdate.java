package gameState;

import utils.Logger;

public class ProgressionUpdate extends GameState {

	@Override
	public void handleGameStateChange() {

		int emptyBoardSpaces = super.controller.playerBoard().getNumberOfEmptyBoardSpaces();
		Logger.log("empty board spaces - " + emptyBoardSpaces);

		int storageSpaceTiles = super.controller.storageSpaceManager().getNumberOfTiles();
		Logger.log("storage space tiles - " + storageSpaceTiles);

		int diceRoundAvailable = super.controller.diceManager().getDiceRoundAvailableSize();
		Logger.log("dice round available - " + diceRoundAvailable);

		int roundsRemainingForCurrentPhase = super.controller.goodsManager().getPhaseGoodsSize();
		Logger.log("rounds remaining for current phase - " + roundsRemainingForCurrentPhase);

		int phasesRemaining = super.controller.phaseIndicatorManager().getPhaseIndicatorsSize();
		Logger.log("phases remaining - " + phasesRemaining);

		int actionsNeed = emptyBoardSpaces * 2 - storageSpaceTiles;
		Logger.log("actions need - " + actionsNeed);

		int actionsRemaining = (phasesRemaining * 5 + roundsRemainingForCurrentPhase) * 2 + diceRoundAvailable;
		Logger.log("actions remaining - " + actionsRemaining);

		int progression = actionsRemaining - actionsNeed;
		Logger.log("progression -> " + progression);

		Logger.newLine();

		String progressionString = Integer.toString(progression);
		super.controller.progressionManager().setProgression(progressionString);
		
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
