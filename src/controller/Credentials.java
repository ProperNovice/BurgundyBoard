package controller;

public class Credentials {

	public static Pair DimensionsInsets, DimensionsBoard, DimensionsTile, DimensionsDiceAreaInSpace, DimensionsGoods,
			DimensionsFrame, DimensionsGapBetweenComponents, DimensionsPhaseIndicators, DimensionsDice,
			DimensionsDepotNumbered, DimensionsWorker, DimensionsSilverling;
	public static Pair CoordinatesTextPanel, CoordinatesBoard, CoordinatesPhaseIndicators, CoordinatesPhaseGoods,
			CoordinatesDepotNumbered, CoordinatesWorkers, CoordinatesSilverling, CoordinatesDepotBlack,
			CoordinatesStorageSpaceFirst, CoordinatesStorageSpaceSecond, CoordinatesStorageSpaceThird;
	public static double gapBetweenBorders, textHeight, boardScale;

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
		gapBetweenBorders = 20;
		DimensionsGapBetweenComponents = new Pair(5, 5);
		CoordinatesTextPanel = new Pair(50, 50);

		DimensionsBoard = new Pair(1121, 781);
		DimensionsTile = new Pair(70, 80);
		DimensionsDiceAreaInSpace = new Pair(46, 46);
		DimensionsGoods = new Pair(60, 60);
		DimensionsPhaseIndicators = new Pair(29, 47);
		DimensionsDice = new Pair(40, 40);
		DimensionsWorker = new Pair(36, 36);
		DimensionsSilverling = new Pair(36, 36);

		CoordinatesBoard = new Pair(gapBetweenBorders, gapBetweenBorders);

		x = 1520;
		y = Math.ceil(DimensionsBoard.y * boardScale + 2 * gapBetweenBorders);
		DimensionsFrame = new Pair(x, y);

		x = CoordinatesBoard.x + DimensionsBoard.x * boardScale + 2 * DimensionsGapBetweenComponents.x;
		y = gapBetweenBorders + (DimensionsGoods.y - DimensionsPhaseIndicators.y) / 2;
		CoordinatesPhaseIndicators = new Pair(x, y);

		x = CoordinatesPhaseIndicators.x + DimensionsPhaseIndicators.x + 2 * DimensionsGapBetweenComponents.x;
		y = CoordinatesPhaseIndicators.y - (DimensionsGoods.y - DimensionsPhaseIndicators.y) / 2;
		CoordinatesPhaseGoods = new Pair(x, y);

		x = CoordinatesPhaseIndicators.x;
		y = CoordinatesPhaseGoods.y + DimensionsGoods.y + 2 * DimensionsGapBetweenComponents.y;
		CoordinatesDepotNumbered = new Pair(x, y);

		x = DimensionsDice.x + 2 * DimensionsTile.x + 1.4 * DimensionsGoods.x + 3 * DimensionsGapBetweenComponents.x;
		y = DimensionsTile.y;
		DimensionsDepotNumbered = new Pair(x, y);

		x = CoordinatesBoard.x + boardScale * (519 + 132 / 2);
		y = CoordinatesBoard.y + boardScale * (241 + 132 / 2);
		CoordinatesWorkers = new Pair(x, y);

		x = CoordinatesBoard.x + boardScale * (429 + 181 / 2);
		y = CoordinatesBoard.y + boardScale * (2 + 130 / 2);
		CoordinatesSilverling = new Pair(x, y);

		x = CoordinatesDepotNumbered.x + DimensionsDice.x + DimensionsGapBetweenComponents.x;
		y = CoordinatesDepotNumbered.y + 3 * (DimensionsTile.y + DimensionsGapBetweenComponents.y);
		CoordinatesDepotBlack = new Pair(x, y);

		x = CoordinatesBoard.x + boardScale * (-1 + 115 / 2);
		y = CoordinatesBoard.y + boardScale * (324 + 132 / 2);
		CoordinatesStorageSpaceFirst = new Pair(x, y);

		x = CoordinatesBoard.x + boardScale * (125 + 115 / 2);
		y = CoordinatesBoard.y + boardScale * (324 + 132 / 2);
		CoordinatesStorageSpaceSecond = new Pair(x, y);

		x = CoordinatesBoard.x + boardScale * (247 + 115 / 2);
		y = CoordinatesBoard.y + boardScale * (324 + 132 / 2);
		CoordinatesStorageSpaceThird = new Pair(x, y);

	}

}
