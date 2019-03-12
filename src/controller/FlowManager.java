package controller;

import enums.GameStateEnum;
import utils.ArrayList;
import utils.Instances;

public class FlowManager {

	private Controller controller = Instances.getControllerInstance();
	private ArrayList<GameStateEnum> gameStateResolving = new ArrayList<>();
	private ArrayList<GameStateEnum> notUpdatingProgressionWin = new ArrayList<>();

	public FlowManager() {

		createNotUpdatingProgression();

		this.gameStateResolving.addLast(GameStateEnum.CHOOSE_DIFFICULTY);
		this.gameStateResolving.addLast(GameStateEnum.CHOOSE_SPACE_TO_PLACE_THE_CASTLE);
		this.gameStateResolving.addLast(GameStateEnum.START_NEW_PHASE);

	}

	public void proceedToNextGameStatePhase() {

		if (this.gameStateResolving.isEmpty())
			this.gameStateResolving.addLast(GameStateEnum.END_OF_ACTION);

		GameStateEnum gameStateEnum = this.gameStateResolving.removeFirst();
		this.controller.gameStateManager().setGameState(gameStateEnum);

	}

	public void addGameStateResolvingFirst(GameStateEnum gameStateEnum) {

		this.gameStateResolving.addFirst(gameStateEnum);

		if (this.notUpdatingProgressionWin.contains(gameStateEnum))
			return;

		this.gameStateResolving.addFirst(GameStateEnum.CHECK_FOR_WIN);
		this.gameStateResolving.addFirst(GameStateEnum.PROGRESSION_UPDATE);

	}

	private void createNotUpdatingProgression() {

		this.notUpdatingProgressionWin.addLast(GameStateEnum.RESOLVE_GRAY_DICE);
		this.notUpdatingProgressionWin.addLast(GameStateEnum.PROGRESSION_UPDATE);
		this.notUpdatingProgressionWin.addLast(GameStateEnum.CHECK_FOR_WIN);
		this.notUpdatingProgressionWin.addLast(GameStateEnum.END_GAME);

	}

	public void clearFlow() {
		this.gameStateResolving.clear();
	}

}
