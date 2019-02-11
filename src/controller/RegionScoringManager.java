package controller;

import model.RegionScoringIndicator;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;
import utils.ShutDown;

public class RegionScoringManager {

	private ArrayList<RegionScoringIndicator> list = new ArrayList<>();

	public RegionScoringManager() {
		createAndRelocateRegionScoringList();
	}

	private void createAndRelocateRegionScoringList() {

		this.list.addLast(new RegionScoringIndicator(1, 1));
		this.list.addLast(new RegionScoringIndicator(2, 3));
		this.list.addLast(new RegionScoringIndicator(3, 6));

		CoordinatesLinear coordinatesLinear = new CoordinatesBuilder()
				.width(Credentials.DimensionsRegionScoringIndicator.x)
				.height(Credentials.DimensionsRegionScoringIndicator.y).gapBetweenNodes(1)
				.xPointOfInterest(Credentials.CoordinatesRegionScoringIndicators.x)
				.yPointOfInterest(Credentials.CoordinatesRegionScoringIndicators.y).nodesPerRow(10)
				.createCoordinatesLinear();

		for (RegionScoringIndicator regionScoringIndicator : this.list) {
			regionScoringIndicator.relocate(coordinatesLinear.getX(this.list.indexOf(regionScoringIndicator)),
					coordinatesLinear.getY(this.list.indexOf(regionScoringIndicator)));
		}

	}

	public int getRegionTotalPoints(int totalSpaces) {

		for (RegionScoringIndicator regionScoringIndicator : this.list) {

			if (regionScoringIndicator.getTotalSpaces() == totalSpaces)
				return regionScoringIndicator.getPoints();

		}

		ShutDown.execute("no total spaces found @ RegionScoringManager - getRegionTotalPoints(int totalSpaces)");
		return -1;

	}

}
