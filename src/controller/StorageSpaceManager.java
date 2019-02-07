package controller;

import tiles.Tile;
import utils.ArrayList;

public class StorageSpaceManager {

	private ArrayList<Tile> tiles = new ArrayList<>(3);

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
		return this.tiles.size() > this.tiles.getMaxCapacity();
	}

	public boolean containsPriorTile(Tile tile) {

		if (this.tiles.isEmpty())
			return false;

		for (int counter = 0; counter < this.tiles.getMaxCapacity(); counter++)
			if (this.tiles.get(counter) == tile)
				return true;

		return false;

	}

	public void removeTileAndRelocate(Tile tile) {
		this.tiles.remove(tile);
		relocateTiles();
	}

}
