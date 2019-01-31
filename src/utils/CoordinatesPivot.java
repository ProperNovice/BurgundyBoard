package utils;

public class CoordinatesPivot extends Coordinates {

	private double xPointOfInterest, yPointOfInterest;

	public CoordinatesPivot(double width, double height, double gapBetweenNodes, double xPointOfInterest,
			double yPointOfInterest, int nodesPerRow) {

		super(width, height, gapBetweenNodes, xPointOfInterest, yPointOfInterest, nodesPerRow);
		this.xPointOfInterest = xPointOfInterest;
		this.yPointOfInterest = yPointOfInterest;

	}

	public void setNodesTotal(int nodesTotal) {

		int totalRows = (int) (Math.ceil((double) nodesTotal / super.nodesPerRow));
		int maxColumns = Math.min(nodesTotal, super.nodesPerRow);

		double totalX = super.width + (maxColumns - 1) * (super.width + super.gapBetweenNodes);
		double totalY = super.height + (totalRows - 1) * (super.height + super.gapBetweenNodes);

		super.xPointOfInterest = this.xPointOfInterest;
		super.xPointOfInterest += -totalX / 2;

		super.yPointOfInterest = this.yPointOfInterest;
		super.yPointOfInterest += -totalY / 2;

	}

}
