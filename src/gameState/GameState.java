package gameState;

import controller.Controller;
import enums.ActionEnum;
import enums.TextEnum;
import enums.TileTypeEnum;
import javafx.scene.input.KeyCode;
import model.BoardSpace;
import model.Dice;
import model.Goods;
import tiles.Tile;
import utils.Instances;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public abstract void handleGameStateChange();

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleKeyPressed(KeyCode keyCode) {

	}

	public void handleBoardSpacePressed(BoardSpace boardSpacePressed, TileTypeEnum tileTypeEnum, int diceValue) {

	}

	public void handleActionPressed(ActionEnum actionEnum) {

	}

	public void handleDiceRedPressed(Dice dice, int diceValue) {

	}

	public final void handleTilePressed(Tile tile, TileTypeEnum tileTypeEnum) {

		if (this.controller.depotNumberedManager().containsTile(tile))
			handleTileDepotNumberedPressed(tile, tileTypeEnum,
					this.controller.depotNumberedManager().getDepotNumberedValueContainingTile(tile));

		else if (this.controller.depotBlackManager().containsTile(tile))
			handleTileBlackPressed(tile, tileTypeEnum);

		else if (this.controller.storageSpaceManager().containsPriorTile(tile))
			handleTileStorageSpacePriorPressed(tile, tileTypeEnum);

	}

	protected void handleTileDepotNumberedPressed(Tile tile, TileTypeEnum tileTypeEnum, int depotNumberedValue) {

	}

	protected void handleTileBlackPressed(Tile tile, TileTypeEnum tileTypeEnum) {

	}

	protected void handleTileStorageSpacePriorPressed(Tile tile, TileTypeEnum tileTypeEnum) {

	}

	public final void handleGoodsPressed(Goods goods, int diceValue) {

		if (this.controller.depotNumberedManager().containsGoods(goods))
			handleGoodsDepotNumberedPressed(
					this.controller.depotNumberedManager().getDepotNumberedValueContainingGoods(goods));

	}

	protected void handleGoodsDepotNumberedPressed(int depotNumberedValue) {

	}

	public void restartRound() {

		this.controller.flowManager().clearFlow();
		this.controller.textManager().concealText();
		this.controller.saveLoadManager().loadState();
		this.controller.flowManager().proceedToNextGameStatePhase();

	}

}
