package gameState;

import enums.ActionEnum;
import enums.TextEnum;
import model.BoardSpace;
import model.Dice;
import tiles.Tile;

public class ActionAddTileToYourEstate extends GameState {

	private Tile tile = null;
	private Dice diceSelected = null;
	private BoardSpace boardSpace = null;
	private int numberTarget = -1, workersNeeded = -1;
	private boolean actionCanBeExecuted;

	@Override
	public void handleGameStateChange() {

		this.tile = null;
		this.boardSpace = null;
		this.numberTarget = -1;
		this.workersNeeded = -1;
		this.actionCanBeExecuted = false;

		super.controller.actionManager().showAction(ActionEnum.ADD_TILE_TO_YOUR_ESTATE);
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

	private void checkSelected() {

	}

	private void setUpText() {

		super.controller.textManager().concealText();
		super.controller.textManager().showText(TextEnum.CHOOSE_DICE_TILE_AND_BOARD_SPACE);

		if (this.actionCanBeExecuted)
			super.controller.textManager().showText(TextEnum.CONTINUE);

	}

}
