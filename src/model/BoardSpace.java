package model;

import controller.Credentials;
import enums.TileTypeEnum;
import tiles.Tile;
import utils.ArrayList;
import utils.Logger;

public class BoardSpace {

	private TileTypeEnum tileTypeEnum = null;
	private Tile tileContaining = null;
	private int diceValue;
	private double centerX, centerY;
	private ArrayList<BoardSpace> adjacencies = new ArrayList<>();

	public BoardSpace(TileTypeEnum tileTypeEnum, int diceValue, double centerX, double centerY) {

		this.tileTypeEnum = tileTypeEnum;
		this.diceValue = diceValue;
		this.centerX = centerX;
		this.centerY = centerY;

	}

	public boolean containsCoordinate(double x, double y) {

		double topLeftX = centerX - Credentials.DimensionsDiceAreaInSpace.x * Credentials.boardScale / 2;
		double topLeftY = centerY - Credentials.DimensionsDiceAreaInSpace.y * Credentials.boardScale / 2;

		if (x < topLeftX)
			return false;

		if (x > topLeftX + Credentials.DimensionsDiceAreaInSpace.x * Credentials.boardScale)
			return false;

		if (y < topLeftY)
			return false;

		if (y > topLeftY + Credentials.DimensionsDiceAreaInSpace.y * Credentials.boardScale)
			return false;

		return true;

	}

	public void addTileAndRelocate(Tile tile) {

		double topLeftX = Credentials.CoordinatesBoard.x + this.centerX - Credentials.DimensionsTile.x / 2;
		double topLeftY = Credentials.CoordinatesBoard.y + this.centerY - Credentials.DimensionsTile.y / 2;

		tile.relocate(topLeftX, topLeftY);

	}

	public TileTypeEnum getTileTypeEnum() {
		return this.tileTypeEnum;
	}

	public int getDiceValue() {
		return this.diceValue;
	}

	public boolean containsTile() {
		return this.tileContaining == null;
	}

	public void addAdjacent(BoardSpace space) {
		this.adjacencies.addLast(space);
	}

	public boolean isAdjacent(BoardSpace space) {
		return this.adjacencies.contains(space);
	}

	public void print() {
		Logger.logNewLine(this.tileTypeEnum + " - " + this.diceValue);
	}

	public double getCenterX() {
		return this.centerX;
	}

	public double getCenterY() {
		return this.centerY;
	}

}
