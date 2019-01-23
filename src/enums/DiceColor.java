package enums;

public enum DiceColor {

	GRAY("gray"), RED("red");

	private String text = null;

	private DiceColor(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

}
