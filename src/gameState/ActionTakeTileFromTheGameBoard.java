package gameState;

import enums.ActionEnum;
import enums.GameStateEnum;
import enums.TileTypeEnum;
import tiles.Tile;
import utils.Logger;

public class ActionTakeTileFromTheGameBoard extends ExecuteDiceActions {

	public ActionTakeTileFromTheGameBoard() {
		super.actionEnumToShow = ActionEnum.TAKE_TILE_FROM_THE_GAME_BOARD;
	}

	@Override
	protected void handleTileDepotNumberedPressed(Tile tile, TileTypeEnum tileTypeEnum, int depotNumberedValue) {

		if (super.tileSelected != null)
			super.tileSelected.setSelected(false);

		super.tileSelected = tile;
		super.tileSelected.setSelected(true);

		super.numberTarget = depotNumberedValue;

		checkSelected();

	}

	@Override
	protected void checkSelected() {

		if (super.tileSelected == null) {
			super.actionCanBeExecuted = false;
			return;
		}

		if (super.diceSelected == null) {
			super.actionCanBeExecuted = false;
			return;
		}

		super.controller.workersManager().resetWorkersTempAndRelocate();

		TileTypeEnum tileTypeEnumSelected = super.tileSelected.getTileTypeEnum();

		int tileTypeEnumModifier = super.controller.gameModifiersManager()
				.getDiceModifierTakeTileFromTheGameBoard(tileTypeEnumSelected);

		Logger.logNewLine(tileTypeEnumSelected + " - " + tileTypeEnumModifier + " dice modifier ");

		setUpActionToBeExecuted(tileTypeEnumModifier);

		super.controller.workersManager().setWorkersTempAndRelocate(super.workersNeeded);

		System.out.println(super.workersNeeded + " wn");

		setUpText();

	}

	@Override
	protected void executeAction() {

		super.controller.textManager().concealText();
		super.controller.actionManager().concealActions();

		super.controller.depotNumberedManager().removeTile(super.tileSelected);
		super.controller.storageSpaceManager().addTileAndRelocate(super.tileSelected);

		super.controller.workersManager().removeWorkersTemp();
		super.controller.diceManager().removeDiceFromAction(super.diceSelected);

		super.tileSelected.setSelected(false);
		super.diceSelected.setSelected(false);

		if (super.controller.storageSpaceManager().exceedsMaxedCapacity())
			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_TILE_TO_DISCARD);

//		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
