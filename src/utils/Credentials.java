package utils;

import enums.Credentiaals;

public class Credentials {

	// Frame (1366, 788)

	public static Pair DimensionsInsets, DimensionsGapBetweenBorders, DimensionsBoard, DimensionsTile,
			DimensionsDiceAreaInSpace, DimensionsGoods, DimensionsFrame;
	public static Pair CoordinatesTextPanel, CoordinatesBoard;

	public static void calculateCredentials() {

		DimensionsInsets = new Pair(7, 29);
		DimensionsGapBetweenBorders = new Pair(20, 20);
		DimensionsBoard = new Pair(1121, 781);
		DimensionsTile = new Pair(70, 80);
		DimensionsDiceAreaInSpace = new Pair(46, 46);
		DimensionsGoods = new Pair(60, 60);
		DimensionsFrame = new Pair(1420, Math
				.ceil(DimensionsBoard.y * Credentiaals.BOARD_SCALE.credential() + 2 * DimensionsGapBetweenBorders.y));

		CoordinatesTextPanel = new Pair(50, 50);
		CoordinatesBoard = new Pair(DimensionsGapBetweenBorders.x, DimensionsGapBetweenBorders.y);

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
