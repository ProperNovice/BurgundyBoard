package test;

import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import utils.Lock;
import utils.Logger;

public class Token implements EventHandlerAble {

	private ImageView imageView = null;
	private double x, y;

	public Token() {

		this.imageView = new ImageView("ship.png", this);

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		this.x += 200;
		this.y += 250;

		Logger.log("primary");
		Animation.animate(this.imageView, this.x, this.y, AnimationSynch.SYNCHRONOUS);

		Lock.lock();
		Logger.log("finished");

	}

	@Override
	public void handleMouseEntered() {

		Logger.log("entered");

	}

	@Override
	public void handleMouseExited() {

		Logger.log("exited");

	}

	@Override
	public void handleMouseButtonPressedSecondary() {

		Logger.log("secondary");

	}

	public void relocate(double x, double y) {

		this.x = x;
		this.y = y;
		this.imageView.relocate(this.x, this.y);

	}

}
