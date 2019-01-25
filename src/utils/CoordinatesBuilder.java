package utils;

public class CoordinatesBuilder {

	private double width, height, gapBetweenNodes;
	private int nodesPerRow;
	private CoordinatesType coordinatesType = null;
	private int dataTotal = 5, dataInput = 0;

	public CoordinatesBuilder() {

	}

	public enum CoordinatesType {
		LINEAR, PIVOT
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

	public CoordinatesBuilder type(CoordinatesType coordinatesType) {
		this.coordinatesType = coordinatesType;
		this.dataInput++;
		return this;
	}

	public Coordinates create() {

		if (this.dataInput != this.dataTotal) {

			Logger.log("need more input data");
			ShutDown.execute();

		}

		switch (coordinatesType) {

		case LINEAR:
			return new CoordinatesLinear(this.width, this.height, this.gapBetweenNodes, this.nodesPerRow);

		case PIVOT:
			return new CoordinatesPivot(this.width, this.height, this.gapBetweenNodes, this.nodesPerRow);

		}

		return null;
	}

}