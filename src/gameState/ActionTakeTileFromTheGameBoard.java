package gameState;

import enums.ActionEnum;
import enums.GameStateEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import model.Dice;
import tiles.Tile;
import utils.ArrayList;
import utils.Logger;

public class ActionTakeTileFromTheGameBoard extends GameState {

	private Tile tileSelected = null;
	private Dice diceSelected = null;
	private int numberTarget = -1, workersNeeded = -1;

	@Override
	public void handleGameStateChange() {

		this.tileSelected = null;
		this.diceSelected = null;
		this.numberTarget = -1;
		this.workersNeeded = -1;

		super.controller.actionManager().showAction(ActionEnum.TAKE_TILE_FROM_THE_GAME_BOARD);
		super.controller.textManager().showText(TextEnum.CHOOSE_TILE_AND_DICE);

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

		if (this.tileSelected == null)
			return;

		if (this.diceSelected == null)
			return;

		TileTypeEnum tileTypeEnumSelected = this.tileSelected.getTileTypeEnum();

		int tileTypeEnumModifier = super.controller.diceModifiersManager()
				.getDiceModifierTakeTileFromTheGameBoard(tileTypeEnumSelected);

		Logger.logNewLine(tileTypeEnumSelected + " " + tileTypeEnumModifier + " - dice modifier ");

		System.out.println(canBeExecuted(tileTypeEnumModifier) + " cbe");
		System.out.println(this.workersNeeded + " wn");
		System.out.println();

	}

	private boolean canBeExecuted(int tileTypeEnumModifier) {

		ArrayList<Integer> numbersAvailableList = new ArrayList<>();
		numbersAvailableList.addLast(this.diceSelected.getDiceValue());

		// numbersAvailable with no Workers

		numbersAvailableList = getNumbersAvailable(tileTypeEnumModifier, numbersAvailableList);

		Logger.log("with no workers");
		numbersAvailableList.printList();

		if (numbersAvailableList.contains(this.numberTarget)) {
			this.workersNeeded = 0;
			return true;
		}

		// numbersAvailable with Workers

		int workersAvailable = super.controller.workersManager().workersSizePlayerBoard();

		int workersModifier = super.controller.diceModifiersManager().getWorkersModifier();

		Logger.logNewLine(workersModifier + " - workers modifier");

		for (int counter = 1; counter <= workersAvailable; counter++) {

			numbersAvailableList = getNumbersAvailable(workersModifier, numbersAvailableList);

			Logger.log("with " + counter + " workers");
			numbersAvailableList.printList();

			if (numbersAvailableList.contains(this.numberTarget)) {
				this.workersNeeded = counter;
				return true;

			}

		}

		return false;
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

	private void executeAction(Tile tile) {

		super.controller.textManager().concealText();
		super.controller.actionManager().concealActions();

		super.controller.depotNumberedManager().removeTile(tile);
		super.controller.storageSpaceManager().addTileAndRelocate(tile);

		if (super.controller.storageSpaceManager().exceedsMaxedCapacity())
			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_TILE_TO_DISCARD);

//		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
