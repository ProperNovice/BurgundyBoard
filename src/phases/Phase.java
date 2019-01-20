package phases;

import enums.PhaseEnum;
import utils.ImageView;

public class Phase {

	private PhaseEnum phasesEnum = null;
	private ImageView imageView = null;

	public Phase(PhaseEnum phasesEnum) {

		this.phasesEnum = phasesEnum;
		createImageView();

	}

	private void createImageView() {

		String path = "phases/";
		path += phasesEnum.toString().toLowerCase();
		path += ".png";

		this.imageView = new ImageView(path);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public PhaseEnum getPhaseEnum() {
		return this.phasesEnum;
	}

}
