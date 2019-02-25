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

		if (super.controller.storageSpaceManager().containsExactlyOneTile()) {

			Tile tile = super.controller.storageSpaceManager().getFirstTile();

			super.tileSelected = tile;
			super.tileSelected.setSelected(true);

		}

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

		super.controller.workersManager().resetWorkersTempAndRelocate();

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

		if (tileTypeEnumSelected != TileTypeEnum.BLACK) {

			if (tileTypeEnumSelected != boardSpaceTileTypeEnumSelected) {
				super.actionCanBeExecuted = false;
				setUpText();
				return;
			}
		}

		if (tileTypeEnumSelected == TileTypeEnum.BUILDING) {

			if (!super.controller.gameModifiers().canPlaceIdenticalBuildings()) {

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

		int tileTypeEnumModifier = super.controller.gameModifiers()
				.getDiceModifierAddTileToYourEstate(boardSpaceTileTypeEnumSelected);

		Logger.logNewLine(boardSpaceTileTypeEnumSelected + " - " + tileTypeEnumModifier + " dice modifier ");

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
		super.controller.diceManager().removeDiceCurrentlyShowingFromActionAndRelocate(super.diceSelected);

		super.tileSelected.setSelected(false);
		super.diceSelected.setSelected(false);
		this.boardSpaceSelected.setSelected(false);

		super.controller.gameModifiers().setLastTileAddedToBoardSpace(super.tileSelected, this.boardSpaceSelected);

		handleCheckIfCompletesRegion();

		if (this.tileSelected.getTileTypeEnum() != TileTypeEnum.BLACK)
			super.controller.groupActionsManager().addGroupAction(GameStateEnum.RESOLVE_TILE_ADDED);

		if (super.controller.playerBoard().tileTypeIsCompleted(this.boardSpaceSelected.getTileTypeEnum()))
			super.controller.groupActionsManager().addGroupAction(GameStateEnum.RESOLVE_TILE_TYPE_IS_COMPLETED);

		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.RESOLVE_GROUP_ACTIONS);

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private void handleCheckIfCompletesRegion() {

		boolean boardSpaceCompletesRegion = super.controller.playerBoard()
				.boardSpaceCompletesRegion(this.boardSpaceSelected);

		if (!boardSpaceCompletesRegion)
			return;

		int regionTotalSize = super.controller.playerBoard().getRegionTotalSize(this.boardSpaceSelected);

		int regionTotalPoints = super.controller.regionScoringManager().getRegionTotalPoints(regionTotalSize);

		int currentPhaseRegionCompletedVictoryPoints = super.controller.phaseIndicatorManager()
				.getCurrentPhaseRegionCompletedVictoryPoints();

		int totalPoints = regionTotalPoints + currentPhaseRegionCompletedVictoryPoints;

		super.controller.victoryPointManager().addCurrentVictoryPoints(totalPoints);

		if (!super.controller.victoryPointManager().currentVictoryPointsReachedTargetVictoryPoints())
			return;

		super.controller.groupActionsManager().addGroupAction(GameStateEnum.RESOLVE_VICTORY_POINTS_TARGET_REACHED);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.RESOLVE_GROUP_ACTIONS);

		super.controller.victoryPointManager().resetScoring();

	}

}
