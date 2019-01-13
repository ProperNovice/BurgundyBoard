package tiles;

import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public class Tile implements EventHandlerAble {

	protected String path = "tiles/";
	private ImageView imageView = null;

	public Tile() {

	}

	public void createImageView() {

		this.path += ".png";
		this.imageView = new ImageView(this.path, this);

	}

}
