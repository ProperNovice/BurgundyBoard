package gameState;

import enums.TextEnum;

public class ChooseAnAction extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.CHOOSE_AN_ACTION);

	}

}
