package board;

import enums.Credentiaals;
import enums.TileTypeEnum;
import utils.ArrayList;
import utils.Credentials;
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

		double topX = centerX - Credentials.DimensionsDiceAreaInSpace.x * Credentiaals.BOARD_SCALE.credential() / 4;
		double topY = centerY - Credentials.DimensionsDiceAreaInSpace.y * Credentiaals.BOARD_SCALE.credential() / 4;

		if (x < topX)
			return false;

		if (x > topX + Credentials.DimensionsDiceAreaInSpace.x * Credentiaals.BOARD_SCALE.credential())
			return false;

		if (y < topY)
			return false;

		if (y > topY + Credentials.DimensionsDiceAreaInSpace.y * Credentiaals.BOARD_SCALE.credential())
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
	}

	public double getCenterX() {
		return this.centerX;
	}

	public double getCenterY() {
		return this.centerY;
	}

}
