package controller;

import model.Worker;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesPivot;

public class WorkersManager {

	private ArrayList<Worker> workersPlayerBoard = new ArrayList<>();
	private CoordinatesPivot coordinatesPivotPlayerBoard = null;

	public WorkersManager() {
		createCoordinatesPivot();
		addWorkersToPlayerBoardAndRelocate(2);
	}

	private void createCoordinatesPivot() {

		double x = Credentials.CoordinatesWorkers.x;
		double y = Credentials.CoordinatesWorkers.y;

		this.coordinatesPivotPlayerBoard = new CoordinatesBuilder().width(Credentials.DimensionsWorker.x)
				.height(Credentials.DimensionsWorker.y).gapBetweenNodes(-Credentials.DimensionsWorker.x / 2)
				.nodesPerRow(4).xPointOfInterest(x).yPointOfInterest(y).createCoordinatesPivot();

	}

	public void addWorkersToPlayerBoardAndRelocate(int amount) {

		for (int counter = 1; counter <= amount; counter++) {
			this.workersPlayerBoard.addLast(new Worker());
		}

		relocateWorkers();

	}

	public void removeWorkersFromPlayerBoardAndRelocate(int amount) {

		Worker worker = null;

		for (int counter = 1; counter <= amount; counter++) {

			worker = this.workersPlayerBoard.removeLast();
			worker.setVisible(false);

		}

		relocateWorkers();

	}

	private void relocateWorkers() {

		this.coordinatesPivotPlayerBoard.setNodesTotal(this.workersPlayerBoard.size());

		for (Worker worker : this.workersPlayerBoard) {

			int workerIndex = this.workersPlayerBoard.indexOf(worker);
			double x = this.coordinatesPivotPlayerBoard.getX(workerIndex);
			double y = this.coordinatesPivotPlayerBoard.getY(workerIndex);

			worker.relocate(x, y);

		}

	}

	public int workersSizePlayerBoard() {
		return this.workersPlayerBoard.size();
	}

}
