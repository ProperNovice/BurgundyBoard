package tiles;

import controller.Credentials;
import enums.TileTypeEnum;
import instances.Instances;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
import utils.ImageView;
import utils.Logger;

public abstract class Tile implements EventHandlerAble {

	private ImageView imageView = null;
	protected TileTypeEnum tileTypeEnum = null;
	private ImageView selectImageView = null;

	protected Tile(String filePathTemp) {
		createImageViews(filePathTemp);
	}

	protected void createImageViews(String filePathTemp) {

		String filePath = "tiles/";
		filePath += filePathTemp;
		filePath += ".png";

		this.imageView = new ImageView(filePath, this);
		setVisible(false);

		this.selectImageView = new ImageView("select.png", this);
		this.selectImageView.setVisible(false);
		this.selectImageView.setWidth(Credentials.DimensionsSelectImageViewTile.x);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
		this.selectImageView.relocate(x, y);
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

	protected void printTile() {
		Logger.log(this.tileTypeEnum);
	}

	public void setSelected(boolean value) {
		this.selectImageView.setVisible(value);
	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		printTile();
		Logger.newLine();

		Executor.runLater(() -> Instances.getControllerInstance().gameStateManager().getCurrentGameState()
				.handleTilePressed(this, this.tileTypeEnum));

	}

}
