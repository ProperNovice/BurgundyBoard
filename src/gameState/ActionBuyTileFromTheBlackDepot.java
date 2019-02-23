package gameState;

import enums.ActionEnum;
import enums.GameStateEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import javafx.scene.input.KeyCode;
import tiles.Tile;

public class ActionBuyTileFromTheBlackDepot extends GameState {

	private Tile tileSelected = null;
	private boolean actionCanBeExecuted;
	private TileChoiceToBuyFrom tileChoiceToBuyFrom = null;

	@Override
	public void handleGameStateChange() {

		this.tileSelected = null;
		this.actionCanBeExecuted = false;
		this.tileChoiceToBuyFrom = null;

		super.controller.actionManager().showAction(ActionEnum.BUY_TILE_FROM_THE_BLACK_DEPOT);

		if (super.controller.gameModifiers().canOnlyBuyFromTheBlackDepot())
			super.controller.textManager().showText(TextEnum.CHOOSE_BLACK_TILE);
		else
			super.controller.textManager().showText(TextEnum.CHOOSE_A_TILE_TO_BUY);

	}

	@Override
	protected void handleTileBlackPressed(Tile tile, TileTypeEnum tileTypeEnum) {
		handleTileSelected(tile, TileChoiceToBuyFrom.BLACK);
	}

	@Override
	protected void handleTileDepotNumberedPressed(Tile tile, TileTypeEnum tileTypeEnum, int depotNumberedValue) {

		if (super.controller.gameModifiers().canOnlyBuyFromTheBlackDepot())
			return;

		handleTileSelected(tile, TileChoiceToBuyFrom.DEPOT_NUMBERED);

	}

	private void handleTileSelected(Tile tile, TileChoiceToBuyFrom tileChoice) {

		if (this.tileSelected != null)
			this.tileSelected.setSelected(false);

		this.tileSelected = tile;
		this.tileSelected.setSelected(true);

		this.tileChoiceToBuyFrom = tileChoice;

		if (this.actionCanBeExecuted)
			return;

		this.actionCanBeExecuted = true;

		super.controller.silverlingManager().setSilverlingsTempAndRelocate(2);

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

		switch (this.tileChoiceToBuyFrom) {

		case BLACK:
			super.controller.depotBlackManager().removeTile(this.tileSelected);
			break;

		case DEPOT_NUMBERED:
			super.controller.depotNumberedManager().removeTileAndRelocate(this.tileSelected);
			break;

		}

		super.controller.storageSpaceManager().addTileAndRelocate(this.tileSelected);
		super.controller.silverlingManager().removeSilverlingsTemp();

		super.controller.workersManager().removeWorkersTemp();

		this.tileSelected.setSelected(false);

		if (super.controller.storageSpaceManager().exceedsMaxedCapacity())
			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_TILE_TO_DISCARD);

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private enum TileChoiceToBuyFrom {
		BLACK, DEPOT_NUMBERED
	}

}
