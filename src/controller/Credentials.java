package controller;

public class Credentials {

	public static Pair DimensionsInsets, DimensionsGapBetweenBorders, DimensionsBoard, DimensionsTile,
			DimensionsDiceAreaInSpace, DimensionsGoods, DimensionsFrame;
	public static Pair CoordinatesTextPanel, CoordinatesBoard;
	public static double textHeight, boardScale;

	public static void calculateCredentials() {

		boardScale = 0.8;

//		DimensionsFrame = new Pair(1366, 788);
		DimensionsInsets = new Pair(7, 29);
		DimensionsGapBetweenBorders = new Pair(20, 20);
		CoordinatesTextPanel = new Pair(50, 50);

		DimensionsBoard = new Pair(1121, 781);
		DimensionsTile = new Pair(70, 80);
		DimensionsDiceAreaInSpace = new Pair(46, 46);
		DimensionsGoods = new Pair(60, 60);
		DimensionsFrame = new Pair(1420, Math.ceil(DimensionsBoard.y * boardScale + 2 * DimensionsGapBetweenBorders.y));

		CoordinatesBoard = new Pair(DimensionsGapBetweenBorders.x, DimensionsGapBetweenBorders.y);

		textHeight = 50;

	}

	public static class Pair {

		public double x;
		public double y;

		public Pair(double x, double y) {

			this.x = x;
			this.y = y;

		}

	}

}
