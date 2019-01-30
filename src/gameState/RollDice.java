package gameState;

import enums.TextEnum;
import javafx.scene.input.KeyCode;

public class RollDice extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.ROLL_DICE);

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

	}

}
