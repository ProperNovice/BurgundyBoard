package phases;

import controller.Credentials;
import enums.PhaseEnum;
import utils.ImageView;

public class PhaseIndicator {

	private PhaseEnum phasesEnum = null;
	private ImageView imageView = null;

	public PhaseIndicator(PhaseEnum phasesEnum) {

		this.phasesEnum = phasesEnum;
		createImageView();

	}

	private void createImageView() {

		String path = "phases/";
		path += phasesEnum.toString().toLowerCase();
		path += ".png";

		this.imageView = new ImageView(path);
		this.imageView.setVisible(false);
		this.imageView.relocate(Credentials.CoordinatesPhaseIndicators.x, Credentials.CoordinatesPhaseIndicators.y);

	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

	public PhaseEnum getPhaseEnum() {
		return this.phasesEnum;
	}

}
