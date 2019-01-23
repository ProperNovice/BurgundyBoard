package models;

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

	public DepotNumbered(int depotNumber, TileTypeEnum tileTypeEnumFirst, TileTypeEnum tileTypeEnumSecond) {

		this.depotNumber = depotNumber;
		this.tilesTypeEnum.addLast(tileTypeEnumFirst);
		this.tilesTypeEnum.addLast(tileTypeEnumSecond);

		createDepotNumberIndicator();

	}

	private void createDepotNumberIndicator() {

		String path = "dice/gray";
		path += this.depotNumber;
		path += ".png";

		this.depotNumberIndicator = new ImageView(path);

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
