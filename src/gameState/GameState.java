package gameState;

import instances.Instances;
import javafx.scene.input.KeyCode;
import controller.Controller;
import enums.TextEnum;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public abstract void handleGameStateChange();

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleKeyPressed(KeyCode keyCode) {

	}

}
