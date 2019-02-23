package gameState;

import enums.GameStateEnum;

public class EndOfActions extends GameState {

	@Override
	public void handleGameStateChange() {

		GameStateEnum gameStateEnum = null;

		if (!super.controller.goodsManager().phaseGoodIsEmpty())
			gameStateEnum = GameStateEnum.START_NEW_ROUND;
		else
			gameStateEnum = GameStateEnum.END_OF_PHASE;

		super.controller.flowManager().addGameStateResolvingFirst(gameStateEnum);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private void handleStartNewRound() {

		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.END_OF_ACTIONS);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_AN_ACTION);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_AN_ACTION);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.RESOLVE_GRAY_DICE);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.START_NEW_ROUND);

	}

}
