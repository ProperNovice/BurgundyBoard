package gameState;

import enums.GameStateEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import javafx.scene.input.KeyCode;
import model.Goods;
import tiles.Black;
import tiles.Tile;
import utils.ArrayList;
import utils.Logger;

public class ResolveTileAddedShip extends GameState {

	private ResolvePhase resolvePhase = null;

	@Override
	public void handleGameStateChange() {

		this.resolvePhase = ResolvePhase.CHOOSE_GOODS;
		setUpText();
		logResolvePhase();

	}

	@Override
	protected void handleGoodsDepotNumberedPressed(int depotNumberedValue) {

		if (this.resolvePhase != ResolvePhase.CHOOSE_GOODS)
			return;

		super.controller.textManager().concealText();

		ArrayList<Goods> goods = super.controller.depotNumberedManager()
				.removeGoodsFromDepotNumbered(depotNumberedValue);

		super.controller.goodsManager().addPlayerGoodsAndRelocate(goods);
		super.controller.depotNumberedManager().removeAllGoods();

		if (super.controller.goodsManager().playerGoodsSizeAtLeaseFive()) {

			this.resolvePhase = ResolvePhase.TAKE_BLACK_TILE_CHOICE;
			setUpText();
			logResolvePhase();

		} else
			super.controller.flowManager().proceedToNextGameStatePhase();

	}

	@Override
	protected void handleTileBlackPressed(Tile tile, TileTypeEnum tileTypeEnum) {

		super.controller.textManager().concealText();

		super.controller.depotBlackManager().removeTile(tile);
		tile.setVisible(false);

		super.controller.goodsManager().removeFiveRandomGoodsAndRelocate();

		Tile tileBlack = new Black();
		super.controller.storageSpaceManager().addTileAndRelocate(tileBlack);
		tileBlack.setVisible(true);

		if (super.controller.storageSpaceManager().exceedsMaxedCapacity())
			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CHOOSE_TILE_TO_DISCARD);

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		super.controller.flowManager().proceedToNextGameStatePhase();
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode != KeyCode.Q)
			return;

		super.controller.textManager().concealText();
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private enum ResolvePhase {
		CHOOSE_GOODS, TAKE_BLACK_TILE_CHOICE
	}

	private void logResolvePhase() {

		Logger.log("resolve phase");
		Logger.logNewLine(this.resolvePhase);

	}

	private void setUpText() {

		switch (this.resolvePhase) {

		case CHOOSE_GOODS:
			super.controller.textManager().showText(TextEnum.RESOLVE_ACTION);
			break;

		case TAKE_BLACK_TILE_CHOICE:
			super.controller.textManager().showText(TextEnum.CHOOSE_BLACK_TILE);
			super.controller.textManager().showText(TextEnum.SKIP_BLACK_TILE);
			break;

		}

	}

}
