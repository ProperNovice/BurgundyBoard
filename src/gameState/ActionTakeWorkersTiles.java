package gameState;

import enums.ActionEnum;
import enums.TextEnum;
import javafx.scene.input.KeyCode;
import model.Dice;

public class ActionTakeWorkersTiles extends GameState {

	private Dice diceSelected = null;
	private boolean actionCanBeExecuted;

	@Override
	public void handleGameStateChange() {

		this.diceSelected = null;
		this.actionCanBeExecuted = false;

		super.controller.actionManager().showAction(ActionEnum.TAKE_WORKERS_TILES);

		super.controller.textManager().showText(TextEnum.CHOOSE_DICE);

		if (super.controller.diceManager().diceCurrentlyShowingAmount() > 1)
			return;

		Dice dice = super.controller.diceManager().getFirstDieAvailableThisRound();
		int diceValue = dice.getDiceValue();
		this.handleDiceRedPressed(dice, diceValue);

	}

	@Override
	public void handleDiceRedPressed(Dice dice, int diceValue) {

		if (this.diceSelected != null)
			this.diceSelected.setSelected(false);

		this.diceSelected = dice;
		this.diceSelected.setSelected(true);

		if (this.actionCanBeExecuted)
			return;

		this.actionCanBeExecuted = true;
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

		if (!this.actionCanBeExecuted)
			return;

		executeAction();

	}

	private void executeAction() {

		super.controller.textManager().concealText();
		super.controller.actionManager().concealActions();

		int workersToAdd = super.controller.gameModifiers().getTakeWorkersTileActionAmountOfWorkers();

		super.controller.workersManager().addWorkersToPlayerBoardAndRelocate(workersToAdd);

		if (super.controller.gameModifiers().getTakeWorkersTileActionAddsOneSilverling())
			super.controller.silverlingManager().addSilverlingsToPlayerBoardAndRelocate(1);

		super.controller.diceManager().removeDiceFromAction(this.diceSelected);
		this.diceSelected.setSelected(false);

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
