package controller;

import enums.PhaseEnum;
import model.PhaseIndicator;
import utils.ArrayList;

public class PhaseIndicatorManager {

	private ArrayList<PhaseIndicator> phaseIndicators = new ArrayList<>();
	private PhaseIndicator currentPhaseIndicator = null;

	public PhaseIndicatorManager() {

		createPhaseIndicators();
		setNewPhaseIndicator();

	}

	private void createPhaseIndicators() {

		for (PhaseEnum phaseEnum : PhaseEnum.values())
			this.phaseIndicators.addLast(new PhaseIndicator(phaseEnum));

	}

	public void setNewPhaseIndicator() {

		if (this.currentPhaseIndicator != null)
			this.currentPhaseIndicator.setVisible(false);

		this.currentPhaseIndicator = this.phaseIndicators.removeFirst();
		this.currentPhaseIndicator.setVisible(true);

	}

	public int getCurrentPhaseRegionCompletedVictoryPoints() {
		return this.currentPhaseIndicator.getPhaseEnum().victoryPoints();
	}

}
