package utils;

import utils.Animation.AnimationSynch;

public abstract class ArrayListObjects<T> {

	protected double topLeftX = -1, topLeftY = -1, gapX = -1, gapY = 0;
	protected int objectsPerRow = -1;
	protected ArrayList<T> arrayList = new ArrayList<>();

	public ArrayListObjects() {

		setValues();
		checkError();

	}

	private void checkError() {

		boolean error = false;

		if (this.topLeftX == -1)
			error = true;
		else if (this.topLeftY == -1)
			error = true;
		else if (this.gapX == -1)
			error = true;

		if (!error)
			return;

		Logger.log("ArrayListImageView setValues error:");
		Logger.log(this.getClass());
		ShutDown.execute();

	}

	public void toFront() {

		ImageViewAble imageViewAble = null;

		for (int counter = this.arrayList.size() - 1; counter >= 0; counter--) {

			imageViewAble = (ImageViewAble) this.arrayList.get(counter);
			imageViewAble.getImageView().toFront();

		}

	}

	protected abstract void setValues();

	public void animateAsynchronous() {
		executeAnimateRelocate(ImageViewAbleAction.ANIMATE, AnimationSynch.ASYNCHRONOUS);
	}

	public void animateSynchronous() {
		executeAnimateRelocate(ImageViewAbleAction.ANIMATE, AnimationSynch.SYNCHRONOUS);
	}

	public void relocateImageViewAbles() {
		executeAnimateRelocate(ImageViewAbleAction.RELOCATE, null);
	}

	private enum ImageViewAbleAction {
		ANIMATE, RELOCATE
	}

	private void executeAnimateRelocate(ImageViewAbleAction imageViewAbleAction, AnimationSynch animationSynch) {

		double endingX = this.topLeftX, endingY = this.topLeftY;
		int positionInRow = 1;
		ImageView imageView = null;

		for (T t : this.arrayList) {

			imageView = ((ImageViewAble) t).getImageView();

			switch (imageViewAbleAction) {

			case ANIMATE:
				Animation.animate(imageView, endingX, endingY, animationSynch);
				break;

			case RELOCATE:
				imageView.relocate(endingX, endingY);
				break;

			}

			if (this.objectsPerRow == -1 || positionInRow < this.objectsPerRow) {

				endingX += this.gapX;
				positionInRow++;

			} else {

				endingX = this.topLeftX;
				endingY += this.gapY;
				positionInRow = 1;

			}

		}

	}

	public ArrayList<T> getArrayList() {
		return this.arrayList;
	}

}
