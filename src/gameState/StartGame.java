package gameState;

import enums.PhaseEnum;
import phases.Phase;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Phase phase = new Phase(PhaseEnum.D);
		phase.relocate(1000, 20);

	}

}
