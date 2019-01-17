package enums;

public enum PhaseEnum {

	A(10), B(8), C(6), D(4), E(2);

	private int victoryPoints;

	private PhaseEnum(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}

	public int victoryPoints() {
		return this.victoryPoints;
	}

}
