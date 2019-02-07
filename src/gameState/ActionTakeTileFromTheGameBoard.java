package gameState;

import enums.GameStateEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import tiles.Tile;
import utils.Logger;

public class ActionTakeTileFromTheGameBoard extends ExecuteDiceActions {

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

		TileTypeEnum tileTypeEnumSelected = super.tileSelected.getTileTypeEnum();

		int tileTypeEnumModifier = super.controller.diceModifiersManager()
				.getDiceModifierTakeTileFromTheGameBoard(tileTypeEnumSelected);

		Logger.logNewLine(tileTypeEnumSelected + " - " + tileTypeEnumModifier + " dice modifier ");

		setUpActionToBeExecuted(tileTypeEnumModifier);

		super.controller.workersManager().setWorkersTempAndRelocate(super.workersNeeded);

		setUpText();

	}

	@Override
	protected void setUpText() {

		super.controller.textManager().concealText();

		if (super.controller.diceManager().diceAvailableThisRoundAmount() > 1)
			super.controller.textManager().showText(TextEnum.CHOOSE_TILE_AND_DICE);
		else
			super.controller.textManager().showText(TextEnum.CHOOSE_TILE);

		if (super.actionCanBeExecuted)
			super.controller.textManager().showText(TextEnum.CONTINUE);

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
