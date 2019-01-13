package gameState;

import enums.Dimensions;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import utils.Logger;

public class StartGame extends GameState implements EventHandlerAble {

	private ImageView a = new ImageView("boards/a.jpg", this);

	@Override
	public void handleGameStateChange() {
		
		double scale = (Dimensions.FRAME.y() - 2 * Dimensions.GAP_BETWEEN_BORDERS.y()) / 855;
		Logger.log(scale);

		log();
//		a.setHeight(Dimensions.FRAME.y() - 2 * Dimensions.GAP_BETWEEN_BORDERS.y());
		a.setScale(scale);
		a.relocate(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y());
		log();

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Logger.log(a.getEventX() + " - " + a.getEventY());

	}

	private void log() {
		Logger.log(a.getWidth() + ", " + a.getHeight());
	}

}
