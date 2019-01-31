package gameState;

import enums.TextEnum;
import enums.TileTypeEnum;
import javafx.scene.input.KeyCode;
import tiles.Tile;
import utils.ArrayList;

public class StartNewPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.START_NEW_PHASE);

		// TODO

		super.controller.textManager().concealText();
		handleTextOptionPressed(null);
	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		executeStartNewPhase();
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode != KeyCode.Q)
			return;

		super.controller.textManager().concealText();
		executeStartNewPhase();

	}

	private void executeStartNewPhase() {

		setNewPhaseIndicator();
		createNewPhaseGoodsAndRelocate();
		addTilesToDepotsNumbered();
		addTilesToDepotsBlack();
		proceedToNextGameState();

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

			super.controller.depotNumberedManager().addTilesToDepotNumbered(counter, tileFirst, tileSecond);

		}

	}

	private void addTilesToDepotsBlack() {

		ArrayList<Tile> tilesBlack = new ArrayList<>();

		for (int counter = 1; counter <= 4; counter++) {
			tilesBlack.addLast(super.controller.tileManager().getRandomTileBlack());
		}

		super.controller.depotBlackManager().addTilesAndRelocate(tilesBlack);

	}

	private void proceedToNextGameState() {
		super.controller.flowManager().proceedToNextGameStatePhase();
	}

}
