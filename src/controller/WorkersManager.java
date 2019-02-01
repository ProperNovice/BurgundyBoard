package controller;

import model.Worker;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesPivot;

public class WorkersManager {

	private ArrayList<Worker> workers = new ArrayList<>();
	private CoordinatesPivot coordinatesPivotPlayerBoard = null;

	public WorkersManager() {
		createCoordinatesPivot();
		addWorkersAndRelocate(2);
	}

	private void createCoordinatesPivot() {

		double x = Credentials.CoordinatesWorkers.x;
		double y = Credentials.CoordinatesWorkers.y;

		this.coordinatesPivotPlayerBoard = new CoordinatesBuilder().width(Credentials.DimensionsWorker.x)
				.height(Credentials.DimensionsWorker.y).gapBetweenNodes(-Credentials.DimensionsWorker.x / 2)
				.nodesPerRow(4).xPointOfInterest(x).yPointOfInterest(y).createCoordinatesPivot();

	}

	public void addWorkersAndRelocate(int amount) {

		for (int counter = 1; counter <= amount; counter++) {
			this.workers.addLast(new Worker());
		}

		relocate();

	}

	public void removeWorkersAndRelocate(int amount) {

		Worker worker = null;

		for (int counter = 1; counter <= amount; counter++) {

			worker = this.workers.removeLast();
			worker.setVisible(false);

		}

		relocate();

	}

	private void relocate() {

		this.coordinatesPivotPlayerBoard.setNodesTotal(this.workers.size());

		for (Worker worker : this.workers) {

			int workerIndex = this.workers.indexOf(worker);
			double x = this.coordinatesPivotPlayerBoard.getX(workerIndex);
			double y = this.coordinatesPivotPlayerBoard.getY(workerIndex);

			worker.relocate(x, y);

		}

	}

	public int workersSize() {
		return this.workers.size();
	}

}
