package model;

import controller.Credentials;
import enums.TileTypeEnum;
import tiles.Tile;
import utils.ArrayList;
import utils.ImageView;
import utils.Logger;
import utils.SaveLoadAble;

public class BoardSpace implements SaveLoadAble {

	private TileTypeEnum tileTypeEnum = null;
	private Tile tileContaining = null;
	private Tile tileContainingSave = null;
	private int diceValue;
	private double centerX, centerY;
	private ArrayList<BoardSpace> adjacencies = new ArrayList<>();
	private ImageView selectImageView = null;

	public BoardSpace(TileTypeEnum tileTypeEnum, int diceValue, double centerX, double centerY) {

		this.tileTypeEnum = tileTypeEnum;
		this.diceValue = diceValue;
		this.centerX = centerX;
		this.centerY = centerY;

		createSelectImageView();

	}

	private void createSelectImageView() {

		this.selectImageView = new ImageView("select.png");
		this.selectImageView.setVisible(false);
		this.selectImageView.setWidth(Credentials.DimensionsSelectImageViewBoardSpace.x);

		double x = Credentials.CoordinatesBoard.x + this.centerX
				- Credentials.DimensionsDiceAreaInBoardSpace.x * Credentials.boardScale / 2;
		double y = Credentials.CoordinatesBoard.x + this.centerY
				- Credentials.DimensionsDiceAreaInBoardSpace.y * Credentials.boardScale / 2;

		this.selectImageView.relocate(x, y);

	}

	public void setSelected(boolean value) {
		this.selectImageView.setVisible(value);
	}

	public boolean containsCoordinate(double x, double y) {

		double topLeftX = this.centerX - Credentials.DimensionsDiceAreaInBoardSpace.x * Credentials.boardScale / 2;
		double topLeftY = this.centerY - Credentials.DimensionsDiceAreaInBoardSpace.y * Credentials.boardScale / 2;

		if (x < topLeftX)
			return false;

		if (x > topLeftX + Credentials.DimensionsDiceAreaInBoardSpace.x * Credentials.boardScale)
			return false;

		if (y < topLeftY)
			return false;

		if (y > topLeftY + Credentials.DimensionsDiceAreaInBoardSpace.y * Credentials.boardScale)
			return false;

		return true;

	}

	public void addTileAndRelocate(Tile tile) {

		this.tileContaining = tile;

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
		return this.tileContaining != null;
	}

	public boolean adjacentsContainTile() {

		for (BoardSpace boardSpace : this.adjacencies)
			if (boardSpace.containsTile())
				return true;

		return false;

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

	public Tile getTileContaining() {
		return this.tileContaining;
	}

	@Override
	public void saveState() {
		this.tileContainingSave = this.tileContaining;
	}

	@Override
	public void loadState() {
		this.tileContaining = this.tileContainingSave;
	}

}
