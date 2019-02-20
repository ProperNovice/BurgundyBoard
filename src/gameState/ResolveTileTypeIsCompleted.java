package gameState;

import enums.BuildingTypeEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import model.BoardSpace;
import tiles.Building;
import tiles.Tile;

public class ResolveTileTypeIsCompleted extends GameState {

	private Tile tileSelected = null;
	private BoardSpace boardSpaceSelected = null;
	private boolean actionCanBeCompleted = false;

	@Override
	public void handleGameStateChange() {

		this.tileSelected = null;
		this.boardSpaceSelected = null;
		this.actionCanBeCompleted = false;

		setUpText();

	}

	@Override
	protected void handleTileBlackPressed(Tile tile, TileTypeEnum tileTypeEnum) {

		if (this.tileSelected != null)
			this.tileSelected.setSelected(false);

		this.tileSelected = tile;
		this.tileSelected.setSelected(true);

		checkSelected();
		setUpText();

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
		setUpText();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		this.tileSelected.setSelected(false);
		this.boardSpaceSelected.setSelected(false);

		super.controller.depotBlackManager().removeTile(this.tileSelected);
		this.boardSpaceSelected.addTileAndRelocate(this.tileSelected);

	}

	private void setUpText() {

		super.controller.textManager().concealText();
		super.controller.textManager().showText(TextEnum.RESOLVE_ACTION);

		if (this.actionCanBeCompleted)
			super.controller.textManager().showText(TextEnum.CONTINUE);

	}

	private void checkSelected() {

		this.actionCanBeCompleted = false;

		if (this.tileSelected == null)
			return;

		if (this.boardSpaceSelected == null)
			return;

		TileTypeEnum tileTypeEnum = this.tileSelected.getTileTypeEnum();
		TileTypeEnum boardSpaceTypeEnum = this.boardSpaceSelected.getTileTypeEnum();

		if (tileTypeEnum != boardSpaceTypeEnum)
			return;

		if (tileTypeEnum == TileTypeEnum.BUILDING) {

			if (!super.controller.gameModifiers().canPlaceIdenticalBuildings()) {

				Building buildingSelected = (Building) this.tileSelected;
				BuildingTypeEnum buildingTypeEnum = buildingSelected.getBuildingTypeEnum();

				if (super.controller.playerBoard()
						.regionContainingBoardSpaceHasAnIdenticalBuilding(this.boardSpaceSelected, buildingTypeEnum))
					return;

			}

		}

		this.actionCanBeCompleted = true;

	}

}
