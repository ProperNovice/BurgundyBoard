package controller;

import enums.TileTypeEnum;
import model.DepotNumbered;
import model.Goods;
import tiles.Tile;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;
import utils.Logger;
import utils.SaveLoadAble;

public class DepotNumberedManager implements SaveLoadAble {

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
				.xPointOfInterest(Credentials.CoordinatesDepotNumbered.x)
				.yPointOfInterest(Credentials.CoordinatesDepotNumbered.y).nodesPerRow(2).createCoordinatesLinear();

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

	public ArrayList<TileTypeEnum> getDepotNumberedTileTypeEnumList(int depotNumberedValue) {

		for (DepotNumbered depotNumbered : this.depotNumbers) {

			if (depotNumbered.getDepotNumber() != depotNumberedValue)
				continue;

			return depotNumbered.getTileTypeEnumList();

		}

		return null;
	}

	public void addTilesToDepotNumbered(int depotNumberedValue, Tile tileFirst, Tile tileSecond) {

		for (DepotNumbered depotNumbered : this.depotNumbers) {

			if (depotNumbered.getDepotNumber() != depotNumberedValue)
				continue;

			depotNumbered.addTilesAndRelocate(tileFirst, tileSecond);
			break;

		}

	}

	public void addGoodsToDepotNumbered(Goods goods, int depotNumberedValue) {

		for (DepotNumbered depotNumbered : this.depotNumbers) {

			if (depotNumbered.getDepotNumber() != depotNumberedValue)
				continue;

			depotNumbered.addGoodsAndRelocate(goods);
			break;

		}

		Logger.log("depot number - " + depotNumberedValue);
		Logger.logNewLine("add goods - " + goods.getDiceValue());

	}

	public boolean containsTile(Tile tile) {

		for (DepotNumbered depotNumbered : this.depotNumbers) {
			if (depotNumbered.containsTile(tile))
				return true;
		}

		return false;

	}

	public boolean containsGoods(Goods goods) {

		for (DepotNumbered depotNumbered : this.depotNumbers) {
			if (depotNumbered.containsGoods(goods))
				return true;
		}

		return false;

	}

	public void removeTileAndRelocate(Tile tile) {

		for (DepotNumbered depotNumbered : this.depotNumbers) {
			if (depotNumbered.containsTile(tile))
				depotNumbered.removeTileAndRelocate(tile);
		}

	}

	public int getDepotNumberedValueContainingTile(Tile tile) {

		int depotNumberedValue = -1;

		for (DepotNumbered depotNumbered : this.depotNumbers) {
			if (depotNumbered.containsTile(tile)) {
				depotNumberedValue = depotNumbered.getDepotNumber();
				break;
			}
		}

		return depotNumberedValue;

	}

	public int getDepotNumberedValueContainingGoods(Goods goods) {

		int depotNumberedValue = -1;

		for (DepotNumbered depotNumbered : this.depotNumbers) {
			if (depotNumbered.containsGoods(goods)) {
				depotNumberedValue = depotNumbered.getDepotNumber();
				break;
			}
		}

		return depotNumberedValue;

	}

	public ArrayList<Goods> removeGoodsFromDepotNumbered(int depotNumberedValue) {

		ArrayList<Goods> goods = null;

		for (DepotNumbered depotNumbered : this.depotNumbers) {

			if (depotNumbered.getDepotNumber() != depotNumberedValue)
				continue;

			goods = depotNumbered.removeAndReturnAllGoods();
			break;

		}

		return goods;

	}

	public void removeFirstGoodFromDepotNumberIfAble(int depotNumberedValue) {

		for (DepotNumbered depotNumbered : this.depotNumbers) {

			if (depotNumbered.getDepotNumber() != depotNumberedValue)
				continue;

			depotNumbered.removeFirstTileIfAbleAndRelocate();
			break;

		}

	}

	public void removeAllGoods() {

		for (DepotNumbered depotNumbered : this.depotNumbers) {
			depotNumbered.removeGoods();
		}

	}

	public void removeTilesFromNumberedDepots() {

		for (DepotNumbered depotNumbered : this.depotNumbers) {
			depotNumbered.removeTiles();
		}

	}

	public boolean hasAtLeastOneGoods() {

		for (DepotNumbered depotNumbered : this.depotNumbers)
			if (depotNumbered.containsAtLeastOneGoods())
				return true;

		return false;

	}

	public boolean containsTileType(TileTypeEnum tileTypeEnum) {

		for (DepotNumbered depotNumbered : this.depotNumbers) {

			if (depotNumbered.containsTileType(tileTypeEnum))
				return true;

		}

		return false;

	}

	@Override
	public void saveState() {

		for (DepotNumbered depotNumbered : this.depotNumbers) {
			depotNumbered.saveState();
		}

	}

	@Override
	public void loadState() {

		for (DepotNumbered depotNumbered : this.depotNumbers) {
			depotNumbered.loadState();
		}

	}

}
