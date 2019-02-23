package controller;

import enums.GameStateEnum;
import instances.Instances;
import utils.ArrayList;

public class FlowManager {

	private Controller controller = Instances.getControllerInstance();
	private ArrayList<GameStateEnum> gameStateNormalTurn = new ArrayList<>();
	private ArrayList<GameStateEnum> gameStateResolving = new ArrayList<>();

	public FlowManager() {

//		createGameStateNormalTurn();

//		this.gameStateResolving.addLast(GameStateEnum.CHOOSE_DIFFICULTY);
//		this.gameStateResolving.addLast(GameStateEnum.CHOOSE_SPACE_TO_PLACE_THE_CASTLE);
		this.gameStateResolving.addLast(GameStateEnum.START_NEW_PHASE);

	}

	public void proceedToNextGameStatePhase() {

		if (this.gameStateResolving.isEmpty())
			this.gameStateResolving.addAll(this.gameStateNormalTurn);

		GameStateEnum gameStateEnum = this.gameStateResolving.removeFirst();
		this.controller.gameStateManager().setGameState(gameStateEnum);

	}

	public void addGameStateResolvingFirst(GameStateEnum gameStateEnum) {
		this.gameStateResolving.addFirst(gameStateEnum);
	}

	public void createGameStatesNewRound() {

		this.gameStateNormalTurn.addLast(GameStateEnum.RESOLVE_GRAY_DICE);
		this.gameStateNormalTurn.addLast(GameStateEnum.CHOOSE_AN_ACTION);
		this.gameStateNormalTurn.addLast(GameStateEnum.CHOOSE_AN_ACTION);
		this.gameStateNormalTurn.addLast(GameStateEnum.END_OF_ACTIONS);

	}

//	private void createGameStateNormalTurn() {
//		ShutDown.execute("flow manager\ncreateGameStateNormalTurn()");
//	}

}
