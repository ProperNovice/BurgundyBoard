package tiles;

import enums.TileTypeEnum;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;
import utils.Logger;

public class Tile implements EventHandlerAble {

	protected String path = "tiles/";
	private ImageView imageView = null;
	protected TileTypeEnum tileTypeEnum = null;

	public Tile() {

	}

	public void createImageView() {

		this.path += ".png";
		Logger.log(this.path);
		this.imageView = new ImageView(this.path, this);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public TileTypeEnum getTileTypeEnum() {
		return this.tileTypeEnum;
	}

}
