package controller;

import model.Silverling;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesPivot;

public class SilverlingManager {

	private ArrayList<Silverling> silverlings = new ArrayList<>();
	private CoordinatesPivot coordinatesPivot = null;

	public SilverlingManager() {
		createCoordinatesPivot();
		addSilverlingsAndRelocate(1);
	}

	private void createCoordinatesPivot() {

		double x = Credentials.CoordinatesSilverling.x;
		double y = Credentials.CoordinatesSilverling.y;

		this.coordinatesPivot = new CoordinatesBuilder().width(Credentials.DimensionsSilverling.x)
				.height(Credentials.DimensionsSilverling.y).gapBetweenNodes(-Credentials.DimensionsSilverling.x / 2)
				.nodesPerRow(4).xPointOfInterest(x).yPointOfInterest(y).createCoordinatesPivot();

	}

	public void addSilverlingsAndRelocate(int amount) {

		for (int counter = 1; counter <= amount; counter++) {

			Silverling silverling = new Silverling();
			this.silverlings.addLast(silverling);

		}

		relocate();

	}

	public void removeSilverlingsAndRelocate(int amount) {

		for (int counter = 1; counter <= amount; counter++)
			this.silverlings.removeLast();

		relocate();

	}

	private void relocate() {

		this.coordinatesPivot.setNodesTotal(this.silverlings.size());

		for (Silverling silverling : this.silverlings) {

			int workerIndex = this.silverlings.indexOf(silverling);
			double x = this.coordinatesPivot.getX(workerIndex);
			double y = this.coordinatesPivot.getY(workerIndex);

			silverling.relocate(x, y);

		}

	}

}
