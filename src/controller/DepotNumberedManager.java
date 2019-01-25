package controller;

import enums.TileTypeEnum;
import model.DepotNumbered;
import tiles.Tile;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;

public class DepotNumberedManager {

	private ArrayList<DepotNumbered> depotNumbers = new ArrayList<>();

	public DepotNumberedManager() {
		createDepotNumbers();
	}

	private void createDepotNumbers() {

		double coordinatesX, coordinatesY;
		int index = 0;

		CoordinatesLinear coordinates = new CoordinatesBuilder().width(Credentials.DimensionsDepotNumbered.x)
				.height(Credentials.DimensionsDepotNumbered.y)
				.gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x)
				.xPointOfInterest(Credentials.CoordinatesDepotNumbers.x)
				.yPointOfInterest(Credentials.CoordinatesDepotNumbers.y).nodesPerRow(2).createCoordinatesLinear();

		// 1

		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers
				.addLast(new DepotNumbered(1, TileTypeEnum.BUILDING, TileTypeEnum.SHIP, coordinatesX, coordinatesY));

		// 2

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers
				.addLast(new DepotNumbered(2, TileTypeEnum.KNOWLEDGE, TileTypeEnum.CASTLE, coordinatesX, coordinatesY));

		// 3

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers
				.addLast(new DepotNumbered(3, TileTypeEnum.ANIMAL, TileTypeEnum.BUILDING, coordinatesX, coordinatesY));

		// 4

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers
				.addLast(new DepotNumbered(4, TileTypeEnum.SHIP, TileTypeEnum.BUILDING, coordinatesX, coordinatesY));

		// 5

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers
				.addLast(new DepotNumbered(5, TileTypeEnum.MINE, TileTypeEnum.KNOWLEDGE, coordinatesX, coordinatesY));

		// 6

		index++;
		coordinatesX = coordinates.getX(index);
		coordinatesY = coordinates.getY(index);

		this.depotNumbers
				.addLast(new DepotNumbered(6, TileTypeEnum.BUILDING, TileTypeEnum.ANIMAL, coordinatesX, coordinatesY));

	}

	public ArrayList<TileTypeEnum> getDepotNumberedTileTypeEnumList(int depotNumbered) {
		return this.depotNumbers.get(depotNumbered - 1).getTileTypeEnumList();
	}

	public void addTilesToDepotNumbers(int depotNumbered, Tile tileFirst, Tile tileSecond) {
		this.depotNumbers.get(depotNumbered - 1).addTilesAndRelocate(tileFirst, tileSecond);
	}

}