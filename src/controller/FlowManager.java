package controller;

import enums.GameStateEnum;
import instances.Instances;
import utils.ArrayList;

public class FlowManager {

	private Controller controller = Instances.getControllerInstance();
	private ArrayList<GameStateEnum> gameStateNormalTurn = new ArrayList<>();
	private ArrayList<GameStateEnum> gameStateResolving = new ArrayList<>();
	private ArrayList<GameStateEnum> notUpdatingProgression = new ArrayList<>();

	public FlowManager() {

//		createGameStateNormalTurn();

		createNotUpdatingProgression();

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

		if (this.notUpdatingProgression.contains(gameStateEnum))
			return;

		this.gameStateResolving.addFirst(GameStateEnum.PROGRESSION_UPDATE);

	}

	public void createGameStatesForNewRound() {

		this.gameStateNormalTurn.addLast(GameStateEnum.RESOLVE_GRAY_DICE);
		this.gameStateNormalTurn.addLast(GameStateEnum.CHOOSE_AN_ACTION);
		this.gameStateNormalTurn.addLast(GameStateEnum.CHOOSE_AN_ACTION);
		this.gameStateNormalTurn.addLast(GameStateEnum.END_OF_ACTIONS);

	}

	private void createNotUpdatingProgression() {

	}

//	private void createGameStateNormalTurn() {
//		ShutDown.execute("flow manager\ncreateGameStateNormalTurn()");
//	}

}
