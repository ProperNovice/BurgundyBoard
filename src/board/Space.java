package board;

import enums.Coordinates;
import enums.Credentials;
import enums.Dimensions;
import enums.TileTypeEnum;
import tiles.Ship;
import tiles.Tile;
import utils.ArrayList;
import utils.Logger;

public class Space {

	private TileTypeEnum tileTypeEnum = null;
	private int diceValue;
	private double centerX, centerY;
	private ArrayList<Space> adjacencies = new ArrayList<>();

	public Space(TileTypeEnum tileTypeEnum, int diceValue, double centerX, double centerY) {

		this.tileTypeEnum = tileTypeEnum;
		this.diceValue = diceValue;
		this.centerX = centerX;
		this.centerY = centerY;

	}

	public boolean contains(double x, double y) {

		double topX = centerX - Dimensions.DICE_AREA_IN_SPACE.x() * Credentials.BOARD_SCALE.credential() / 4;
		double topY = centerY - Dimensions.DICE_AREA_IN_SPACE.y() * Credentials.BOARD_SCALE.credential() / 4;

		if (x < topX)
			return false;

		if (x > topX + Dimensions.DICE_AREA_IN_SPACE.x() * Credentials.BOARD_SCALE.credential())
			return false;

		if (y < topY)
			return false;

		if (y > topY + Dimensions.DICE_AREA_IN_SPACE.y() * Credentials.BOARD_SCALE.credential())
			return false;

		return true;

	}

	public void addAdjacent(Space space) {
		this.adjacencies.addLast(space);
	}

	public boolean isAdjacent(Space space) {
		return this.adjacencies.contains(space);
	}

	public void print() {

		Logger.log(this.tileTypeEnum + " - " + this.diceValue);

		Tile tile = null;
		double x, y;

		for (Space space : this.adjacencies) {

			tile = new Ship();
			tile.createImageView();

			x = Coordinates.BOARD.x() + space.getCenterX() - Dimensions.TILE.x() / 2;
			y = Coordinates.BOARD.y() + space.getCenterY() - Dimensions.TILE.y() / 2;

			tile.relocate(x, y);
			tile.setVisible(true);

		}

	}

	public double getCenterX() {
		return this.centerX;
	}

	public double getCenterY() {
		return this.centerY;
	}

}
