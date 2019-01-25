package tiles;

import utils.Logger;

public class ShipBlack extends Ship {

	public ShipBlack() {
		super("B");
	}

	@Override
	protected void printTile() {
		super.printTile();
		Logger.log("Black");
	}

}
