package controller;

import tiles.Tile;
import utils.ArrayList;
import utils.SaveLoadAble;

public class StorageSpaceManager implements SaveLoadAble {

	private ArrayList<Tile> tiles = new ArrayList<>();
	private ArrayList<Tile> tilesSave = new ArrayList<>();
	private final int tileCapacity = 3;

	public StorageSpaceManager() {

	}

	public void addTileAndRelocate(Tile tile) {

		this.tiles.addLast(tile);
		relocateTiles();

	}

	private void relocateTiles() {

		for (Tile tile : this.tiles) {

			int index = this.tiles.indexOf(tile);
			double x = 0, y = 0;

			switch (index) {

			case 0:
				x = Credentials.CoordinatesStorageSpaceFirst.x - Credentials.DimensionsTile.x / 2;
				y = Credentials.CoordinatesStorageSpaceFirst.y - Credentials.DimensionsTile.y / 2;
				break;

			case 1:
				x = Credentials.CoordinatesStorageSpaceSecond.x - Credentials.DimensionsTile.x / 2;
				y = Credentials.CoordinatesStorageSpaceSecond.y - Credentials.DimensionsTile.y / 2;
				break;

			case 2:
				x = Credentials.CoordinatesStorageSpaceThird.x - Credentials.DimensionsTile.x / 2;
				y = Credentials.CoordinatesStorageSpaceThird.y - Credentials.DimensionsTile.y / 2;
				break;

			case 3:
				x = Credentials.CoordinatesStorageSpaceTemp.x;
				y = Credentials.CoordinatesStorageSpaceTemp.y - Credentials.DimensionsTile.y / 2;
				break;

			}

			tile.relocate(x, y);

		}

	}

	public boolean isEmpty() {
		return this.tiles.isEmpty();
	}

	public boolean exceedsMaxedCapacity() {
		return this.tiles.size() > this.tileCapacity;
	}

	public boolean containsPriorTile(Tile tile) {

		if (this.tiles.isEmpty())
			return false;

		int targetCounter = (Integer) Math.min(this.tiles.size(), this.tileCapacity);

		for (int counter = 0; counter < targetCounter; counter++)
			if (this.tiles.get(counter) == tile)
				return true;

		return false;

	}

	public void removeTileAndRelocate(Tile tile) {
		this.tiles.remove(tile);
		relocateTiles();
	}

	public boolean containsExactlyOneTile() {
		return this.tiles.size() == 1;
	}

	public Tile getFirstTile() {
		return this.tiles.getFirst();
	}

	public int getNumberOfTiles() {
		return (int) Math.min(this.tiles.size(), this.tileCapacity);
	}

	@Override
	public void saveState() {

		this.tilesSave.clear();
		this.tilesSave.addAll(this.tiles);

	}

	@Override
	public void loadState() {

		for (Tile tile : this.tiles) {

//			tile.setVisible(false);
			tile.setSelected(false);

		}

		this.tiles.clear();

		this.tiles = this.tilesSave.clone();

		for (Tile tile : this.tiles) {

			tile.setVisible(true);
			tile.setSelected(false);

		}

		relocateTiles();

	}

}
