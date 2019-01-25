package model;

import controller.Credentials;
import utils.ImageView;

public class Silverling {

	private ImageView imageView = null;

	public Silverling() {
		createImageview();
	}

	private void createImageview() {

		this.imageView = new ImageView("silverling.png");
		this.imageView.setWidth(Credentials.DimensionsSilverling.x);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

}
