package gameState;

import enums.ActionEnum;
import enums.GameStateEnum;
import enums.TextEnum;
import utils.ArrayList;

public class ChooseAnAction extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textManager().showText(TextEnum.CHOOSE_AN_ACTION);

		ArrayList<ActionEnum> actionsToShow = new ArrayList<>();

		actionsToShow.addLast(ActionEnum.TAKE_TILE_FROM_THE_GAME_BOARD);
		actionsToShow.addLast(ActionEnum.TAKE_WORKERS_TILES);

		if (addTileToYourEstate())
			actionsToShow.addLast(ActionEnum.ADD_TILE_TO_YOUR_ESTATE);

		if (addBuyTileFromTheBlackDepot())
			actionsToShow.addLast(ActionEnum.BUY_TILE_FROM_THE_BLACK_DEPOT);

		super.controller.actionManager().showActions(actionsToShow);

	}

	private boolean addTileToYourEstate() {
		return !super.controller.storageSpaceManager().isEmpty();
	}

	private boolean addBuyTileFromTheBlackDepot() {
		return super.controller.silverlingManager().hasAtLeastTwoSilverlings();
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
			break;

		case BUY_TILE_FROM_THE_BLACK_DEPOT:
			break;

		case SELL_GOODS:
			break;

		case TAKE_WORKERS_TILES:
			break;

		}

		super.controller.flowManager().addGameStateResolvingFirst(gameStateEnum);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
