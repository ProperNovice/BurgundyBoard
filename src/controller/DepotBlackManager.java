package controller;

import tiles.Tile;
import utils.ArrayList;
import utils.Coordinates;
import utils.CoordinatesBuilder;

public class DepotBlackManager {

	private ArrayList<Tile> tiles = new ArrayList<>();
	private Coordinates coordinates = null;

	public DepotBlackManager() {
		createCoordinates();
	}

	private void createCoordinates() {

		this.coordinates = new CoordinatesBuilder().width(Credentials.DimensionsTile.x)
				.height(Credentials.DimensionsTile.y).gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x)
				.xPointOfInterest(Credentials.CoordinatesDepotBlack.x)
				.yPointOfInterest(Credentials.CoordinatesDepotBlack.y).nodesPerRow(4).createCoordinatesLinear();

	}

	public boolean containsTile(Tile tile) {
		return this.tiles.contains(tile);
	}

	public void addTilesAndRelocate(ArrayList<Tile> tilesBlack) {

		this.tiles.addAll(tilesBlack);

		for (Tile tile : this.tiles) {
			tile.relocate(this.coordinates.getX(this.tiles.indexOf(tile)),
					this.coordinates.getY(this.tiles.indexOf(tile)));
		}

	}

	public void removeTile(Tile tile) {
		this.tiles.remove(tile);
	}

}
