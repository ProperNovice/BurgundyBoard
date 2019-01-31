package controller;

import model.Worker;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesPivot;

public class WorkerManager {

	private ArrayList<Worker> workers = new ArrayList<>();
	private CoordinatesPivot coordinatesPivot = null;

	public WorkerManager() {
		createCoordinatesPivot();
		addWorkersAndRelocate(2);
	}

	private void createCoordinatesPivot() {

		double x = Credentials.CoordinatesWorkers.x;
		double y = Credentials.CoordinatesWorkers.y;

		this.coordinatesPivot = new CoordinatesBuilder().width(Credentials.DimensionsWorker.x)
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

		this.coordinatesPivot.setNodesTotal(this.workers.size());

		for (Worker worker : this.workers) {

			int workerIndex = this.workers.indexOf(worker);
			double x = this.coordinatesPivot.getX(workerIndex);
			double y = this.coordinatesPivot.getY(workerIndex);

			worker.relocate(x, y);

		}

	}

}
