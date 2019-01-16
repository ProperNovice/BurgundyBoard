package goods;

import utils.ImageView;

public class Goods {

	private ImageView imageView = null;
	private int diceValue;

	public Goods(int diceValue) {

		this.diceValue = diceValue;
		createImageView();

	}

	private void createImageView() {

		String filePath = "goods/" + this.diceValue + ".jpg";
		this.imageView = new ImageView(filePath);
		this.imageView.setVisible(false);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public int getDiceValue() {
		return this.diceValue;
	}

}
