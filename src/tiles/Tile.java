package tiles;

import enums.TileTypeEnum;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public class Tile implements EventHandlerAble {

	protected String path = "tiles/";
	private ImageView imageView = null;
	protected TileTypeEnum tileTypeEnum = null;

	public Tile() {

	}

	public void createImageView() {

		this.path += ".png";
		this.imageView = new ImageView(this.path, this);
		setVisible(false);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

	public TileTypeEnum getTileTypeEnum() {
		return this.tileTypeEnum;
	}

}
