package gameState;

import enums.TextEnum;
import javafx.scene.input.KeyCode;

public class ChooseDifficulty extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.EASY);
		super.controller.textManager().showText(TextEnum.MEDIUM);
		super.controller.textManager().showText(TextEnum.HARD);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		executeAction(textEnum);
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		switch (keyCode) {

		case Q:
			executeAction(TextEnum.EASY);
			break;

		case W:
			executeAction(TextEnum.MEDIUM);
			break;

		case E:
			executeAction(TextEnum.HARD);
			break;

		default:
			break;

		}

	}

	private void executeAction(TextEnum textEnum) {

		super.controller.textManager().concealText();

		int victoryPointsTarget = -1;

		switch (textEnum) {

		case EASY:
			victoryPointsTarget = 45;
			break;

		case MEDIUM:
			victoryPointsTarget = 50;
			break;

		case HARD:
			victoryPointsTarget = 55;
			break;

		default:
			break;

		}

		super.controller.victoryPointManager().setTargetVictoryPoints(victoryPointsTarget);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
