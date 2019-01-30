package gameState;

import enums.TextEnum;
import javafx.scene.input.KeyCode;
import model.Goods;

public class ResolveGrayDice extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.RESOLVE_GRAY_DICE);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		super.controller.textManager().concealText();
		resolveGrayDice();

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {
		super.controller.textManager().concealText();
		resolveGrayDice();
	}

	private void resolveGrayDice() {

		Goods goods = super.controller.goodsManager().removeFirst();
		int diceGrayValue = super.controller.diceManager().getDiceGrayValue();

		super.controller.depotNumberedManager().addGoodsToDepotNumbered(goods, diceGrayValue);
		super.controller.diceManager().setDiceGrayInactive();

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
