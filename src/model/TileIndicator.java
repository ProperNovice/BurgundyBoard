package model;

import utils.ImageView;

public class TileIndicator {

	private ImageView imageView = null;

	public TileIndicator(String path) {
		createImageView(path);
	}

	private void createImageView(String pathFile) {

		String path = "indicators/tiles/";
		path += pathFile;
		path += ".png";

		this.imageView = new ImageView(path);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

}
