package gameState;

import enums.GameStateEnum;

public class ResolveBuildingWatchtower extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.victoryPointManager().addCurrentVictoryPoints(4);

		if (super.controller.victoryPointManager().currentVictoryPointsReachedTargetVictoryPoints()) {

			super.controller.groupActionsManager().addGroupAction(GameStateEnum.RESOLVE_VICTORY_POINTS_TARGET_REACHED);
			super.controller.victoryPointManager().resetScoring();

		}

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
