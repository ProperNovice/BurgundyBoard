package controller;

import enums.GameStateEnum;
import instances.Instances;
import utils.ArrayList;

public class FlowManager {

	private Controller controller = Instances.getControllerInstance();
	private ArrayList<GameStateEnum> gameStateNormalTurn = new ArrayList<>();
	private ArrayList<GameStateEnum> gameStateResolving = new ArrayList<>();

	public FlowManager() {

		createGameStateNormalTurn();

	}

	public void proceedToNextGameStatePhase() {

		if (this.gameStateResolving.isEmpty())
			this.gameStateResolving.addAll(this.gameStateNormalTurn);

		GameStateEnum gameStateEnum = this.gameStateResolving.removeFirst();
		this.controller.gameStateManager().setGameState(gameStateEnum);

	}

	public void addGameStateFirst(GameStateEnum gameStateEnum) {
		this.gameStateResolving.addFirst(gameStateEnum);
	}

	private void createGameStateNormalTurn() {

		this.gameStateNormalTurn.addLast(GameStateEnum.ROLL_DICE);
		this.gameStateNormalTurn.addLast(GameStateEnum.RESOLVE_GRAY_DICE);
		this.gameStateNormalTurn.addLast(GameStateEnum.CHOOSE_AN_ACTION);

	}

}
