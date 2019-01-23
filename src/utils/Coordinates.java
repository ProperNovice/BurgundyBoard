package utils;

public abstract class Coordinates {

	protected double width, height, gapBetweenNodes;
	protected int nodesPerRow;

	public Coordinates(double width, double height, double gapBetweenNodes, int nodesPerRow) {

		this.width = width;
		this.height = height;
		this.gapBetweenNodes = gapBetweenNodes;
		this.nodesPerRow = nodesPerRow;

	}

	public abstract double getX(int nodeIndex);

	public abstract double getY(int nodeIndex);

}
