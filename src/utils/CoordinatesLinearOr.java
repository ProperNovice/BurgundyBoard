package utils;

public class CoordinatesLinearOr extends Coordinates {

	protected ArrayList<Spot> coordinatesTemp = new ArrayList<>();
	protected ArrayList<Spot> coordinatesFinal = new ArrayList<>();
	protected double width, height, gapBetweenNodes;
	protected int nodesPerRow;

	public CoordinatesLinearOr(double width, double height, double gapBetweenNodes, int nodesPerRow) {

		this.width = width;
		this.height = height;
		this.gapBetweenNodes = gapBetweenNodes;
		this.nodesPerRow = nodesPerRow;

	}

	public void setUpNextCoordinates() {

		if (!this.coordinatesTemp.isEmpty())
			this.coordinatesTemp.removeFirst();

		if (this.coordinatesTemp.isEmpty())
			createNewCoordinates();

	}

	public double getX() {
		return this.coordinatesTemp.getFirst().getX();
	}

	public double getY() {
		return this.coordinatesTemp.getFirst().getY();
	}

	public void resetCoordinates() {
		this.coordinatesTemp.clear();
		this.coordinatesTemp.addAll(this.coordinatesFinal);
	}

	private void createNewCoordinates() {

		int row = this.coordinatesFinal.size() / this.nodesPerRow;
		int column = this.coordinatesFinal.size() - row * this.nodesPerRow;

		double x = column * (this.width + this.gapBetweenNodes);
		double y = row * (this.height + this.gapBetweenNodes);

		Spot spot = new Spot(x, y);

		this.coordinatesFinal.addLast(spot);
		this.coordinatesTemp.addLast(spot);

	}

	protected class Spot {

		private double x, y;

		public Spot(double x, double y) {

			this.x = x;
			this.y = y;

		}

		public double getX() {
			return this.x;
		}

		public double getY() {
			return this.y;
		}

	}

}
