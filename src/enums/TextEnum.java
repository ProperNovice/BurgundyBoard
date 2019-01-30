package enums;

public enum TextEnum {

	CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION),
	ROLL_DICE("Roll dice", TextTypeEnum.OPTION),
	RESOLVE_GRAY_DICE("Resolve gray dice", TextTypeEnum.OPTION),
	CHOOSE_AN_ACTION("Choose an action", TextTypeEnum.INDICATOR),

	;

	private String string = null;
	private TextTypeEnum textTypeEnum = null;

	public enum TextTypeEnum {
		INDICATOR, OPTION
	}

	private TextEnum(String string, TextTypeEnum textTypeEnum) {
		this.string = string;
		this.textTypeEnum = textTypeEnum;
	}

	public String string() {
		return this.string;
	}

	public TextTypeEnum textTypeEnum() {
		return this.textTypeEnum;
	}

}
