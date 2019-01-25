package gameState;

import enums.TileTypeEnum;
import tiles.Tile;
import utils.ArrayList;

public class StartNewPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		setNewPhaseIndicator();
		createNewPhaseGoodsAndRelocate();
		addTilesToDepotsNumbered();

	}

	private void setNewPhaseIndicator() {
		super.controller.phaseIndicatorManager().setNewPhaseIndicator();
	}

	private void createNewPhaseGoodsAndRelocate() {
		super.controller.goodsManager().createNewPhaseGoodsAndRelocate();
	}

	private void addTilesToDepotsNumbered() {

		ArrayList<TileTypeEnum> list = null;
		Tile tileFirst, tileSecond;

		for (int counter = 1; counter <= 6; counter++) {

			list = super.controller.depotNumberedManager().getDepotNumberedTileTypeEnumList(counter);

			tileFirst = super.controller.tileManager().getRandomTileNormalSetVisibleTrue(list.get(0));
			tileSecond = super.controller.tileManager().getRandomTileNormalSetVisibleTrue(list.get(1));

			super.controller.depotNumberedManager().addTilesToDepotNumbers(counter, tileFirst, tileSecond);

		}

	}

}
