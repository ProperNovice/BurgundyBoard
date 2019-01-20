package tiles;

import enums.TileTypeEnum;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public abstract class Tile implements EventHandlerAble {

	private ImageView imageView = null;
	protected TileTypeEnum tileTypeEnum = null;

	protected Tile(String filePathTemp) {
		createImageView(filePathTemp);
	}

	public void createImageView(String filePathTemp) {

		String filePath = "tiles/";
		filePath += filePathTemp;
		filePath += ".png";

		this.imageView = new ImageView(filePath, this);
		setVisible(false);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void animateAsynchronous(double x, double y) {
		Animation.animate(this.imageView, x, y, AnimationSynch.ASYNCHRONOUS);
	}

	public void animateSynchronous(double x, double y) {
		Animation.animate(this.imageView, x, y, AnimationSynch.SYNCHRONOUS);
	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

	public TileTypeEnum getTileTypeEnum() {
		return this.tileTypeEnum;
	}

}
