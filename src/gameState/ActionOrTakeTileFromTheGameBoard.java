package gameState;

import enums.ActionEnum;
import enums.GameStateEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import javafx.scene.input.KeyCode;
import model.Dice;
import tiles.Tile;
import utils.ArrayList;
import utils.Logger;

public class ActionOrTakeTileFromTheGameBoard extends GameState {

	private Tile tileSelected = null;
	private Dice diceSelected = null;
	private int numberTarget = -1, workersNeeded = -1;
	private boolean actionCanBeExecuted;

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
	protected void handleTileDepotNumberedPressed(Tile tile, TileTypeEnum tileTypeEnum, int depotNumberedValue) {

		if (this.tileSelected != null)
			this.tileSelected.setSelected(false);

		this.tileSelected = tile;
		this.tileSelected.setSelected(true);

		this.numberTarget = depotNumberedValue;

		checkSelected();

	}

	@Override
	public void handleDiceRedPressed(Dice dice, int diceValue) {

		if (this.diceSelected != null)
			this.diceSelected.setSelected(false);

		this.diceSelected = dice;
		this.diceSelected.setSelected(true);

		checkSelected();

	}

	private void checkSelected() {

		if (this.tileSelected == null) {
			this.actionCanBeExecuted = false;
			return;
		}

		if (this.diceSelected == null) {
			this.actionCanBeExecuted = false;
			return;
		}

		TileTypeEnum tileTypeEnumSelected = this.tileSelected.getTileTypeEnum();

		int tileTypeEnumModifier = super.controller.diceModifiersManager()
				.getDiceModifierTakeTileFromTheGameBoard(tileTypeEnumSelected);

		Logger.logNewLine(tileTypeEnumSelected + " - " + tileTypeEnumModifier + " dice modifier ");

		setUpActionToBeExecuted(tileTypeEnumModifier);

		super.controller.workersManager().setWorkersTempAndRelocate(this.workersNeeded);

		setUpText();

	}

	private void setUpActionToBeExecuted(int tileTypeEnumModifier) {

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

	private ArrayList<Integer> getNumbersAvailable(int modifier, ArrayList<Integer> numbersAvailable) {

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

	private void setUpText() {

		super.controller.textManager().concealText();
		super.controller.textManager().showText(TextEnum.CHOOSE_TILE_AND_DICE);

		if (this.actionCanBeExecuted)
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

		super.controller.depotNumberedManager().removeTile(this.tileSelected);
		super.controller.storageSpaceManager().addTileAndRelocate(this.tileSelected);

		super.controller.workersManager().removeWorkersTemp();
		super.controller.diceManager().removeDiceFromAction(this.diceSelected);

		this.tileSelected.setSelected(false);
		this.diceSelected.setSelected(false);

		if (super.controller.storageSpaceManager().exceedsMaxedCapacity())
			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_TILE_TO_DISCARD);

//		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
