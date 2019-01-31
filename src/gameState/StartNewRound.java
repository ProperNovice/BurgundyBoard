package gameState;

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
		rollDice();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		rollDice();
	}

	private void rollDice() {

		super.controller.diceManager().rollDiceAndRelocate();
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
