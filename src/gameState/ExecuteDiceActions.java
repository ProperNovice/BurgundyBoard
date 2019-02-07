package gameState;

import enums.ActionEnum;
import model.Dice;
import tiles.Tile;
import utils.ArrayList;
import utils.Logger;

public abstract class ExecuteDiceActions extends GameState {

	protected Tile tileSelected = null;
	protected Dice diceSelected = null;
	protected int numberTarget = -1, workersNeeded = -1;
	protected boolean actionCanBeExecuted;

	@Override
	public void handleGameStateChange() {

		this.tileSelected = null;
		this.diceSelected = null;
		this.numberTarget = -1;
		this.workersNeeded = -1;
		this.actionCanBeExecuted = false;

		super.controller.actionManager().showAction(ActionEnum.TAKE_TILE_FROM_THE_GAME_BOARD);
		setUpText();

		if (super.controller.diceManager().diceAvailableThisRoundAmount() > 1)
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

		checkSelected();

	}

	protected void setUpActionToBeExecuted(int tileTypeEnumModifier) {

		ArrayList<Integer> numbersAvailableList = new ArrayList<>();
		numbersAvailableList.addLast(this.diceSelected.getDiceValue());

		// numbersAvailable with no Workers

		numbersAvailableList = getNumbersAvailable(tileTypeEnumModifier, numbersAvailableList);

		Logger.log("with no workers");
		numbersAvailableList.printList();

		if (numbersAvailableList.contains(this.numberTarget)) {

			this.workersNeeded = 0;
			this.actionCanBeExecuted = true;
			return;
		}

		// numbersAvailable with Workers

		int workersAvailable = super.controller.workersManager().workersSizeAvailable();

		int workersModifier = super.controller.diceModifiersManager().getWorkersModifier();

		Logger.logNewLine("Workers - " + workersModifier + " dice modifier");

		for (int counter = 1; counter <= workersAvailable; counter++) {

			numbersAvailableList = getNumbersAvailable(workersModifier, numbersAvailableList);

			Logger.log("with " + counter + " workers");
			numbersAvailableList.printList();

			if (numbersAvailableList.contains(this.numberTarget)) {

				this.workersNeeded = counter;
				this.actionCanBeExecuted = true;
				return;

			}

		}

		this.workersNeeded = 0;
		this.actionCanBeExecuted = false;

	}

	protected ArrayList<Integer> getNumbersAvailable(int modifier, ArrayList<Integer> numbersAvailable) {

		int indexUp, indexDown;

		for (int counter = 1; counter <= modifier; counter++) {

			indexUp = numbersAvailable.getLast();
			indexUp++;
			if (indexUp == 7)
				indexUp = 1;
			numbersAvailable.addLast(indexUp);

			indexDown = numbersAvailable.getFirst();
			indexDown--;
			if (indexDown == 0)
				indexDown = 6;
			numbersAvailable.addFirst(indexDown);

		}

		return numbersAvailable;

	}

	protected abstract void checkSelected();

	protected abstract void setUpText();
	
	protected abstract void executeAction();

}
