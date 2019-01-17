package board;

import enums.Credentials;
import enums.Dimensions;
import enums.TileTypeEnum;
import utils.ArrayList;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public class Board implements EventHandlerAble {

	private ImageView imageView = null;
	private ArrayList<Space> spaces = new ArrayList<>();

	public Board() {

		createBoard();
		createSpaces();
		createAdjacencies();

	}

	private void createBoard() {

		this.imageView = new ImageView("boards/aTrans.png", this);
		this.imageView.setScale(Credentials.BOARD_SCALE.credential());
		this.imageView.relocate(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y());

	}

	private void createSpaces() {

		// 0
		createSpace(TileTypeEnum.SHIP, 6, 665, 71);

		// 1
		createSpace(TileTypeEnum.MINE, 5, 772, 70);

		// 2
		createSpace(TileTypeEnum.BUILDING, 6, 880, 72);

		// 3
		createSpace(TileTypeEnum.BUILDING, 2, 987, 72);

		// 4
		createSpace(TileTypeEnum.BUILDING, 4, 716, 163);

		// 5
		createSpace(TileTypeEnum.ANIMAL, 2, 829, 162);

		// 6
		createSpace(TileTypeEnum.CASTLE, 4, 934, 165);

		// 7
		createSpace(TileTypeEnum.KNOWLEDGE, 3, 1041, 161);

		// 8
		createSpace(TileTypeEnum.BUILDING, 6, 770, 255);

		// 9
		createSpace(TileTypeEnum.SHIP, 3, 881, 257);

		// 10
		createSpace(TileTypeEnum.BUILDING, 1, 986, 256);

		// 11
		createSpace(TileTypeEnum.KNOWLEDGE, 5, 610, 509);

		// 12
		createSpace(TileTypeEnum.KNOWLEDGE, 3, 719, 507);

		// 13
		createSpace(TileTypeEnum.KNOWLEDGE, 5, 827, 508);

		// 14
		createSpace(TileTypeEnum.ANIMAL, 1, 937, 508);

		// 15
		createSpace(TileTypeEnum.SHIP, 1, 558, 604);

		// 16
		createSpace(TileTypeEnum.BUILDING, 2, 665, 602);

		// 17
		createSpace(TileTypeEnum.CASTLE, 4, 774, 602);

		// 18
		createSpace(TileTypeEnum.ANIMAL, 6, 884, 601);

		// 19
		createSpace(TileTypeEnum.SHIP, 1, 989, 603);

		// 20
		createSpace(TileTypeEnum.BUILDING, 6, 610, 697);

		// 21
		createSpace(TileTypeEnum.MINE, 5, 718, 693);

		// 22
		createSpace(TileTypeEnum.BUILDING, 1, 827, 696);

		// 23
		createSpace(TileTypeEnum.ANIMAL, 2, 937, 694);

		// 24
		createSpace(TileTypeEnum.ANIMAL, 6, 180, 46);

		// 25
		createSpace(TileTypeEnum.BUILDING, 4, 286, 47);

		// 26
		createSpace(TileTypeEnum.CASTLE, 2, 124, 139);

		// 27
		createSpace(TileTypeEnum.KNOWLEDGE, 3, 231, 137);

		// 28
		createSpace(TileTypeEnum.CASTLE, 2, 340, 139);

		// 29
		createSpace(TileTypeEnum.MINE, 5, 177, 230);

		// 30
		createSpace(TileTypeEnum.SHIP, 1, 287, 233);

		// 31
		createSpace(TileTypeEnum.BUILDING, 2, 180, 510);

		// 32
		createSpace(TileTypeEnum.SHIP, 4, 290, 510);

		// 33
		createSpace(TileTypeEnum.BUILDING, 5, 126, 601);

		// 34
		createSpace(TileTypeEnum.BUILDING, 4, 234, 602);

		// 35
		createSpace(TileTypeEnum.ANIMAL, 1, 74, 693);

		// 36
		createSpace(TileTypeEnum.KNOWLEDGE, 3, 179, 692);

	}

	private void createSpace(TileTypeEnum tileTypeEnum, int diceValue, double topLeftX, double topLeftY) {

		topLeftX *= Credentials.BOARD_SCALE.credential();
		topLeftY *= Credentials.BOARD_SCALE.credential();
		double centerX = topLeftX + Dimensions.DICE_AREA_IN_SPACE.x() * Credentials.BOARD_SCALE.credential() / 2;
		double centerY = topLeftY + Dimensions.DICE_AREA_IN_SPACE.y() * Credentials.BOARD_SCALE.credential() / 2;

		this.spaces.addLast(new Space(tileTypeEnum, diceValue, centerX, centerY));

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

		Space spaceA = this.spaces.get(indexA);
		Space spaceB = this.spaces.get(indexB);

		spaceA.addAdjacent(spaceB);
		spaceB.addAdjacent(spaceA);

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		double x = this.imageView.getEventX();
		double y = this.imageView.getEventY();

		Space spacePressed = getSpacePressed(x, y);

		if (spacePressed == null)
			return;

		spacePressed.print();

	}

	private Space getSpacePressed(double x, double y) {

		for (Space space : this.spaces)
			if (space.contains(x, y))
				return space;

		return null;

	}

}
