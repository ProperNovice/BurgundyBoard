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
		this.imageView.relocate(20, 20);

	}

	public PhaseEnum getPhaseEnum() {
		return this.phasesEnum;
	}

}
