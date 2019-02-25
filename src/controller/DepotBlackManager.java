package controller;

import tiles.Tile;
import utils.ArrayList;
import utils.Coordinates;
import utils.CoordinatesBuilder;
import utils.SaveLoadAble;

public class DepotBlackManager implements SaveLoadAble {

	private ArrayList<Tile> tiles = new ArrayList<>();
	private ArrayList<Tile> tilesSave = new ArrayList<>();
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
		relocateTiles();

	}

	private void relocateTiles() {

		for (Tile tile : this.tiles) {
			tile.relocate(this.coordinates.getX(this.tiles.indexOf(tile)),
					this.coordinates.getY(this.tiles.indexOf(tile)));
		}

	}

	public void removeTile(Tile tile) {
		this.tiles.remove(tile);
	}

	public void removeTiles() {

		for (Tile tile : this.tiles.clone()) {

			this.tiles.remove(tile);
			tile.setVisible(false);

		}

	}

	@Override
	public void saveState() {
		this.tilesSave = this.tiles.clone();
	}

	@Override
	public void loadState() {

		this.tiles = this.tilesSave.clone();

		for (Tile tile : this.tiles) {

			tile.setVisible(true);
			tile.setSelected(false);

		}

		relocateTiles();

	}

}
