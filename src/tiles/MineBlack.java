package tiles;

import utils.Logger;

public class MineBlack extends Mine {

	public MineBlack() {
		super("B");
	}

	@Override
	protected void printTile() {
		super.printTile();
		Logger.log("Black");
	}

}
