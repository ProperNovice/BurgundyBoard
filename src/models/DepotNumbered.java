package models;

import enums.TileTypeEnum;
import tiles.Tile;
import utils.ArrayList;

public class DepotNumbered {

	private int depotNumber;
	private ArrayList<TileTypeEnum> tilesTypeEnum = new ArrayList<>();
	private ArrayList<Tile> tiles = new ArrayList<>();
	private ArrayList<Goods> goods = new ArrayList<>();

	public DepotNumbered(int depotNumber, TileTypeEnum tileTypeEnumFirst, TileTypeEnum tileTypeEnumSecond) {

	}

	public TileTypeEnum getTileTypeEnumFirst() {
		return this.tilesTypeEnum.getFirst();
	}

	public TileTypeEnum getTileTypeEnumSecond() {
		return this.tilesTypeEnum.getLast();
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

}
