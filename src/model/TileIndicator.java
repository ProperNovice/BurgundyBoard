package model;

import controller.Credentials;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;
import utils.ImageView;

public class TileIndicator {

	private ImageView imageView = null;

	public TileIndicator(String path) {
		createImageView(path);
	}

	private void createImageView(String pathFile) {

		String path = "indicators/tiles";
		path += pathFile;
		path += ".png";

		this.imageView = new ImageView(path);

	}

	public void relocate(double x, double y) {

		CoordinatesLinear coordinatesLinear = new CoordinatesBuilder().width(Credentials.DimensionsTileIndicators.x)
				.height(Credentials.DimensionsTileIndicators.y).gapBetweenNodes(0)
				.xPointOfInterest(Credentials.CoordinatesTileIndicators.x)
				.yPointOfInterest(Credentials.CoordinatesTileIndicators.y).nodesPerRow(60).createCoordinatesLinear();

	}

}
