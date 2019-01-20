package utils;

public class Coordinates {

	private ArrayList<Spot> coordinatesTemp = new ArrayList<>();
	private ArrayList<Spot> coordinatesFinal = new ArrayList<>();
	private int coordinatesToCreate = 100;

	public Coordinates(double width, double height, double gapBetweenNodes, int nodesPerRow) {

		double x = 0, y = 0;

		for (int counter = 1; counter <= coordinatesToCreate; counter++) {

			this.coordinatesFinal.addLast(new Spot(x, y));

			if (counter % nodesPerRow > 0) {

				x += width + gapBetweenNodes;
				continue;

			} else if (counter % nodesPerRow == 0) {

				x = 0;
				y += height + gapBetweenNodes;

			}

		}

	}

	public void proceedToNextCoordinates() {
		this.coordinatesTemp.removeFirst();
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

	private class Spot {

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
