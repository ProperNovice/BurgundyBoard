package utils;

public abstract class Coordinates {

	protected double width, height, gapBetweenNodes, xPointOfInterest, yPointOfInterest;
	protected int nodesPerRow;

	public Coordinates(double width, double height, double gapBetweenNodes, double xPointOfInterest,
			double yPointOfInterest, int nodesPerRow) {

		this.width = width;
		this.height = height;
		this.gapBetweenNodes = gapBetweenNodes;
		this.xPointOfInterest = xPointOfInterest;
		this.yPointOfInterest = yPointOfInterest;
		this.nodesPerRow = nodesPerRow;

	}

	public double getX(int nodeIndex) {

		int row = nodeIndex / this.nodesPerRow;
		int column = nodeIndex - row * this.nodesPerRow;
		double x = column * (this.width + this.gapBetweenNodes);

		return this.xPointOfInterest + x;

	}

	public double getY(int nodeIndex) {

		int row = nodeIndex / this.nodesPerRow;
		double y = row * (this.height + this.gapBetweenNodes);

		return this.yPointOfInterest + y;

	}

}
