package models;

import controller.Credentials;
import enums.TileTypeEnum;
import utils.ArrayList;
import utils.Logger;

public class BoardSpace {

	private TileTypeEnum tileTypeEnum = null;
	private int diceValue;
	private double centerX, centerY;
	private ArrayList<BoardSpace> adjacencies = new ArrayList<>();

	public BoardSpace(TileTypeEnum tileTypeEnum, int diceValue, double centerX, double centerY) {

		this.tileTypeEnum = tileTypeEnum;
		this.diceValue = diceValue;
		this.centerX = centerX;
		this.centerY = centerY;

	}

	public boolean contains(double x, double y) {

		double topX = centerX - Credentials.DimensionsDiceAreaInSpace.x * Credentials.boardScale / 4;
		double topY = centerY - Credentials.DimensionsDiceAreaInSpace.y * Credentials.boardScale / 4;

		if (x < topX)
			return false;

		if (x > topX + Credentials.DimensionsDiceAreaInSpace.x * Credentials.boardScale)
			return false;

		if (y < topY)
			return false;

		if (y > topY + Credentials.DimensionsDiceAreaInSpace.y * Credentials.boardScale)
			return false;

		return true;

	}

	public void addAdjacent(BoardSpace space) {
		this.adjacencies.addLast(space);
	}

	public boolean isAdjacent(BoardSpace space) {
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
