package gameState;

public class ResolveGroupActions extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.groupActionsManager().getGroupActionsList().printList();

	}

}
