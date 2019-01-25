package tiles;

import utils.Logger;

public class CastleBlack extends Castle {

	public CastleBlack() {
		super("B");
	}

	@Override
	protected void printTile() {
		super.printTile();
		Logger.log("Black");
	}

}
