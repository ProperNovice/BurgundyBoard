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
		TileTypeEnum tileTypeEnumFirst, tileTypeEnumSecond;
		Tile tileFirst, tileSecond;

		for (int counter = 1; counter <= 6; counter++) {

			list = super.controller.depotNumberedManager().getDepotNumberedTileTypeEnumList(counter);

			tileTypeEnumFirst = list.get(0);
			tileTypeEnumSecond = list.get(1);

			tileFirst = super.controller.tileManager().getRandomTileNormalSetVisibleTrue(tileTypeEnumFirst);
			tileSecond = super.controller.tileManager().getRandomTileNormalSetVisibleTrue(tileTypeEnumSecond);

			super.controller.depotNumberedManager().addTilesToDepotNumbers(counter, tileFirst, tileSecond);

		}

	}

}
