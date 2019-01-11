package gameState;

import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import utils.Logger;

public class StartGame extends GameState implements EventHandlerAble {

	private ImageView a = new ImageView("boards/a.jpg", this);

	@Override
	public void handleGameStateChange() {

		log();
//		a.relocate(100, 100);
//		a.setScale(0.8);
		a.setHeight(500);
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
