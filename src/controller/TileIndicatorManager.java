package controller;

import enums.BuildingTypeEnum;
import model.TileIndicator;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;

public class TileIndicatorManager {

	private ArrayList<TileIndicator> list = new ArrayList<>();

	public TileIndicatorManager() {

		createTileIndicators();
		relocateTileIndicators();

	}

	private void createTileIndicators() {

		for (BuildingTypeEnum buildingTypeEnum : BuildingTypeEnum.values()) {
			this.list.addLast(new TileIndicator(buildingTypeEnum.getText()));
		}

		this.list.addLast(new TileIndicator("animal"));
		this.list.addLast(new TileIndicator("castle"));
		this.list.addLast(new TileIndicator("knowledge"));
		this.list.addLast(new TileIndicator("mine"));
		this.list.addLast(new TileIndicator("ship"));

	}

	private void relocateTileIndicators() {

		CoordinatesLinear coordinatesLinear = new CoordinatesBuilder().width(Credentials.DimensionsTileIndicators.x)
				.height(Credentials.DimensionsTileIndicators.y).gapBetweenNodes(1)
				.xPointOfInterest(Credentials.CoordinatesTileIndicators.x)
				.yPointOfInterest(Credentials.CoordinatesTileIndicators.y).nodesPerRow(60).createCoordinatesLinear();

		for (TileIndicator tileIndicator : this.list) {
			tileIndicator.relocate(coordinatesLinear.getX(this.list.indexOf(tileIndicator)),
					coordinatesLinear.getY(this.list.indexOf(tileIndicator)));

		}

	}

}
