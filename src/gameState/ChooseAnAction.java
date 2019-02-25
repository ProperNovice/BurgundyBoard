package gameState;

import enums.ActionEnum;
import enums.GameStateEnum;
import enums.TextEnum;
import utils.ArrayList;

public class ChooseAnAction extends GameState {

	@Override
	public void handleGameStateChange() {

		if (super.controller.diceManager().diceCurrentlyShowingAmount() == 0)
			super.controller.diceManager().setDiceCurrentlyShowingAvailableCurrentRound();

		System.out.println(super.controller.diceManager().diceCurrentlyShowingAmount());

		super.controller.textManager().showText(TextEnum.CHOOSE_AN_ACTION);

		ArrayList<ActionEnum> actionsToShow = new ArrayList<>();

		actionsToShow.addLast(ActionEnum.TAKE_TILE_FROM_THE_GAME_BOARD);
		actionsToShow.addLast(ActionEnum.TAKE_WORKERS_TILES);

		if (addTileToYourEstateAble())
			actionsToShow.addLast(ActionEnum.ADD_TILE_TO_YOUR_ESTATE);

		if (addBuyTileFromTheBlackDepotAble())
			actionsToShow.addLast(ActionEnum.BUY_TILE_FROM_THE_BLACK_DEPOT);

		super.controller.actionManager().showActions(actionsToShow);

		super.controller.diceManager().printDiceCurrentlyShowing();

	}

	private boolean addTileToYourEstateAble() {
		return !super.controller.storageSpaceManager().isEmpty();
	}

	private boolean addBuyTileFromTheBlackDepotAble() {

		if (!super.controller.silverlingManager().hasAtLeastTwoSilverlings())
			return false;

		if (!super.controller.gameModifiers().canBuyFromBlackMarketThisRound())
			return false;

		if (super.controller.tileManager().tileBlackListIsEmpty())
			return false;

		return true;

	}

	@Override
	public void handleActionPressed(ActionEnum actionEnum) {

		super.controller.textManager().concealText();
		super.controller.actionManager().concealActions();

		GameStateEnum gameStateEnum = null;

		switch (actionEnum) {

		case TAKE_TILE_FROM_THE_GAME_BOARD:
			gameStateEnum = GameStateEnum.ACTION_TAKE_TILE_FROM_THE_GAME_BOARD;
			break;

		case ADD_TILE_TO_YOUR_ESTATE:
			gameStateEnum = GameStateEnum.ACTION_ADD_TILE_TO_YOUR_ESTATE;
			break;

		case BUY_TILE_FROM_THE_BLACK_DEPOT:
			gameStateEnum = GameStateEnum.ACTION_BUY_TILE_FROM_THE_BLACK_DEPOT;
			break;

		case SELL_GOODS:
			break;

		case TAKE_WORKERS_TILES:
			gameStateEnum = GameStateEnum.ACTION_TAKE_WORKERS_TILES;
			break;

		}

		super.controller.flowManager().addGameStateResolvingFirst(gameStateEnum);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
