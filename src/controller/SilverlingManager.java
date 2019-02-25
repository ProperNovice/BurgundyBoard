package controller;

import model.Silverling;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;
import utils.CoordinatesPivot;
import utils.SaveLoadAble;

public class SilverlingManager implements SaveLoadAble {

	private ArrayList<Silverling> silverlingsPlayerBoard = new ArrayList<>();
	private ArrayList<Silverling> silverlingsPlayerBoardSave = new ArrayList<>();
	private ArrayList<Silverling> silverlingsTemp = new ArrayList<>();
	private CoordinatesPivot coordinatesPivot = null;
	private CoordinatesLinear coordinatesLinearSilverlingsTemp = null;

	public SilverlingManager() {
		createCoordinatesPivot();
		addSilverlingsToPlayerBoardAndRelocate(1);
	}

	private void createCoordinatesPivot() {

		double x = Credentials.CoordinatesSilverling.x;
		double y = Credentials.CoordinatesSilverling.y;

		this.coordinatesPivot = new CoordinatesBuilder().width(Credentials.DimensionsSilverling.x)
				.height(Credentials.DimensionsSilverling.y).gapBetweenNodes(-Credentials.DimensionsSilverling.x / 2)
				.nodesPerRow(4).xPointOfInterest(x).yPointOfInterest(y).createCoordinatesPivot();

		x = Credentials.CoordinatesSilverlingsTemp.x;
		y = Credentials.CoordinatesSilverlingsTemp.y;

		this.coordinatesLinearSilverlingsTemp = new CoordinatesBuilder().width(Credentials.DimensionsSilverling.x)
				.height(Credentials.DimensionsSilverling.y).gapBetweenNodes(-Credentials.DimensionsSilverling.x / 2)
				.nodesPerRow(2).xPointOfInterest(x).yPointOfInterest(y).createCoordinatesLinear();

	}

	public void addSilverlingsToPlayerBoardAndRelocate(int amount) {

		for (int counter = 1; counter <= amount; counter++) {

			Silverling silverling = new Silverling();
			this.silverlingsPlayerBoard.addLast(silverling);

		}

		relocateSilverlings();

	}

	public void setSilverlingsTempAndRelocate(int amount) {

		this.silverlingsPlayerBoard.addAll(this.silverlingsTemp);
		this.silverlingsTemp.clear();

		for (int counter = 1; counter <= amount; counter++) {

			Silverling silverlingToAdd = this.silverlingsPlayerBoard.removeLast();
			silverlingToAdd.toFront();
			this.silverlingsTemp.addLast(silverlingToAdd);

		}

		relocateSilverlings();

	}

	public void removeSilverlingsFromPlayerBoardAndRelocate(int amount) {

		Silverling silverling = null;

		for (int counter = 1; counter <= amount; counter++) {

			silverling = this.silverlingsPlayerBoard.removeLast();
			silverling.setVisible(false);

		}

		relocateSilverlings();

	}

	private void relocateSilverlings() {

		this.coordinatesPivot.setNodesTotal(this.silverlingsPlayerBoard.size());

		for (Silverling silverling : this.silverlingsPlayerBoard) {

			int silverlingIndex = this.silverlingsPlayerBoard.indexOf(silverling);
			double x = this.coordinatesPivot.getX(silverlingIndex);
			double y = this.coordinatesPivot.getY(silverlingIndex);

			silverling.relocate(x, y);
			silverling.toFront();

		}

		for (Silverling silverling : this.silverlingsTemp) {

			int silverlingIndex = this.silverlingsTemp.indexOf(silverling);

			double x = this.coordinatesLinearSilverlingsTemp.getX(silverlingIndex);
			double y = this.coordinatesLinearSilverlingsTemp.getY(silverlingIndex);

			silverling.relocate(x, y);

		}

	}

	public void removeSilverlingsTemp() {

		for (Silverling silverling : this.silverlingsTemp) {
			silverling.setVisible(false);
		}

		this.silverlingsTemp.clear();

	}

	public boolean hasAtLeastTwoSilverlings() {
		return this.silverlingsPlayerBoard.size() >= 2;
	}

	@Override
	public void saveState() {
		this.silverlingsPlayerBoardSave = this.silverlingsPlayerBoard.clone();
	}

	@Override
	public void loadState() {

		for (Silverling silverling : this.silverlingsPlayerBoard) {
			silverling.setVisible(false);
		}

		for (Silverling silverling : this.silverlingsTemp) {
			silverling.setVisible(false);
		}

		this.silverlingsTemp.clear();

		this.silverlingsPlayerBoard = this.silverlingsPlayerBoardSave.clone();

		for (Silverling silverling : this.silverlingsPlayerBoard) {
			silverling.setVisible(true);
		}

		relocateSilverlings();

	}

}
