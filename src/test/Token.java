package test;

import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import utils.Logger;

public class Token implements EventHandlerAble {

	private ImageView imageView = null;

	public Token() {

		this.imageView = new ImageView("ship.png", this);

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Logger.log("yo");

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

}
