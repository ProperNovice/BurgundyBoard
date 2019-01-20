package utils;

public class CoordinatesBuilder {

	private double width, height, gapBetweenNodes;
	private int nodesPerRow;
	private int dataTotal = 4, dataInput = 0;

	public CoordinatesBuilder() {

	}

	public CoordinatesBuilder width(double width) {
		this.width = width;
		this.dataInput++;
		return this;
	}

	public CoordinatesBuilder height(double height) {
		this.height = height;
		this.dataInput++;
		return this;
	}

	public CoordinatesBuilder gapBetweenNodes(double gapBetweenNodes) {
		this.gapBetweenNodes = gapBetweenNodes;
		this.dataInput++;
		return this;
	}

	public CoordinatesBuilder nodesPerRow(int nodesPerRow) {
		this.nodesPerRow = nodesPerRow;
		this.dataInput++;
		return this;
	}

	public Coordinates create() {

		if (this.dataInput != this.dataTotal) {

			Logger.log("need more input data");
			ShutDown.execute();

		}

		return new Coordinates(this.width, this.height, this.gapBetweenNodes, this.nodesPerRow);
	}

}