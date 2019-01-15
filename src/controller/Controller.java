package controller;

import board.Board;
import instances.Instances;

public class Controller {

	private GameStateController gameStateController = null;
	private TextController textController = null;
	private FlowController flowController = null;
	private TileController tileController = null;
	private Board board = null;

	public Controller() {
		createInstances();
	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateController = new GameStateController();
		this.textController = new TextController();
		this.flowController = new FlowController();
		this.tileController = new TileController();
		this.board = new Board();

	}

	public GameStateController gameStateController() {
		return this.gameStateController;
	}

	public TextController textController() {
		return this.textController;
	}

	public FlowController flowController() {
		return this.flowController;
	}

	public TileController tileController() {
		return this.tileController;
	}

	public Board board() {
		return this.board;
	}

}
