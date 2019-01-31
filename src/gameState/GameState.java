package gameState;

import controller.Controller;
import enums.ActionEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import instances.Instances;
import javafx.scene.input.KeyCode;
import model.BoardSpace;
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

	public final void handleTilePressed(Tile tile, TileTypeEnum tileTypeEnum) {

		if (this.controller.depotNumberedManager().containsTile(tile))
			handleTileDepotNumberedPressed(tile, tileTypeEnum);

	}

	protected void handleTileDepotNumberedPressed(Tile tile, TileTypeEnum tileTypeEnum) {

	}

}
