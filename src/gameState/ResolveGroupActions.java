package gameState;

import enums.TextEnum;
import utils.Logger;

public class ResolveGroupActions extends GameState {

	@Override
	public void handleGameStateChange() {

		Logger.log("group actions list");
		super.controller.groupActionsManager().getGroupActionsList().printList();

		super.controller.textManager().showText(TextEnum.RESOLVE_TILE_ADDED);
		super.controller.textManager().showText(TextEnum.RESOLVE_VICTORY_POINTS_TARGET_REACHED);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		System.out.println(textEnum);

	}

}
