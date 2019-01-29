package model;

import utils.ImageView;

public class RegionScoringIndicator {

	private ImageView imageView = null;
	private int regionTotalSpaces, points;

	public RegionScoringIndicator(int regionTotalSpaces, int points) {

		this.regionTotalSpaces = regionTotalSpaces;
		this.points = points;
		createImageView();

	}

	private void createImageView() {

		String path = "";

		path += "indicators/regionScoring/";
		path += this.regionTotalSpaces;
		path += ".png";

		this.imageView = new ImageView(path);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public int getTotalSpaces() {
		return this.regionTotalSpaces;
	}

	public int getPoints() {
		return this.points;
	}

}
