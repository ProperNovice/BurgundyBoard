package enums;

public enum BuildingTypeEnum {

	BANK("bank"),
	BOARDING_HOUSE("boardingHouse"),
	CARPENTERS_WORKSHOP("carpenter'sWorkshop"),
	CHURCH("church"),
	CITY_HALL("cityHall"),
	MARKET("market"),
	WAREHOUSE("warehouse"),
	WATCHTOWER("watchtower");

	private String text;

	private BuildingTypeEnum(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

}
