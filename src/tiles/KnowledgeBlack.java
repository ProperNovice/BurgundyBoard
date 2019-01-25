package tiles;

import utils.Logger;

public class KnowledgeBlack extends Knowledge {

	public KnowledgeBlack(int tileNumber) {
		super(tileNumber, "B");
	}

	@Override
	protected void printTile() {
		super.printTile();
		Logger.log("Black");
	}

}
