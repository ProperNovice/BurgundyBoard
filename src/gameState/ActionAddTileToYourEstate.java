package gameState;

import enums.ActionEnum;
import enums.BuildingTypeEnum;
import enums.GameStateEnum;
import enums.TileTypeEnum;
import model.BoardSpace;
import tiles.Building;
import tiles.Tile;
import utils.Logger;

public class ActionAddTileToYourEstate extends ExecuteDiceActions {

	private BoardSpace boardSpaceSelected = null;

	public ActionAddTileToYourEstate() {
		super.actionEnumToShow = ActionEnum.ADD_TILE_TO_YOUR_ESTATE;
	}

	@Override
	public void handleGameStateChange() {

		super.handleGameStateChange();

		this.boardSpaceSelected = null;

	}

	@Override
	public void handleBoardSpacePressed(BoardSpace boardSpacePressed, TileTypeEnum tileTypeEnum, int diceValue) {

		if (!boardSpacePressed.adjacentsContainTile())
			return;

		if (this.boardSpaceSelected != null)
			this.boardSpaceSelected.setSelected(false);

		this.boardSpaceSelected = boardSpacePressed;
		this.boardSpaceSelected.setSelected(true);

		super.numberTarget = this.boardSpaceSelected.getDiceValue();

		checkSelected();

	}

	@Override
	protected void handleTileStorageSpacePriorPressed(Tile tile, TileTypeEnum tileTypeEnum) {

		if (super.tileSelected != null)
			super.tileSelected.setSelected(false);

		super.tileSelected = tile;
		super.tileSelected.setSelected(true);

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

		if (this.boardSpaceSelected == null) {
			super.actionCanBeExecuted = false;
			return;
		}

		TileTypeEnum tileTypeEnumSelected = super.tileSelected.getTileTypeEnum();
		TileTypeEnum boardSpaceTileTypeEnumSelected = this.boardSpaceSelected.getTileTypeEnum();

		if (tileTypeEnumSelected != boardSpaceTileTypeEnumSelected) {
			super.actionCanBeExecuted = false;
			setUpText();
			return;
		}

		if (tileTypeEnumSelected == TileTypeEnum.BUILDING) {

			if (!super.controller.playerBoard().canBePlacedIdenticalBuildings()) {

				Building buildingSelected = (Building) super.tileSelected;
				BuildingTypeEnum buildingTypeEnum = buildingSelected.getBuildingTypeEnum();

				if (super.controller.playerBoard()
						.regionContainingBoardSpaceHasAnIdenticalBuilding(this.boardSpaceSelected, buildingTypeEnum)) {
					super.actionCanBeExecuted = false;
					setUpText();
					return;
				}

			}

		}

		int tileTypeEnumModifier = super.controller.diceModifiersManager()
				.getDiceModifierAddTileToYourEstate(tileTypeEnumSelected);

		Logger.logNewLine(tileTypeEnumSelected + " - " + tileTypeEnumModifier + " dice modifier ");

		setUpActionToBeExecuted(tileTypeEnumModifier);

		super.controller.workersManager().setWorkersTempAndRelocate(super.workersNeeded);

		setUpText();

	}

	@Override
	protected void executeAction() {

		super.controller.textManager().concealText();
		super.controller.actionManager().concealActions();

		super.controller.storageSpaceManager().removeTileAndRelocate(super.tileSelected);
		this.boardSpaceSelected.addTileAndRelocate(super.tileSelected);

		super.controller.workersManager().removeWorkersTemp();
		super.controller.diceManager().removeDiceFromAction(super.diceSelected);

		super.tileSelected.setSelected(false);
		super.diceSelected.setSelected(false);
		this.boardSpaceSelected.setSelected(false);

		if (super.controller.storageSpaceManager().exceedsMaxedCapacity())
			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_TILE_TO_DISCARD);

//		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
