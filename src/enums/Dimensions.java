package enums;

public enum Dimensions {

//	FRAME(1366, 768),
	FRAME(1920, 1080),
	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(20, 20),
	BOARD(1121, 781),
	TILE(70, 80),
	DICE_AREA_IN_SPACE(46, 46),

	;

	private double x = -1, y = -1;

	private Dimensions(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

}
