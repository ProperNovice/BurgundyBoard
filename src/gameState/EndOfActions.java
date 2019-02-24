package gameState;

import enums.GameStateEnum;
import enums.TextEnum;
import javafx.scene.input.KeyCode;
import utils.Logger;

public class EndOfActions extends GameState {

	private TextEnum textEnumShowing = null;

	@Override
	public void handleGameStateChange() {

		this.textEnumShowing = null;

		if (!super.controller.goodsManager().phaseGoodIsEmpty())
			this.textEnumShowing = TextEnum.END_OF_ROUND;
		else
			this.textEnumShowing = TextEnum.END_OF_PHASE;

		super.controller.textManager().showText(this.textEnumShowing);
		Logger.logNewLine(this.textEnumShowing + " resolving");

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		GameStateEnum gameStateEnum = null;

		switch (textEnum) {

		case END_OF_ROUND:
			gameStateEnum = GameStateEnum.START_NEW_ROUND;
			break;

		case END_OF_PHASE:
			gameStateEnum = GameStateEnum.END_OF_PHASE;
			break;

		default:
			break;

		}

		super.controller.flowManager().addGameStateResolvingFirst(gameStateEnum);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		super.controller.textManager().concealText();
		handleTextOptionPressed(this.textEnumShowing);

	}

}
