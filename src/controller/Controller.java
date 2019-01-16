package controller;

import board.Board;
import instances.Instances;

public class Controller {

	private GameStateController gameStateController = null;
	private TextController textController = null;
	private FlowController flowController = null;
	private Board board = null;
	private TileController tileController = null;
	private GoodsController goodsController = null;

	public Controller() {
		createInstances();
	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateController = new GameStateController();
		this.textController = new TextController();
		this.flowController = new FlowController();
		this.board = new Board();
		this.tileController = new TileController();
		this.goodsController = new GoodsController();

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

	public Board board() {
		return this.board;
	}

	public TileController tileController() {
		return this.tileController;
	}

	public GoodsController goodsController() {
		return this.goodsController;
	}

}
