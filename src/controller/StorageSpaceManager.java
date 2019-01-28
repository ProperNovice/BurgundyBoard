package controller;

import tiles.Tile;
import utils.ArrayList;

public class StorageSpaceManager {

	private ArrayList<Tile> tiles = new ArrayList<>();

	public StorageSpaceManager() {

	}

	public void addTileAndRelocate(Tile tile) {
		this.tiles.addLast(tile);
		relocateTiles();
	}

	private void relocateTiles() {

		for (Tile tile : this.tiles) {

			int index = this.tiles.indexOf(tile);
			double x, y;

			switch (index) {

			case 0:
				x = Credentials.CoordinatesStorageSpaceFirst.x - Credentials.DimensionsTile.x / 2;
				y = Credentials.CoordinatesStorageSpaceFirst.y - Credentials.DimensionsTile.y / 2;
				tile.relocate(x, y);
				break;

			case 1:
				x = Credentials.CoordinatesStorageSpaceSecond.x - Credentials.DimensionsTile.x / 2;
				y = Credentials.CoordinatesStorageSpaceSecond.y - Credentials.DimensionsTile.y / 2;
				tile.relocate(x, y);
				break;

			case 2:
				x = Credentials.CoordinatesStorageSpaceThird.x - Credentials.DimensionsTile.x / 2;
				y = Credentials.CoordinatesStorageSpaceThird.y - Credentials.DimensionsTile.y / 2;
				tile.relocate(x, y);
				break;

			}

		}

	}

}
