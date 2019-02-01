package gameState;

import enums.ActionEnum;
import enums.GameStateEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import model.Dice;
import tiles.Tile;

public class ActionTakeTileFromTheGameBoard extends GameState {

	private Tile tileSelected = null;
	private Dice diceSelected = null;

	@Override
	public void handleGameStateChange() {

		this.tileSelected = null;
		this.diceSelected = null;

		super.controller.actionManager().showAction(ActionEnum.TAKE_TILE_FROM_THE_GAME_BOARD);
		super.controller.textManager().showText(TextEnum.CHOOSE_TILE_AND_DICE);

	}

	@Override
	protected void handleTileDepotNumberedPressed(Tile tile, TileTypeEnum tileTypeEnum) {

		if (this.tileSelected != null)
			this.tileSelected.setSelected(false);

		this.tileSelected = tile;
		this.tileSelected.setSelected(true);

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

		System.out.println("yay");

	}

	private boolean canBeExecuted() {

		
		
		return false;
		
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
