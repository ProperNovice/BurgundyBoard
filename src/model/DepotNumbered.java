package model;

import controller.Credentials;
import enums.TileTypeEnum;
import tiles.Tile;
import utils.ArrayList;
import utils.ImageView;

public class DepotNumbered {

	private int depotNumber;
	private ArrayList<TileTypeEnum> tilesTypeEnum = new ArrayList<>();
	private ArrayList<Tile> tiles = new ArrayList<>();
	private ArrayList<Goods> goods = new ArrayList<>();
	private ImageView depotNumberIndicator = null;
	private double x, y;

	public DepotNumbered(int depotNumber, TileTypeEnum tileTypeEnumFirst, TileTypeEnum tileTypeEnumSecond, double x,
			double y) {

		this.depotNumber = depotNumber;
		this.tilesTypeEnum.addLast(tileTypeEnumFirst);
		this.tilesTypeEnum.addLast(tileTypeEnumSecond);
		this.x = x;
		this.y = y;

		createDepotNumberIndicator();
		relocateDepotNumbered();

	}

	private void createDepotNumberIndicator() {

		String path = "dice/gray";
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

	public boolean containsGoods(Goods goods) {
		return this.goods.contains(goods);
	}

	public int getDepotNumber() {
		return this.depotNumber;
	}

	public void relocateDepotNumbered() {

		double y = this.y + (Credentials.DimensionsTile.y - Credentials.DimensionsDice.y) / 2;
		this.depotNumberIndicator.relocate(this.x, y);

	}

	public void addTilesAndRelocate(Tile tileFirst, Tile tileSecond) {

		this.tiles.addLast(tileFirst);
		this.tiles.addLast(tileSecond);

		double x = this.x + Credentials.DimensionsDice.x + Credentials.DimensionsGapBetweenComponents.x;

		for (Tile tile : this.tiles) {

			tile.relocate(x, this.y);
			x += Credentials.DimensionsTile.x + Credentials.DimensionsGapBetweenComponents.x;

		}

	}

}
