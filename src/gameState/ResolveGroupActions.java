package gameState;

import enums.GameStateEnum;
import enums.TextEnum;
import utils.ArrayList;
import utils.Logger;

public class ResolveGroupActions extends GameState {

	@Override
	public void handleGameStateChange() {

		ArrayList<GameStateEnum> groupActionList = super.controller.groupActionsManager().getGroupActionsList();

		Logger.log("group actions list");
		groupActionList.printList();

//		if (groupActionList.size() == 1)
//			executeGameStateEnum(groupActionList.getFirst());
//		else
			handleGroupActionListTextEnums(groupActionList);

	}

	private void handleGroupActionListTextEnums(ArrayList<GameStateEnum> groupActionList) {

		if (groupActionList.contains(GameStateEnum.RESOLVE_TILE_ADDED)) {
			super.controller.textManager().concealText();
			handleTextOptionPressed(TextEnum.RESOLVE_TILE_ADDED);
			return;
		}

		for (GameStateEnum gameStateEnum : groupActionList) {

			switch (gameStateEnum) {

			case RESOLVE_TILE_ADDED:
				super.controller.textManager().showText(TextEnum.RESOLVE_TILE_ADDED);
				break;

			case RESOLVE_VICTORY_POINTS_TARGET_REACHED:
				super.controller.textManager().showText(TextEnum.RESOLVE_VICTORY_POINTS_TARGET_REACHED);
				break;

			case RESOLVE_TILE_TYPE_IS_COMPLETED:
				super.controller.textManager().showText(TextEnum.RESOLVE_COMPLETED_TYPE);

			default:
				break;

			}

		}

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		GameStateEnum gameStateEnum = null;

		switch (textEnum) {

		case RESOLVE_TILE_ADDED:
			gameStateEnum = GameStateEnum.RESOLVE_TILE_ADDED;
			break;

		case RESOLVE_VICTORY_POINTS_TARGET_REACHED:
			gameStateEnum = GameStateEnum.RESOLVE_VICTORY_POINTS_TARGET_REACHED;
			break;

		case RESOLVE_COMPLETED_TYPE:
			gameStateEnum = GameStateEnum.RESOLVE_TILE_TYPE_IS_COMPLETED;
			break;

		default:
			break;

		}

		executeGameStateEnum(gameStateEnum);

	}

	private void executeGameStateEnum(GameStateEnum gameStateEnum) {

		super.controller.groupActionsManager().removeGroupAction(gameStateEnum);

		if (!super.controller.groupActionsManager().isEmpty())
			super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.RESOLVE_GROUP_ACTIONS);

		super.controller.flowManager().addGameStateResolvingFirst(gameStateEnum);
		super.controller.flowManager().proceedToNextGameStatePhase();

	}

}
