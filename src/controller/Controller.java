package controller;

import instances.Instances;

public class Controller {

	private GameStateManager gameStateManager = null;
	private TextManager textManager = null;
	private FlowManager flowManager = null;
	private PlayerBoard playerBoard = null;
	private TileManager tileManager = null;
	private GoodsManager goodsManager = null;
	private PhaseIndicatorManager phaseManager = null;
	private DepotNumberedManager depotNumberedManager = null;
	private WorkerManager workerManager = null;
	private SilverlingManager silverlingManager = null;
	private DepotBlackManager depotBlackManager = null;
	private StorageSpaceManager storageSpaceManager = null;
	private TileIndicatorManager tileIndicatorManager = null;
	private RegionScoringManager regionScoringManager = null;
	private DiceManager diceManager = null;

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
		this.phaseManager = new PhaseIndicatorManager();
		this.depotNumberedManager = new DepotNumberedManager();
		this.workerManager = new WorkerManager();
		this.silverlingManager = new SilverlingManager();
		this.depotBlackManager = new DepotBlackManager();
		this.storageSpaceManager = new StorageSpaceManager();
		this.tileIndicatorManager = new TileIndicatorManager();
		this.regionScoringManager = new RegionScoringManager();
		this.diceManager = new DiceManager();

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

	public PhaseIndicatorManager phaseIndicatorManager() {
		return this.phaseManager;
	}

	public DepotNumberedManager depotNumberedManager() {
		return this.depotNumberedManager;
	}

	public WorkerManager workerManager() {
		return this.workerManager;
	}

	public SilverlingManager silverlingManager() {
		return this.silverlingManager;
	}

	public DepotBlackManager depotBlackManager() {
		return this.depotBlackManager;
	}

	public StorageSpaceManager storageSpaceManager() {
		return this.storageSpaceManager;
	}

	public TileIndicatorManager tileIndicatorManager() {
		return this.tileIndicatorManager;
	}

	public RegionScoringManager regionScoringManager() {
		return this.regionScoringManager;
	}

	public DiceManager diceManager() {
		return this.diceManager;
	}

}
