package controller;

import board.PlayerBoard;
import instances.Instances;

public class Controller {

	private GameStateManager gameStateManager = null;
	private TextManager textManager = null;
	private FlowManager flowManager = null;
	private PlayerBoard playerBoard = null;
	private TileManager tileManager = null;
	private GoodsManager goodsManager = null;

	public Controller() {
		createInstances();
	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateManager = new GameStateManager();
		this.textManager = new TextManager();
		this.flowManager = new FlowManager();
		this.playerBoard = new PlayerBoard();
		this.tileManager = new TileManager();
		this.goodsManager = new GoodsManager();

	}

	public GameStateManager gameStateManager() {
		return this.gameStateManager;
	}

	public TextManager textManager() {
		return this.textManager;
	}

	public FlowManager flowManager() {
		return this.flowManager;
	}

	public PlayerBoard playerBoard() {
		return this.playerBoard;
	}

	public TileManager tileManager() {
		return this.tileManager;
	}

	public GoodsManager goodsManager() {
		return this.goodsManager;
	}

}
