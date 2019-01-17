package enums;

public enum Credentiaals {

	TEXT_HEIGHT(50),
	BOARD_SCALE(0.8),

	;

	private double credential;

	private Credentiaals(double credential) {
		this.credential = credential;
	}

	public double credential() {
		return this.credential;
	}

}
