package gameState;

import enums.ActionEnum;
import enums.GameStateEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import model.Dice;
import tiles.Tile;
import utils.ArrayList;

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
		int modifier = super.controller.diceModifiersManager()
				.getDiceModifierTakeTileFromTheGameBoard(tileTypeEnumSelected);

		System.out.println(tileTypeEnumSelected + " modifier " + modifier);

		System.out.println(canBeExecuted(modifier));

	}

	private boolean canBeExecuted(int modifier) {

		ArrayList<Integer> numbersAvailable = getNumbersAvailable(modifier);

		numbersAvailable.printList();

		if (numbersAvailable.contains(this.numberTarget)) {
			this.workersNeeded = 0;
			return true;
		}

		return false;
	}

	private ArrayList<Integer> getNumbersAvailable(int modifier) {

		ArrayList<Integer> numbersAvailable = new ArrayList<>();

		numbersAvailable.addLast(this.diceSelected.getDiceValue());

		int indexUp = this.diceSelected.getDiceValue();
		int indexDown = this.diceSelected.getDiceValue();

		for (int counter = 1; counter <= modifier; counter++) {

			indexUp++;
			if (indexUp == 7)
				indexUp = 1;
			numbersAvailable.addLast(indexUp);

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
