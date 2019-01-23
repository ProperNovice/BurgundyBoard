package controller;

import enums.TileTypeEnum;
import models.DepotNumbered;
import tiles.Tile;
import utils.ArrayList;

public class DepotNumberedManager {

	private ArrayList<DepotNumbered> depotNumbers = new ArrayList<>();

	public DepotNumberedManager() {
		createDepotNumbers();
	}

	private void createDepotNumbers() {

		double x = Credentials.CoordinatesDepotNumbers.x;
		double y = Credentials.CoordinatesDepotNumbers.y;

		// 1
		this.depotNumbers.addLast(new DepotNumbered(1, TileTypeEnum.BUILDING, TileTypeEnum.SHIP, x, y));

		// 2
		y += Credentials.DimensionsTile.y + Credentials.DimensionsGapBetweenComponents.y;
		this.depotNumbers.addLast(new DepotNumbered(2, TileTypeEnum.KNOWLEDGE, TileTypeEnum.CASTLE, x, y));

		// 3
		y += Credentials.DimensionsTile.y + Credentials.DimensionsGapBetweenComponents.y;
		this.depotNumbers.addLast(new DepotNumbered(3, TileTypeEnum.ANIMAL, TileTypeEnum.BUILDING, x, y));

		// 4
		y += Credentials.DimensionsTile.y + Credentials.DimensionsGapBetweenComponents.y;
		this.depotNumbers.addLast(new DepotNumbered(4, TileTypeEnum.SHIP, TileTypeEnum.BUILDING, x, y));

		// 5
		y += Credentials.DimensionsTile.y + Credentials.DimensionsGapBetweenComponents.y;
		this.depotNumbers.addLast(new DepotNumbered(5, TileTypeEnum.MINE, TileTypeEnum.KNOWLEDGE, x, y));

		// 6
		y += Credentials.DimensionsTile.y + Credentials.DimensionsGapBetweenComponents.y;
		this.depotNumbers.addLast(new DepotNumbered(6, TileTypeEnum.BUILDING, TileTypeEnum.ANIMAL, x, y));

	}

	public ArrayList<TileTypeEnum> getDepotNumberedTileTypeEnumList(int depotNumbered) {
		return this.depotNumbers.get(depotNumbered - 1).getTileTypeEnumList();
	}

	public void addTilesToDepotNumbers(int depotNumbered, Tile tileFirst, Tile tileSecond) {
		this.depotNumbers.get(depotNumbered - 1).addTilesAndRelocate(tileFirst, tileSecond);
	}

}
