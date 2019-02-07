package controller;

import enums.BuildingTypeEnum;
import enums.TileTypeEnum;
import instances.Instances;
import model.BoardSpace;
import tiles.Building;
import tiles.Tile;
import utils.ArrayList;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
import utils.ImageView;

public class PlayerBoard implements EventHandlerAble {

	private ImageView imageView = null;
	private ArrayList<BoardSpace> boardSpaces = new ArrayList<>();
	private ArrayList<ArrayList<BoardSpace>> regions = new ArrayList<>();

	public PlayerBoard() {

		createBoard();
		createSpaces();
		createAdjacencies();
		createRegions();

	}

	private void createRegions() {

		addBoardSpacesToNewRegion(getBoardSpace(0));
		addBoardSpacesToNewRegion(getBoardSpace(1));
		addBoardSpacesToNewRegion(getBoardSpace(2), getBoardSpace(3));
		addBoardSpacesToNewRegion(getBoardSpace(4), getBoardSpace(8));
		addBoardSpacesToNewRegion(getBoardSpace(5));
		addBoardSpacesToNewRegion(getBoardSpace(6));
		addBoardSpacesToNewRegion(getBoardSpace(7));
		addBoardSpacesToNewRegion(getBoardSpace(9));
		addBoardSpacesToNewRegion(getBoardSpace(10));

		addBoardSpacesToNewRegion(getBoardSpace(11), getBoardSpace(12), getBoardSpace(13));
		addBoardSpacesToNewRegion(getBoardSpace(14), getBoardSpace(18), getBoardSpace(23));
		addBoardSpacesToNewRegion(getBoardSpace(19));
		addBoardSpacesToNewRegion(getBoardSpace(15));
		addBoardSpacesToNewRegion(getBoardSpace(16), getBoardSpace(20));
		addBoardSpacesToNewRegion(getBoardSpace(17));
		addBoardSpacesToNewRegion(getBoardSpace(21));
		addBoardSpacesToNewRegion(getBoardSpace(22));

		addBoardSpacesToNewRegion(getBoardSpace(24));
		addBoardSpacesToNewRegion(getBoardSpace(25));
		addBoardSpacesToNewRegion(getBoardSpace(26));
		addBoardSpacesToNewRegion(getBoardSpace(27));
		addBoardSpacesToNewRegion(getBoardSpace(28));
		addBoardSpacesToNewRegion(getBoardSpace(29));
		addBoardSpacesToNewRegion(getBoardSpace(30));

		addBoardSpacesToNewRegion(getBoardSpace(31), getBoardSpace(33), getBoardSpace(34));
		addBoardSpacesToNewRegion(getBoardSpace(32));
		addBoardSpacesToNewRegion(getBoardSpace(35));
		addBoardSpacesToNewRegion(getBoardSpace(36));

	}

	private BoardSpace getBoardSpace(int index) {
		return this.boardSpaces.get(index);
	}

	private void addBoardSpacesToNewRegion(BoardSpace... boardSpaces) {

		ArrayList<BoardSpace> list = new ArrayList<>();
		list.addAll(boardSpaces);

		this.regions.addLast(list);

	}

	private void createBoard() {

		this.imageView = new ImageView("boards/a.png", this);
		this.imageView.setScale(Credentials.boardScale);
		this.imageView.relocate(Credentials.CoordinatesBoard.x, Credentials.CoordinatesBoard.y);

	}

	private void createSpaces() {

		// 0
		createSpace(TileTypeEnum.SHIP, 6, 663, 71);

		// 1
		createSpace(TileTypeEnum.MINE, 5, 769, 70);

		// 2
		createSpace(TileTypeEnum.BUILDING, 6, 878, 72);

		// 3
		createSpace(TileTypeEnum.BUILDING, 2, 987, 72);

		// 4
		createSpace(TileTypeEnum.BUILDING, 4, 716, 163);

		// 5
		createSpace(TileTypeEnum.ANIMAL, 2, 823, 162);

		// 6
		createSpace(TileTypeEnum.CASTLE, 4, 932, 165);

		// 7
		createSpace(TileTypeEnum.KNOWLEDGE, 3, 1038, 161);

		// 8
		createSpace(TileTypeEnum.BUILDING, 6, 768, 255);

		// 9
		createSpace(TileTypeEnum.SHIP, 3, 878, 257);

		// 10
		createSpace(TileTypeEnum.BUILDING, 1, 986, 256);

		// 11
		createSpace(TileTypeEnum.KNOWLEDGE, 5, 610, 509);

		// 12
		createSpace(TileTypeEnum.KNOWLEDGE, 3, 719, 507);

		// 13
		createSpace(TileTypeEnum.KNOWLEDGE, 5, 827, 508);

		// 14
		createSpace(TileTypeEnum.ANIMAL, 1, 932, 508);

		// 15
		createSpace(TileTypeEnum.SHIP, 1, 554, 604);

		// 16
		createSpace(TileTypeEnum.BUILDING, 2, 663, 602);

		// 17
		createSpace(TileTypeEnum.CASTLE, 4, 772, 602);

		// 18
		createSpace(TileTypeEnum.ANIMAL, 6, 878, 601);

		// 19
		createSpace(TileTypeEnum.SHIP, 1, 986, 603);

		// 20
		createSpace(TileTypeEnum.BUILDING, 6, 608, 697);

		// 21
		createSpace(TileTypeEnum.MINE, 5, 718, 693);

		// 22
		createSpace(TileTypeEnum.BUILDING, 1, 824, 696);

		// 23
		createSpace(TileTypeEnum.ANIMAL, 2, 934, 694);

		// 24
		createSpace(TileTypeEnum.ANIMAL, 6, 177, 46);

		// 25
		createSpace(TileTypeEnum.BUILDING, 4, 284, 47);

		// 26
		createSpace(TileTypeEnum.CASTLE, 2, 122, 139);

		// 27
		createSpace(TileTypeEnum.KNOWLEDGE, 3, 229, 137);

		// 28
		createSpace(TileTypeEnum.CASTLE, 2, 338, 139);

		// 29
		createSpace(TileTypeEnum.MINE, 5, 175, 230);

		// 30
		createSpace(TileTypeEnum.SHIP, 1, 284, 233);

		// 31
		createSpace(TileTypeEnum.BUILDING, 2, 178, 510);

		// 32
		createSpace(TileTypeEnum.SHIP, 4, 286, 510);

		// 33
		createSpace(TileTypeEnum.BUILDING, 5, 124, 601);

		// 34
		createSpace(TileTypeEnum.BUILDING, 4, 233, 602);

		// 35
		createSpace(TileTypeEnum.ANIMAL, 1, 68, 693);

		// 36
		createSpace(TileTypeEnum.KNOWLEDGE, 3, 179, 692);

	}

	private void createSpace(TileTypeEnum tileTypeEnum, int diceValue, double topLeftX, double topLeftY) {

		topLeftX *= Credentials.boardScale;
		topLeftY *= Credentials.boardScale;

		double centerX = topLeftX + Credentials.DimensionsDiceAreaInBoardSpace.x * Credentials.boardScale / 2;
		double centerY = topLeftY + Credentials.DimensionsDiceAreaInBoardSpace.y * Credentials.boardScale / 2;

		this.boardSpaces.addLast(new BoardSpace(tileTypeEnum, diceValue, centerX, centerY));

	}

	private void createAdjacencies() {

		addAdjacents(0, 1);
		addAdjacents(1, 2);
		addAdjacents(2, 3);
		addAdjacents(0, 4);
		addAdjacents(1, 4);
		addAdjacents(1, 5);
		addAdjacents(2, 5);
		addAdjacents(2, 6);
		addAdjacents(3, 6);
		addAdjacents(3, 7);
		addAdjacents(4, 5);
		addAdjacents(5, 6);
		addAdjacents(6, 7);
		addAdjacents(4, 8);
		addAdjacents(5, 8);
		addAdjacents(5, 9);
		addAdjacents(6, 9);
		addAdjacents(6, 10);
		addAdjacents(7, 10);
		addAdjacents(8, 9);
		addAdjacents(9, 10);
		addAdjacents(11, 12);
		addAdjacents(12, 13);
		addAdjacents(13, 14);
		addAdjacents(11, 15);
		addAdjacents(11, 16);
		addAdjacents(12, 16);
		addAdjacents(12, 17);
		addAdjacents(13, 17);
		addAdjacents(13, 18);
		addAdjacents(14, 18);
		addAdjacents(14, 19);
		addAdjacents(15, 16);
		addAdjacents(16, 17);
		addAdjacents(17, 18);
		addAdjacents(18, 19);
		addAdjacents(15, 20);
		addAdjacents(16, 20);
		addAdjacents(16, 21);
		addAdjacents(17, 21);
		addAdjacents(17, 22);
		addAdjacents(18, 22);
		addAdjacents(18, 23);
		addAdjacents(19, 23);
		addAdjacents(20, 21);
		addAdjacents(21, 22);
		addAdjacents(22, 23);
		addAdjacents(24, 25);
		addAdjacents(24, 26);
		addAdjacents(24, 27);
		addAdjacents(25, 27);
		addAdjacents(25, 28);
		addAdjacents(26, 27);
		addAdjacents(27, 28);
		addAdjacents(26, 29);
		addAdjacents(27, 29);
		addAdjacents(27, 30);
		addAdjacents(28, 30);
		addAdjacents(29, 30);
		addAdjacents(31, 32);
		addAdjacents(31, 33);
		addAdjacents(31, 34);
		addAdjacents(32, 34);
		addAdjacents(33, 34);
		addAdjacents(33, 35);
		addAdjacents(33, 36);
		addAdjacents(34, 36);
		addAdjacents(35, 36);
		addAdjacents(0, 30);
		addAdjacents(30, 32);
		addAdjacents(32, 15);
		addAdjacents(15, 9);
		addAdjacents(9, 19);

	}

	private void addAdjacents(int indexA, int indexB) {

		BoardSpace spaceA = this.boardSpaces.get(indexA);
		BoardSpace spaceB = this.boardSpaces.get(indexB);

		spaceA.addAdjacent(spaceB);
		spaceB.addAdjacent(spaceA);

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		double x = this.imageView.getEventX();
		double y = this.imageView.getEventY();

		BoardSpace boardSpacePressed = getSpacePressed(x, y);

		if (boardSpacePressed == null)
			return;

		TileTypeEnum tileTypeEnum = boardSpacePressed.getTileTypeEnum();
		int diceValue = boardSpacePressed.getDiceValue();

		boardSpacePressed.print();

		Executor.runLater(() -> Instances.getControllerInstance().gameStateManager().getCurrentGameState()
				.handleBoardSpacePressed(boardSpacePressed, tileTypeEnum, diceValue));

	}

	private BoardSpace getSpacePressed(double x, double y) {

		for (BoardSpace space : this.boardSpaces)
			if (space.containsCoordinate(x, y))
				return space;

		return null;

	}

	public boolean regionContainingBoardSpaceHasAnIdenticalBuilding(BoardSpace boardSpace,
			BuildingTypeEnum buildingTypeEnum) {

		ArrayList<BoardSpace> region = null;

		for (ArrayList<BoardSpace> regionTemp : this.regions) {

			if (!regionTemp.contains(boardSpace))
				continue;

			region = regionTemp;
			break;

		}

		for (BoardSpace boardSpaceTemp : region) {

			if (!boardSpaceTemp.containsTile())
				continue;

			Tile tile = boardSpaceTemp.getTileContaining();
			Building building = (Building) tile;
			BuildingTypeEnum buildingTypeEnumContaining = building.getBuildingTypeEnum();

			if (buildingTypeEnumContaining == buildingTypeEnum)
				return true;

		}

		return false;

	}

	public void testAddTileToBoardSpace(Tile tile, int boardSpace) {
		this.boardSpaces.get(boardSpace).addTileAndRelocate(tile);
		tile.setVisible(true);
	}

}
