package controller;

import enums.TileTypeEnum;
import models.DepotNumbered;
import tiles.Tile;
import utils.ArrayList;
import utils.Coordinates;
import utils.CoordinatesBuilder;
import utils.CoordinatesBuilder.CoordinatesType;

public class DepotNumberedManager {

	private ArrayList<DepotNumbered> depotNumbers = new ArrayList<>();

	public DepotNumberedManager() {
		createDepotNumbers();
	}

	private void createDepotNumbers() {

		double topLeftX = Credentials.CoordinatesDepotNumbers.x;
		double topLeftY = Credentials.CoordinatesDepotNumbers.y;
		double coordinatesX, coordinatesY;
		int index = 0;

		Coordinates coordinates = new CoordinatesBuilder().width(Credentials.DimensionsDeponNumbered.x)
				.height(Credentials.DimensionsDeponNumbered.y)
				.gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x).nodesPerRow(2)
				.create(CoordinatesType.LINEAR);

		// 1

		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers.addLast(new DepotNumbered(1, TileTypeEnum.BUILDING, TileTypeEnum.SHIP,
				topLeftX + coordinatesX, topLeftY + coordinatesY));

		// 2

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers.addLast(new DepotNumbered(2, TileTypeEnum.KNOWLEDGE, TileTypeEnum.CASTLE,
				topLeftX + coordinatesX, topLeftY + coordinatesY));

		// 3

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers.addLast(new DepotNumbered(3, TileTypeEnum.ANIMAL, TileTypeEnum.BUILDING,
				topLeftX + coordinatesX, topLeftY + coordinatesY));

		// 4

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers.addLast(new DepotNumbered(4, TileTypeEnum.SHIP, TileTypeEnum.BUILDING,
				topLeftX + coordinatesX, topLeftY + coordinatesY));

		// 5

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers.addLast(new DepotNumbered(5, TileTypeEnum.MINE, TileTypeEnum.KNOWLEDGE,
				topLeftX + coordinatesX, topLeftY + coordinatesY));

		// 6

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers.addLast(new DepotNumbered(6, TileTypeEnum.BUILDING, TileTypeEnum.ANIMAL,
				topLeftX + coordinatesX, topLeftY + coordinatesY));

	}

	public ArrayList<TileTypeEnum> getDepotNumberedTileTypeEnumList(int depotNumbered) {
		return this.depotNumbers.get(depotNumbered - 1).getTileTypeEnumList();
	}

	public void addTilesToDepotNumbers(int depotNumbered, Tile tileFirst, Tile tileSecond) {
		this.depotNumbers.get(depotNumbered - 1).addTilesAndRelocate(tileFirst, tileSecond);
	}

}
