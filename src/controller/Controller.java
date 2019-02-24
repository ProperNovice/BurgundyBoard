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
	private WorkersManager workersManager = null;
	private SilverlingManager silverlingManager = null;
	private DepotBlackManager depotBlackManager = null;
	private StorageSpaceManager storageSpaceManager = null;
	private TileIndicatorManager tileIndicatorManager = null;
	private RegionScoringManager regionScoringManager = null;
	private DiceManager diceManager = null;
	private ActionManager actionManager = null;
	private GameModifiers gameModifiers = null;
	private VictoryPointManager victoryPointManager = null;
	private GroupActionsManager groupActionsManager = null;
	private ProgressionManager progressionManager = null;

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
		this.workersManager = new WorkersManager();
		this.silverlingManager = new SilverlingManager();
		this.depotBlackManager = new DepotBlackManager();
		this.storageSpaceManager = new StorageSpaceManager();
		this.tileIndicatorManager = new TileIndicatorManager();
		this.regionScoringManager = new RegionScoringManager();
		this.diceManager = new DiceManager();
		this.actionManager = new ActionManager();
		this.gameModifiers = new GameModifiers();
		this.victoryPointManager = new VictoryPointManager();
		this.groupActionsManager = new GroupActionsManager();
		this.progressionManager = new ProgressionManager();

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

	public WorkersManager workersManager() {
		return this.workersManager;
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

	public ActionManager actionManager() {
		return this.actionManager;
	}

	public GameModifiers gameModifiers() {
		return this.gameModifiers;
	}

	public VictoryPointManager victoryPointManager() {
		return this.victoryPointManager;
	}

	public GroupActionsManager groupActionsManager() {
		return this.groupActionsManager;
	}

	public ProgressionManager progressionManager() {
		return this.progressionManager;
	}

}
