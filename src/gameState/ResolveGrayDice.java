package gameState;

import enums.TextEnum;
import javafx.scene.input.KeyCode;

public class ResolveGrayDice extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.RESOLVE_GRAY_DICE);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		resolveGrayDice();
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {
		super.controller.textManager().concealText();
		resolveGrayDice();
	}

	private void resolveGrayDice() {

		System.out.println("yo");

	}

}
