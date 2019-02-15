package model;

import instances.Instances;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
import utils.ImageView;
import utils.Logger;

public class Goods implements EventHandlerAble {

	private ImageView imageView = null;
	private int diceValue;

	public Goods(int diceValue) {

		this.diceValue = diceValue;
		createImageView();

	}

	private void createImageView() {

		String filePath = "goods/" + this.diceValue + ".jpg";
		this.imageView = new ImageView(filePath, this);
		this.imageView.setVisible(false);

	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public int getDiceValue() {
		return this.diceValue;
	}

	public void toFront() {
		this.imageView.toFront();
	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Logger.logNewLine("goods - " + this.diceValue);

		Executor.runLater(() -> Instances.getControllerInstance().gameStateManager().getCurrentGameState()
				.handleGoodsPressed(this, this.diceValue));

	}

}
