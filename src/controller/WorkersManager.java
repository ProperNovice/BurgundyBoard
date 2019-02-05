package controller;

import model.Worker;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;
import utils.CoordinatesPivot;

public class WorkersManager {

	private ArrayList<Worker> workersPlayerBoard = new ArrayList<>();
	private ArrayList<Worker> workersDiceTemp = new ArrayList<>();
	private CoordinatesPivot coordinatesPivotPlayerBoard = null;
	private CoordinatesLinear coordinatesLinearDiceTemp = null;

	public WorkersManager() {
		createCoordinates();
		addWorkersToPlayerBoardAndRelocate(2);
	}

	private void createCoordinates() {

		double x, y;

		x = Credentials.CoordinatesWorkers.x;
		y = Credentials.CoordinatesWorkers.y;

		this.coordinatesPivotPlayerBoard = new CoordinatesBuilder().width(Credentials.DimensionsWorker.x)
				.height(Credentials.DimensionsWorker.y).gapBetweenNodes(-Credentials.DimensionsWorker.x / 2)
				.nodesPerRow(4).xPointOfInterest(x).yPointOfInterest(y).createCoordinatesPivot();

		x = Credentials.CoordinatesWorkersDiceTemp.x;
		y = Credentials.CoordinatesWorkersDiceTemp.y;

		this.coordinatesLinearDiceTemp = new CoordinatesBuilder().width(Credentials.DimensionsWorker.x)
				.height(Credentials.DimensionsWorker.y).gapBetweenNodes(-Credentials.DimensionsWorker.x / 2)
				.nodesPerRow(3).xPointOfInterest(x).yPointOfInterest(y).createCoordinatesLinear();

	}

	public void addWorkersToPlayerBoardAndRelocate(int amount) {

		for (int counter = 1; counter <= amount; counter++) {
			this.workersPlayerBoard.addLast(new Worker());
		}

		relocateWorkers();

	}

	public void setWorkersToDiceTempAndRelocate(int amount) {

		this.workersPlayerBoard.addAll(this.workersDiceTemp);
		this.workersDiceTemp.clear();

		for (int counter = 1; counter <= amount; counter++) {

			Worker workerToAdd = this.workersPlayerBoard.removeLast();
			workerToAdd.toFront();
			this.workersDiceTemp.addLast(workerToAdd);

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

		for (Worker worker : this.workersDiceTemp) {

			int workerIndex = this.workersDiceTemp.indexOf(worker);

			double x = this.coordinatesLinearDiceTemp.getX(workerIndex);
			double y = this.coordinatesLinearDiceTemp.getY(workerIndex);

			worker.relocate(x, y);

		}

	}

	public int workersSizeAvailable() {
		return this.workersPlayerBoard.size() + this.workersDiceTemp.size();
	}

}
