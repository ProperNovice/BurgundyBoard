package gameState;

import controller.Controller;
import enums.ActionEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import instances.Instances;
import javafx.scene.input.KeyCode;
import model.BoardSpace;
import model.Dice;
import tiles.Tile;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public abstract void handleGameStateChange();

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleKeyPressed(KeyCode keyCode) {

	}

	public void handleBoardSpacePressed(BoardSpace boardSpacePressed, TileTypeEnum tileTypeEnum, int diceValue) {

	}

	public void handleActionPressed(ActionEnum actionEnum) {

	}

	public void handleDiceRedPressed(Dice dice, int diceValue) {

	}

	public final void handleTilePressed(Tile tile, TileTypeEnum tileTypeEnum) {

		if (this.controller.depotNumberedManager().containsTile(tile))
			handleTileDepotNumberedPressed(tile, tileTypeEnum,
					this.controller.depotNumberedManager().getDepotNumberedValueContainingTile(tile));

		else if (this.controller.depotBlackManager().containsTile(tile))
			handleTileBlackPressed(tile, tileTypeEnum);

		else if (this.controller.storageSpaceManager().containsPriorTile(tile))
			handleTileStorageSpacePriorPressed(tile, tileTypeEnum);

	}

	protected void handleTileDepotNumberedPressed(Tile tile, TileTypeEnum tileTypeEnum, int depotNumberedValue) {

	}

	protected void handleTileBlackPressed(Tile tile, TileTypeEnum tileTypeEnum) {

	}

	protected void handleTileStorageSpacePriorPressed(Tile tile, TileTypeEnum tileTypeEnum) {

	}

}
