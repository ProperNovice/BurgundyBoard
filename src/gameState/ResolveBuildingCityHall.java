package gameState;

import enums.TextEnum;
import enums.TileTypeEnum;
import model.BoardSpace;
import tiles.Tile;

public class ResolveBuildingCityHall extends GameState {

	private Tile tileSelected = null;
	private BoardSpace boardSpaceSelected = null;
	private boolean actionCanBeExecuted = false;

	@Override
	public void handleGameStateChange() {

		this.tileSelected = null;
		this.boardSpaceSelected = null;
		this.actionCanBeExecuted = false;

		setUpText();

		if (!super.controller.storageSpaceManager().containsExactlyOneTile())
			return;

		Tile tile = super.controller.storageSpaceManager().getFirstTile();

		this.tileSelected = tile;
		this.tileSelected.setSelected(true);

	}

	@Override
	protected void handleTileStorageSpacePriorPressed(Tile tile, TileTypeEnum tileTypeEnum) {

		if (this.tileSelected != null)
			this.tileSelected.setSelected(false);

		this.tileSelected = tile;
		this.tileSelected.setSelected(true);

		checkSelected();

	}

	@Override
	public void handleBoardSpacePressed(BoardSpace boardSpacePressed, TileTypeEnum tileTypeEnum, int diceValue) {

		if (!boardSpacePressed.adjacentsContainTile())
			return;

		if (this.boardSpaceSelected != null)
			this.boardSpaceSelected.setSelected(false);

		this.boardSpaceSelected = boardSpacePressed;
		this.boardSpaceSelected.setSelected(true);

		checkSelected();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		this.tileSelected.setSelected(false);
		this.boardSpaceSelected.setSelected(false);

		super.controller.storageSpaceManager().removeTileAndRelocate(this.tileSelected);
		this.boardSpaceSelected.addTileAndRelocate(this.tileSelected);

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private void checkSelected() {

		if (this.tileSelected == null)
			return;

		if (this.boardSpaceSelected == null)
			return;

		if (this.tileSelected.getTileTypeEnum() != this.boardSpaceSelected.getTileTypeEnum())
			this.actionCanBeExecuted = false;
		else
			this.actionCanBeExecuted = true;

		setUpText();

	}

	private void setUpText() {

		super.controller.textManager().concealText();
		super.controller.textManager().showText(TextEnum.SET_UP_ACTION);

		if (!this.actionCanBeExecuted)
			return;

		super.controller.textManager().showText(TextEnum.CONTINUE);

	}

}
