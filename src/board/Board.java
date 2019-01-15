package board;

import enums.Dimensions;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public class Board implements EventHandlerAble {

	private ImageView imageView = null;

	public Board() {

		createBoard();

	}

	private void createBoard() {

		this.imageView = new ImageView("boards/aTrans.png", this);
		this.imageView.relocate(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y());

	}

}
