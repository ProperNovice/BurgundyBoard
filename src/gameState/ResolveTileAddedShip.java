package gameState;

import enums.TextEnum;
import model.Goods;
import utils.ArrayList;

public class ResolveTileAddedShip extends GameState {

	private ResolvePhase resolvePhase = null;

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.RESOLVE_ACTION);
		this.resolvePhase = ResolvePhase.CHOOSE_GOODS;

	}

	@Override
	protected void handleGoodsDepotNumberedPressed(int depotNumberedValue) {

		if (this.resolvePhase != ResolvePhase.CHOOSE_GOODS)
			return;

		super.controller.textManager().concealText();

		ArrayList<Goods> goods = super.controller.depotNumberedManager()
				.removeGoodsFromDepotNumbered(depotNumberedValue);

		super.controller.goodsManager().addPlayerGoodsAndRelocate(goods);

	}

	private enum ResolvePhase {
		CHOOSE_GOODS, TAKE_BLACK_TILE
	}

}
