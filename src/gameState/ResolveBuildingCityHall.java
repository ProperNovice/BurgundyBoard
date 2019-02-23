package gameState;

import enums.BuildingTypeEnum;
import enums.GameStateEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import model.BoardSpace;
import tiles.Building;
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
		executeAction();
	}

	private void checkSelected() {

		if (this.tileSelected == null)
			return;

		if (this.boardSpaceSelected == null)
			return;

		if (this.tileSelected.getTileTypeEnum() == TileTypeEnum.BLACK) {
			this.actionCanBeExecuted = true;
			return;
		}

		if (this.tileSelected.getTileTypeEnum() != this.boardSpaceSelected.getTileTypeEnum()) {
			this.actionCanBeExecuted = false;
			return;
		}

		if (this.boardSpaceSelected.getTileTypeEnum() == TileTypeEnum.BUILDING) {

			if (!super.controller.gameModifiers().canPlaceIdenticalBuildings()) {

				Building buildingSelected = (Building) this.tileSelected;
				BuildingTypeEnum buildingTypeEnum = buildingSelected.getBuildingTypeEnum();

				if (super.controller.playerBoard()
						.regionContainingBoardSpaceHasAnIdenticalBuilding(this.boardSpaceSelected, buildingTypeEnum)) {
					this.actionCanBeExecuted = false;
					setUpText();
					return;
				}

			}

		}

		this.actionCanBeExecuted = true;

		setUpText();

	}

	private void setUpText() {

		super.controller.textManager().concealText();
		super.controller.textManager().showText(TextEnum.RESOLVE_ACTION);

		if (!this.actionCanBeExecuted)
			return;

		super.controller.textManager().showText(TextEnum.CONTINUE);

	}

	private void executeAction() {

		this.tileSelected.setSelected(false);
		this.boardSpaceSelected.setSelected(false);

		super.controller.storageSpaceManager().removeTileAndRelocate(this.tileSelected);
		this.boardSpaceSelected.addTileAndRelocate(this.tileSelected);

		super.controller.gameModifiers().setLastTileAddedToBoardSpace(this.tileSelected, this.boardSpaceSelected);
		handleCheckIfCompletesRegion();

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
