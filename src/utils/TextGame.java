package utils;

import controller.Credentials;
import enums.TextEnum;
import instances.Instances;
import utils.EventHandler.EventHandlerAble;

public class TextGame implements EventHandlerAble {

	private TextEnum textEnum = null;
	private Text text = null;

	public TextGame(TextEnum textEnum) {

		this.textEnum = textEnum;
		createText();

	}

	private void createText() {

		String text = this.textEnum.string();

		switch (this.textEnum.textTypeEnum()) {

		case INDICATOR:
			this.text = new Text(text);
			break;

		case OPTION:
			this.text = new TextButton(text, this);
			break;

		}

		if (this.textEnum.string().contains("\n"))
			this.text.setHeight(2 * Credentials.textHeight);
		else
			this.text.setHeight(Credentials.textHeight);

		this.text.setVisible(false);

	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Instances.getControllerInstance().textManager().concealText();

		Instances.getControllerInstance().gameStateManager().getCurrentGameState()
				.handleTextOptionPressed(this.textEnum);

	}

	public void relocate(double x, double y) {
		this.text.relocate(x, y);
	}

	public void toFront() {
		this.text.toFront();
	}

	public void setVisible(boolean value) {
		this.text.setVisible(value);
	}

	public TextEnum getTextEnum() {
		return this.textEnum;
	}

}
