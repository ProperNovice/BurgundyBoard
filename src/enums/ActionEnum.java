package enums;

public enum ActionEnum {

	TAKE_TILE_FROM_THE_GAME_BOARD("take tile from the game board"),
	ADD_TILE_TO_YOUR_ESTATE("add tile to your estate"),
	TAKE_WORKERS_TILES("take workers tiles"),
	BUY_TILE_FROM_THE_BLACK_DEPOT("buy tile from the black depot"),
	SELL_GOODS("sell goods");
	
	private String text = null;
	
	private ActionEnum(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}

}
