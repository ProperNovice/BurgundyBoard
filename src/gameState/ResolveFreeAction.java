package gameState;

import enums.TextEnum;
import javafx.scene.input.KeyCode;
import model.Dice;

public abstract class ResolveFreeAction extends GameState {

	private Dice diceSelected = null;
	private boolean continueIsShowing = false;

	@Override
	public void handleGameStateChange() {

		this.diceSelected = null;
		this.continueIsShowing = false;

		super.controller.diceManager().setDiceCurrentlyShowingFreeActionAndRelocate();
		super.controller.textManager().showText(TextEnum.CHOOSE_DICE);

	}

	@Override
	public void handleDiceRedPressed(Dice dice, int diceValue) {

		if (this.diceSelected != null)
			this.diceSelected.setSelected(false);

		this.diceSelected = dice;
		this.diceSelected.setSelected(true);

		if (this.continueIsShowing)
			return;

		this.continueIsShowing = true;

		super.controller.textManager().showText(TextEnum.CONTINUE);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		executeAction();
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode != KeyCode.Q)
			return;

		if (!this.continueIsShowing)
			return;

		super.controller.textManager().concealText();
		executeAction();

	}

	private void executeAction() {

		super.controller.textManager().concealText();
		this.diceSelected.setSelected(false);
		super.controller.diceManager().removeAllDiceCurrentlyShowingButThisAndRelocate(this.diceSelected);

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
