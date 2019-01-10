package utils;

import gui.PanelGame;
import instances.Instances;
import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;
import utils.EventHandler.EventHandlerAble;

public class ImageView implements Node {

	private javafx.scene.image.ImageView imageView = null;
	private Image imageTrue = null;
	private Image imageFalse = new Image("misc/imageVisibilityFalse.png");
	private Image imageActive = null;
	private double scale = 1;

	public ImageView(String path) {

		this.imageTrue = new Image(path);
		createAndAddNode();

	}

	public ImageView(Image image) {

		this.imageTrue = image;
		createAndAddNode();

	}

	private void createAndAddNode() {

		this.imageView = new javafx.scene.image.ImageView(
				this.imageTrue.getImage());

		PanelGame panelGame = Instances.getPanelGameInstance();
		PlatformFX.runLater(() -> panelGame.addNode(this.imageView));

		this.imageActive = this.imageTrue;

	}

	public final void setVisible(final boolean value) {

		if (value)
			this.imageActive = this.imageTrue;
		else if (!value)
			this.imageActive = this.imageFalse;

		PlatformFX.runLater(() -> this.imageView.setImage(imageActive
				.getImage()));

	}

	public final boolean isVisible() {
		return this.imageActive.equals(this.imageTrue);
	}

	public void toBack() {
		PlatformFX.runLater(() -> this.imageView.toBack());
	}

	@Override
	public void toFront() {
		PlatformFX.runLater(() -> this.imageView.toFront());
	}

	@Override
	public final double getLayoutX() {
		return this.imageView.getLayoutX();
	}

	@Override
	public final double getLayoutY() {
		return this.imageView.getLayoutY();
	}

	@Override
	public void relocate(double x, final double y) {
		PlatformFX.runLater(() -> this.imageView.relocate(x, y));
	}

	public final void setViewport(double topLeftX, double topLeftY,
			double width, double height) {

		PlatformFX.runLater(() -> {

			Rectangle2D rectangle2d = new Rectangle2D(topLeftX, topLeftY,
					width, height);
			this.imageView.setViewport(rectangle2d);

		});

	}

	public final void setClip(double x, double y, double width, double height) {

		PlatformFX.runLater(() -> {

			Rectangle rectangle = new Rectangle(x, y, width, height);
			this.imageView.setClip(rectangle);

		});

	}

	public final void setRotate(double value) {
		PlatformFX.runLater(() -> this.imageView.setRotate(value));
	}

	public void setEventHandler(EventHandlerAble eventHandlerAble) {

		PlatformFX.runLater(() -> {

			EventHandler eventHandler = new EventHandler(eventHandlerAble);

			this.imageView.setOnMouseEntered(eventHandler);
			this.imageView.setOnMouseExited(eventHandler);
			this.imageView.setOnMousePressed(eventHandler);

		});

	}

	public final void setImage(final Image image) {

		PlatformFX.runLater(() -> {

			this.imageView.setImage(image.getImage());
			this.imageTrue = image;

		});
	}

	public final Image getImage() {
		return this.imageTrue;
	}

	public final void setScale(double scale) {

		PlatformFX.runLater(() -> {

			this.scale = scale;

			this.imageView.setScaleX(this.scale);
			this.imageView.setScaleY(this.scale);

			double widthTotal = this.imageView.minWidth(0);
			double heightTotal = this.imageView.minHeight(0);

			double widthNew = this.scale * widthTotal;
			double heightNew = this.scale * heightTotal;

			double translateX = (widthNew - widthTotal) / 2;
			double translateY = (heightNew - heightTotal) / 2;

			this.imageView.setTranslateX(translateX);
			this.imageView.setTranslateY(translateY);

		});

	}

	public void setWidth(double width) {

		double scale = width / this.imageView.minWidth(0);
		setScale(scale);

	}

	public void setHeight(double height) {

		double scale = height / this.imageView.minHeight(0);
		setScale(scale);

	}

	public double getWidth() {
		return this.imageView.minWidth(0) * this.scale;
	}

	public double getHeight() {
		return this.imageView.minHeight(0) * this.scale;
	}

	public double getScale() {
		return this.scale;
	}

}
