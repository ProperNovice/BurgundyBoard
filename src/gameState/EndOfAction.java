package gameState;

import enums.GameStateEnum;
import enums.TextEnum;
import javafx.scene.input.KeyCode;
import utils.Logger;

public class EndOfAction extends GameState {

	private TextEnum textEnumShowing = null;

	@Override
	public void handleGameStateChange() {

		this.textEnumShowing = null;

		if (super.controller.diceManager().diceCurrentlyShowingAmount() > 0) {

			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_AN_ACTION);
			super.controller.flowManager().proceedToNextGameStatePhase();
			return;

		} else if (super.controller.diceManager().getDiceRoundAvailableSize() > 0) {

			super.controller.diceManager().setDiceCurrentlyShowingAvailableCurrentRound();
			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_AN_ACTION);
			super.controller.flowManager().proceedToNextGameStatePhase();
			return;

		} else if (!super.controller.goodsManager().phaseGoodsIsEmpty())
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
