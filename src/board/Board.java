package board;

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

	}

	private void createBoard() {

		this.imageView = new ImageView("boards/aTrans.png", this);
		this.imageView.relocate(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y());

	}

	private void createSpaces() {

		// 0

		this.spaces.addLast(
				new SpaceBuilder().tileTypeEnum(TileTypeEnum.SHIP).diceValue(6).topLeftX(665).topLeftY(71).create());

		// 1

		this.spaces.addLast(
				new SpaceBuilder().tileTypeEnum(TileTypeEnum.MINE).diceValue(5).topLeftX(772).topLeftY(70).create());

		// 2

		this.spaces.addLast(new SpaceBuilder().tileTypeEnum(TileTypeEnum.BUILDING).diceValue(6).topLeftX(880)
				.topLeftY(72).create());

		// 3

		this.spaces.addLast(new SpaceBuilder().tileTypeEnum(TileTypeEnum.BUILDING).diceValue(2).topLeftX(987)
				.topLeftY(72).create());

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

		Space spacePressed = null;

		for (Space space : this.spaces)
			if (space.contains(x, y))
				spacePressed = space;

		return spacePressed;

	}

}
