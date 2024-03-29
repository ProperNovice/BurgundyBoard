package gameState;

import enums.GameStateEnum;
import enums.TextEnum;
import javafx.scene.input.KeyCode;

public class StartNewRound extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.START_NEW_ROUND);

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode != KeyCode.Q)
			return;

		super.controller.textManager().concealText();
		executeAction();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		executeAction();
	}

	private void executeAction() {

		super.controller.diceManager().rollDiceAndRelocate();
		super.controller.gameModifiers().setCanBuyFromBlackMarketThisRound(true);

		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.RESOLVE_GRAY_DICE);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
