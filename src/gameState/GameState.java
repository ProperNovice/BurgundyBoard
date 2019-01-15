package gameState;

import controller.Controller;
import enums.TextEnum;
import instances.Instances;
import javafx.scene.input.KeyCode;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public abstract void handleGameStateChange();

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleKeyPressed(KeyCode keyCode) {

	}

}
