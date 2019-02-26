package model;

import controller.Credentials;
import enums.TileTypeEnum;
import tiles.Tile;
import utils.ArrayList;
import utils.ImageView;
import utils.SaveLoadAble;

public class DepotNumbered implements SaveLoadAble {

	private int depotNumber;
	private ArrayList<TileTypeEnum> tilesTypeEnum = new ArrayList<>();
	private ArrayList<Tile> tiles = new ArrayList<>();
	private ArrayList<Tile> tilesSave = new ArrayList<>();
	private ArrayList<Goods> goods = new ArrayList<>();
	private ArrayList<Goods> goodsSave = new ArrayList<>();
	private ImageView depotNumberIndicator = null;
	private double xCoordinates, yCoordinates;

	public DepotNumbered(int depotNumber, TileTypeEnum tileTypeEnumFirst, TileTypeEnum tileTypeEnumSecond,
			double xCoordinates, double yCoordinates) {

		this.depotNumber = depotNumber;
		this.tilesTypeEnum.addLast(tileTypeEnumFirst);
		this.tilesTypeEnum.addLast(tileTypeEnumSecond);
		this.xCoordinates = xCoordinates;
		this.yCoordinates = yCoordinates;

		createDepotNumberIndicator();
		relocateDepotNumbered();

	}

	private void createDepotNumberIndicator() {

		String path = "dice/gray/";
		path += this.depotNumber;
		path += ".png";

		this.depotNumberIndicator = new ImageView(path);

	}

	public ArrayList<TileTypeEnum> getTileTypeEnumList() {
		return this.tilesTypeEnum;
	}

	public boolean containsTile(Tile tile) {
		return this.tiles.contains(tile);
	}

	public void removeTileAndRelocate(Tile tile) {
		this.tiles.remove(tile);
		relocateTiles();
	}

	public boolean containsGoods(Goods goods) {
		return this.goods.contains(goods);
	}

	public int getDepotNumber() {
		return this.depotNumber;
	}

	public void relocateDepotNumbered() {

		double y = this.yCoordinates + (Credentials.DimensionsTile.y - Credentials.DimensionsDice.y) / 2;
		this.depotNumberIndicator.relocate(this.xCoordinates, y);

	}

	public void addTilesAndRelocate(Tile tileFirst, Tile tileSecond) {

		this.tiles.addLast(tileFirst);
		this.tiles.addLast(tileSecond);

		relocateTiles();

	}

	public void relocateTiles() {

		double x = this.xCoordinates + Credentials.DimensionsDice.x + Credentials.DimensionsGapBetweenComponents.x;

		for (Tile tile : this.tiles) {

			tile.relocate(x, this.yCoordinates);
			x += Credentials.DimensionsTile.x + Credentials.DimensionsGapBetweenComponents.x;

		}

	}

	public void addGoodsAndRelocate(Goods goods) {

		this.goods.addLast(goods);
		relocateGoods();

	}

	private void relocateGoods() {

		double x = this.xCoordinates;
		x += Credentials.DimensionsDice.x;
		x += 2 * Credentials.DimensionsTile.x;
		x += 3 * Credentials.DimensionsGapBetweenComponents.x;

		double y = this.yCoordinates + (Credentials.DimensionsTile.y - Credentials.DimensionsGoods.y) / 2;
		double gapBetweenGoods = 0.15 * Credentials.DimensionsGoods.x;

		for (Goods goodsTemp : this.goods) {

			goodsTemp.relocate(x, y);
			goodsTemp.toFront();
			x += gapBetweenGoods;

		}

	}

	public ArrayList<Goods> removeAndReturnAllGoods() {

		ArrayList<Goods> goodsListToReturn = this.goods.clone();
		this.goods.clear();
		return goodsListToReturn;

	}

	public void removeGoods() {

		for (Goods goods : this.goods) {
			goods.setVisible(false);
		}

		this.goods.clear();

	}

	public void removeFirstTileIfAbleAndRelocate() {

		if (this.tiles.isEmpty())
			return;

		this.tiles.removeFirst().setVisible(false);
		relocateTiles();

	}

	public void removeTiles() {

		for (Tile tile : this.tiles.clone()) {

			this.tiles.remove(tile);
			tile.setVisible(false);

		}

	}

	public boolean containsAtLeastOneGoods() {
		return this.goods.size() > 0;
	}

	public boolean containsTileType(TileTypeEnum tileTypeEnum) {

		for (Tile tile : this.tiles) {

			if (tile.getTileTypeEnum() == tileTypeEnum)
				return true;

		}

		return false;

	}

	@Override
	public void saveState() {

		this.tilesSave = this.tiles.clone();
		this.goodsSave = this.goods.clone();

	}

	@Override
	public void loadState() {

		this.tiles = this.tilesSave.clone();

		for (Tile tile : this.tiles) {

			tile.setVisible(true);
			tile.setSelected(false);

		}

		relocateTiles();

		this.goods = this.goodsSave.clone();

		for (Goods goods : this.goods) {
			goods.setVisible(true);
		}

		relocateGoods();

	}

}
