package controller;

public class Credentials {

	public static NumbersPair DimensionsInsets, DimensionsBoard, DimensionsTile, DimensionsDiceAreaInSpace,
			DimensionsGoods, DimensionsFrame, DimensionsGapBetweenComponents, DimensionsPhaseIndicators, DimensionsDice,
			DimensionsDepotNumbered, DimensionsWorker, DimensionsSilverling, DimensionsTileIndicators,
			DimensionsRegionScoringIndicator;
	public static NumbersPair CoordinatesTextPanel, CoordinatesBoard, CoordinatesPhaseIndicators, CoordinatesPhaseGoods,
			CoordinatesDepotNumbered, CoordinatesWorkers, CoordinatesSilverling, CoordinatesDepotBlack,
			CoordinatesStorageSpaceFirst, CoordinatesStorageSpaceSecond, CoordinatesStorageSpaceThird,
			CoordinatesTileIndicators, CoordinatesRegionScoringIndicators;
	public static double gapBetweenBorders, textHeight, boardScale;

	public static class NumbersPair {

		public double x;
		public double y;

		public NumbersPair(double x, double y) {

			this.x = x;
			this.y = y;

		}

	}

	public static void calculateCredentials() {

		double x, y;

		boardScale = 0.8;
		textHeight = 50;

		DimensionsInsets = new NumbersPair(7, 29);
		gapBetweenBorders = 20;
		DimensionsGapBetweenComponents = new NumbersPair(5, 5);
		CoordinatesTextPanel = new NumbersPair(50, 50);

		DimensionsBoard = new NumbersPair(1121, 781);
		DimensionsTile = new NumbersPair(70, 80);
		DimensionsDiceAreaInSpace = new NumbersPair(46, 46);
		DimensionsGoods = new NumbersPair(60, 60);
		DimensionsPhaseIndicators = new NumbersPair(29, 47);
		DimensionsDice = new NumbersPair(40, 40);
		DimensionsWorker = new NumbersPair(36, 36);
		DimensionsSilverling = new NumbersPair(36, 36);
		DimensionsTileIndicators = new NumbersPair(42, 76);
		DimensionsRegionScoringIndicator = new NumbersPair(26, 31);

		CoordinatesBoard = new NumbersPair(gapBetweenBorders, gapBetweenBorders);

		x = CoordinatesBoard.x + DimensionsBoard.x * boardScale + 2 * DimensionsGapBetweenComponents.x;
		y = gapBetweenBorders;
		CoordinatesTileIndicators = new NumbersPair(x, y);

		x = CoordinatesTileIndicators.x + 13 * (DimensionsTileIndicators.x + 1) - 1 + gapBetweenBorders;
		y = Math.ceil(DimensionsBoard.y * boardScale + 2 * gapBetweenBorders);
		DimensionsFrame = new NumbersPair(x, y);

		x = CoordinatesBoard.x + DimensionsBoard.x * boardScale + 2 * DimensionsGapBetweenComponents.x;
		y = CoordinatesTileIndicators.y + DimensionsTileIndicators.y + 2 * DimensionsGapBetweenComponents.y
				+ (DimensionsGoods.y - DimensionsPhaseIndicators.y) / 2;
		CoordinatesPhaseIndicators = new NumbersPair(x, y);

		x = CoordinatesPhaseIndicators.x + DimensionsPhaseIndicators.x + 2 * DimensionsGapBetweenComponents.x;
		y = CoordinatesPhaseIndicators.y - (DimensionsGoods.y - DimensionsPhaseIndicators.y) / 2;
		CoordinatesPhaseGoods = new NumbersPair(x, y);

		x = CoordinatesPhaseIndicators.x;
		y = CoordinatesPhaseGoods.y + DimensionsGoods.y + 2 * DimensionsGapBetweenComponents.y;
		CoordinatesDepotNumbered = new NumbersPair(x, y);

		x = DimensionsDice.x + 2 * DimensionsTile.x + 1.4 * DimensionsGoods.x + 3 * DimensionsGapBetweenComponents.x;
		y = DimensionsTile.y;
		DimensionsDepotNumbered = new NumbersPair(x, y);

		x = CoordinatesBoard.x + boardScale * (519 + 132 / 2);
		y = CoordinatesBoard.y + boardScale * (241 + 132 / 2);
		CoordinatesWorkers = new NumbersPair(x, y);

		x = CoordinatesBoard.x + boardScale * (429 + 181 / 2);
		y = CoordinatesBoard.y + boardScale * (2 + 130 / 2);
		CoordinatesSilverling = new NumbersPair(x, y);

		x = CoordinatesDepotNumbered.x + DimensionsDice.x + DimensionsGapBetweenComponents.x;
		y = CoordinatesDepotNumbered.y + 3 * (DimensionsTile.y + DimensionsGapBetweenComponents.y);
		CoordinatesDepotBlack = new NumbersPair(x, y);

		x = CoordinatesBoard.x + boardScale * (-1 + 115 / 2);
		y = CoordinatesBoard.y + boardScale * (324 + 132 / 2);
		CoordinatesStorageSpaceFirst = new NumbersPair(x, y);

		x = CoordinatesBoard.x + boardScale * (125 + 115 / 2);
		y = CoordinatesBoard.y + boardScale * (324 + 132 / 2);
		CoordinatesStorageSpaceSecond = new NumbersPair(x, y);

		x = CoordinatesBoard.x + boardScale * (247 + 115 / 2);
		y = CoordinatesBoard.y + boardScale * (324 + 132 / 2);
		CoordinatesStorageSpaceThird = new NumbersPair(x, y);

		x = CoordinatesPhaseGoods.x + 5 * (DimensionsGoods.x + DimensionsGapBetweenComponents.x)
				+ DimensionsGapBetweenComponents.x;
		y = CoordinatesPhaseGoods.y + (DimensionsGoods.y - DimensionsRegionScoringIndicator.y) / 2;
		CoordinatesRegionScoringIndicators = new NumbersPair(x, y);

	}

}
