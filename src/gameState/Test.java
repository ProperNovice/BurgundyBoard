package gameState;

import controller.Credentials;
import enums.AnimalTypeEnum;
import tiles.Animal;
import tiles.ShipBlack;
import tiles.Tile;
import utils.ArrayList;
import utils.Coordinates;
import utils.CoordinatesBuilder;
import utils.Lock;

public class Test {

	private ArrayList<Tile> tiles = new ArrayList<>();
	private Coordinates coordinatesRelocateA = null, coordinatesRelocateB = null;;

	public Test() {

		for (int counter = 1; counter <= 18; counter++) {

			Tile tile = new Animal(AnimalTypeEnum.COW, 2);
			this.tiles.addLast(tile);
			tile.relocate(900, 50);
			tile.setVisible(true);

		}

		this.coordinatesRelocateA = new CoordinatesBuilder().gapBetweenNodes(1).height(Credentials.DimensionsTile.y)
				.width(Credentials.DimensionsTile.x).nodesPerRow(3).create();

		this.coordinatesRelocateB = new CoordinatesBuilder().gapBetweenNodes(5).height(Credentials.DimensionsTile.y)
				.width(Credentials.DimensionsTile.x).nodesPerRow(4).create();

		this.coordinatesRelocateA.resetCoordinates();
		this.coordinatesRelocateB.resetCoordinates();

		for (Tile tile : this.tiles) {

			this.coordinatesRelocateA.setUpNextCoordinates();

			double x = 1000 + this.coordinatesRelocateA.getX();
			double y = 20 + this.coordinatesRelocateA.getY();

			tile.animateSynchronous(x, y);

		}

		Lock.lock();

		for (int counter = 1; counter <= 4; counter++) {

			Tile tile = new ShipBlack();
			this.tiles.addLast(tile);
			tile.relocate(900, 50);
			tile.setVisible(true);

		}

		for (Tile tile : this.tiles) {

			this.coordinatesRelocateB.setUpNextCoordinates();

			double x = 1100 + this.coordinatesRelocateB.getX();
			double y = 50 + this.coordinatesRelocateB.getY();

			tile.animateSynchronous(x, y);

		}

		Lock.lock();

		System.out.println("yo");

	}

}
