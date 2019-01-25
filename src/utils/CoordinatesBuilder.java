package utils;

public class CoordinatesBuilder {

	private double width, height, gapBetweenNodes, xPointOfInterest, yPointOfInterest;
	private int nodesPerRow;

	public CoordinatesBuilder() {

	}

	public CoordinatesBuilder width(double width) {
		this.width = width;
		return this;
	}

	public CoordinatesBuilder height(double height) {
		this.height = height;
		return this;
	}

	public CoordinatesBuilder gapBetweenNodes(double gapBetweenNodes) {
		this.gapBetweenNodes = gapBetweenNodes;
		return this;
	}

	public CoordinatesBuilder xPointOfInterest(double xPointOfInterest) {
		this.xPointOfInterest = xPointOfInterest;
		return this;
	}

	public CoordinatesBuilder yPointOfInterest(double yPointOfInterest) {
		this.yPointOfInterest = yPointOfInterest;
		return this;
	}

	public CoordinatesBuilder nodesPerRow(int nodesPerRow) {
		this.nodesPerRow = nodesPerRow;
		return this;
	}

	public CoordinatesLinear createCoordinatesLinear() {
		return new CoordinatesLinear(this.width, this.height, this.gapBetweenNodes, this.xPointOfInterest,
				this.yPointOfInterest, this.nodesPerRow);
	}

	public CoordinatesPivot createCoordinatesPivot() {
		return new CoordinatesPivot(this.width, this.height, this.gapBetweenNodes, this.xPointOfInterest,
				this.yPointOfInterest, this.nodesPerRow);
	}

}