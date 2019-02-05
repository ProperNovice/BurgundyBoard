package model;

import utils.ImageView;

public class Worker {

	private ImageView imageView = null;

	public Worker() {
		createImageview();
	}

	private void createImageview() {

		this.imageView = new ImageView("worker.jpg");

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

	public void toFront() {
		this.imageView.toFront();
	}

}
