package controller;

public class Credentials {

	public static Pair DimensionsInsets, DimensionsGapBetweenBorders, DimensionsBoard, DimensionsTile,
			DimensionsDiceAreaInSpace, DimensionsGoods, DimensionsFrame, DimensionsGapBetweenComponents,
			DimensionsPhaseIndicators;
	public static Pair CoordinatesTextPanel, CoordinatesBoard, CoordinatesPhaseIndicators, CoordinatesPhaseGoods;
	public static double textHeight, boardScale;

	public static class Pair {

		public double x;
		public double y;

		public Pair(double x, double y) {

			this.x = x;
			this.y = y;

		}

	}

	public static void calculateCredentials() {

		double x, y;

		boardScale = 0.8;
		textHeight = 50;

		DimensionsInsets = new Pair(7, 29);
		DimensionsGapBetweenBorders = new Pair(20, 20);
		DimensionsGapBetweenComponents = new Pair(5, 5);
		CoordinatesTextPanel = new Pair(50, 50);

		DimensionsBoard = new Pair(1121, 781);
		DimensionsTile = new Pair(70, 80);
		DimensionsDiceAreaInSpace = new Pair(46, 46);
		DimensionsGoods = new Pair(60, 60);
		DimensionsPhaseIndicators = new Pair(29, 47);

		CoordinatesBoard = new Pair(DimensionsGapBetweenBorders.x, DimensionsGapBetweenBorders.y);

		x = 1420;
		y = Math.ceil(DimensionsBoard.y * boardScale + 2 * DimensionsGapBetweenBorders.y);
		DimensionsFrame = new Pair(x, y);

		x = CoordinatesBoard.x + DimensionsBoard.x * boardScale + DimensionsGapBetweenBorders.x;
		y = DimensionsGapBetweenBorders.y + (DimensionsGoods.y - DimensionsPhaseIndicators.y) / 2;
		CoordinatesPhaseIndicators = new Pair(x, y);

		x = CoordinatesPhaseIndicators.x + DimensionsPhaseIndicators.x + 2 * DimensionsGapBetweenComponents.x;
		y = DimensionsGapBetweenBorders.y;
		CoordinatesPhaseGoods = new Pair(x, y);

	}

}
