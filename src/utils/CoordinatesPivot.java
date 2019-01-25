package utils;

public class CoordinatesPivot extends Coordinates {

	public CoordinatesPivot(double width, double height, double gapBetweenNodes, int nodesPerRow) {
		super(width, height, gapBetweenNodes, nodesPerRow);
	}

	@Override
	public double getX(int nodeIndex) {
		return 0;
	}

	@Override
	public double getY(int nodeIndex) {
		return 0;
	}

}
