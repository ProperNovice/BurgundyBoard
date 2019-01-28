package gameState;

import enums.TileTypeEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		addWorkersAndRelocate();
		addSilverlingsAndRelocate();

		test();

		super.controller.flowManager().proceedToNextPhase();

	}

	private void addWorkersAndRelocate() {
		super.controller.workerManager().addWorkersAndRelocate(2);
	}

	private void addSilverlingsAndRelocate() {
		super.controller.silverlingManager().addSilverlingsAndRelocate(1);
	}

	private void test() {

		super.controller.storageSpaceManager().addTileAndRelocate(
				super.controller.tileManager().getRandomTileNormalSetVisibleTrue(TileTypeEnum.CASTLE));
		super.controller.storageSpaceManager().addTileAndRelocate(
				super.controller.tileManager().getRandomTileNormalSetVisibleTrue(TileTypeEnum.BUILDING));
		super.controller.storageSpaceManager().addTileAndRelocate(
				super.controller.tileManager().getRandomTileNormalSetVisibleTrue(TileTypeEnum.MINE));

	}

}
