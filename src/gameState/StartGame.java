package gameState;

import enums.GameStateEnum;
import model.Goods;
import tiles.Castle;
import tiles.Tile;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

//		addTilesToGameBoard();
//		addGoodsToDepotNumbers();
//		setDiceValuesRed();

		super.controller.flowManager().addGameStateFirst(GameStateEnum.START_NEW_PHASE);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	private void addTilesToGameBoard() {

		Tile tile = null;

		tile = new Castle();
		super.controller.playerBoard().testAddTileToBoardSpace(tile, 6);

	}

	private void addGoodsToDepotNumbers() {

		int depotNumbered = 1;

		Goods a = new Goods(1);
		a.setVisible(true);
		Goods b = new Goods(6);
		b.setVisible(true);
		Goods c = new Goods(4);
		c.setVisible(true);

		super.controller.depotNumberedManager().addGoodsToDepotNumbered(a, depotNumbered);
		super.controller.depotNumberedManager().addGoodsToDepotNumbered(b, depotNumbered);
		super.controller.depotNumberedManager().addGoodsToDepotNumbered(c, depotNumbered);

	}

	private void setDiceValuesRed() {
		super.controller.diceManager().testSetRedDiceValuesAndRelocate(2, 6);
	}

}
