package tiles;

import enums.TileTypeEnum;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public class Tile implements EventHandlerAble {

	protected String filePath = "tiles/";
	private ImageView imageView = null;
	protected TileTypeEnum tileTypeEnum = null;

	public Tile() {

	}

	public void createImageView() {

		this.filePath += ".png";
		this.imageView = new ImageView(this.filePath, this);
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
