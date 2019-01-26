package gameState;

import controller.Controller;
import enums.TextEnum;
import enums.TileTypeEnum;
import instances.Instances;
import javafx.scene.input.KeyCode;
import model.BoardSpace;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public abstract void handleGameStateChange();

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleKeyPressed(KeyCode keyCode) {

	}

	public void handleBoardSpacePressed(BoardSpace boardSpacePressed, TileTypeEnum tileTypeEnum, int diceValue) {

	}

}
