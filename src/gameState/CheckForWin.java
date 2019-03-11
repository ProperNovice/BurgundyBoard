package gameState;

import enums.GameStateEnum;

public class CheckForWin extends GameState {

	@Override
	public void handleGameStateChange() {

		if (!super.controller.playerBoard().playerBoardIsComplete())
			return;

		super.controller.flowManager().clearFlow();
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.END_GAME);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
