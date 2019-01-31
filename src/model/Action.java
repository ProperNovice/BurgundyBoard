package model;

import enums.ActionEnum;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public class Action implements EventHandlerAble {

	private ActionEnum actionEnum = null;
	private ImageView imageView = null;

	public Action(ActionEnum actionEnum) {

		this.actionEnum = actionEnum;
		createImageView();

	}

	private void createImageView() {

		String path = "actions/";
		path += this.actionEnum.getText();
		path += ".jpg";

		this.imageView = new ImageView(path, this);
		this.imageView.setVisible(false);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

	public ActionEnum getActionEnum() {
		return this.actionEnum;
	}

}
