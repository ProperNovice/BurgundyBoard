package utils;

public class CoordinatesLinear extends Coordinates {

	public CoordinatesLinear(double width, double height, double gapBetweenNodes, int nodesPerRow) {
		super(width, height, gapBetweenNodes, nodesPerRow);
	}

	@Override
	public double getX(int nodeIndex) {

		int row = nodeIndex / super.nodesPerRow;
		int column = nodeIndex - row * super.nodesPerRow;
		double x = column * (super.width + super.gapBetweenNodes);

		return x;
	}

	@Override
	public double getY(int nodeIndex) {

		int row = nodeIndex / super.nodesPerRow;
		double y = row * (super.height + super.gapBetweenNodes);

		return y;

	}

}
