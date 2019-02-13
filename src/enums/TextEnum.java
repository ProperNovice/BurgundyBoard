package enums;

public enum TextEnum {

	CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION),
	CHOOSE_SPACE_TO_PLACE_THE_CASTLE("Choose space for castle", TextTypeEnum.INDICATOR),
	START_NEW_PHASE("Start new phase", TextTypeEnum.OPTION),
	START_NEW_ROUND("Start new round", TextTypeEnum.OPTION),
	RESOLVE_GRAY_DICE("Resolve gray dice", TextTypeEnum.OPTION),
	CHOOSE_AN_ACTION("Choose an action", TextTypeEnum.INDICATOR),
	CHOOSE_TILE_AND_DICE("Choose tile & dice", TextTypeEnum.INDICATOR),
	CHOOSE_BLACK_TILE("Choose black tile", TextTypeEnum.INDICATOR),
	CHOOSE_DICE("Choose dice", TextTypeEnum.INDICATOR),
	CHOOSE_A_TILE_TO_DISCARD("Choose a tile to discard", TextTypeEnum.INDICATOR),
	CHOOSE_DICE_TILE_AND_BOARD_SPACE("Choose dice, tile &\nboard space", TextTypeEnum.INDICATOR),
	CHOOSE_TILE("Choose a tile", TextTypeEnum.INDICATOR),
	RESOLVE_TILE_ADDED("Resolve tile added", TextTypeEnum.OPTION),
	RESOLVE_VICTORY_POINTS_TARGET_REACHED("Resolve vp reached", TextTypeEnum.OPTION),
	CHOOSE_A_BUILDING("Choose a building", TextTypeEnum.INDICATOR),
	CHOOSE_A_MINE_KNOWLEDGE_OR_CASTLE("Choose a mine,\nknowledge or castle", TextTypeEnum.INDICATOR),
	CHOOSE_AN_ANIMAL_OR_SHIP("Choose an animal\nor ship", TextTypeEnum.INDICATOR),
	CHOOSE_TILE_AND_BOARD_SPACE("Choose dice &\nboard space", TextTypeEnum.INDICATOR),
	
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
