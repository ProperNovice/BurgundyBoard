package gameState;

import enums.TextEnum;
import javafx.scene.input.KeyCode;
import utils.Instances;

public class EndGame extends GameState {

	@Override
	public void handleGameStateChange() {

		TextEnum textEnumToShow = null;

		if (super.controller.playerBoard().playerBoardIsComplete())
			textEnumToShow = TextEnum.YOU_WON;
		else
			textEnumToShow = TextEnum.YOU_LOST;

		super.controller.textManager().showText(textEnumToShow);
		super.controller.textManager().showText(TextEnum.RESTART);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		executeRestart();
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {
		super.controller.textManager().concealText();
		executeRestart();
	}

	private void executeRestart() {
		Instances.getPanelGameInstance().restartGame();
	}

}
