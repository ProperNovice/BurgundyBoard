package controller;

import enums.TileTypeEnum;
import utils.HashMap;

public class DiceModifiersManager {

	private HashMap<TileTypeEnum, Integer> takeTileFromTheGameBoard = new HashMap<>();
	private HashMap<TileTypeEnum, Integer> addTileToYourEstate = new HashMap<>();
	private int workers = 1;

	public DiceModifiersManager() {
		createHashMaps();
	}

	private void createHashMaps() {

		for (TileTypeEnum tileTypeEnum : TileTypeEnum.values()) {

			this.takeTileFromTheGameBoard.put(tileTypeEnum, 0);
			this.addTileToYourEstate.put(tileTypeEnum, 0);

		}

	}

	public int getDiceModifierTakeTileFromTheGameBoard(TileTypeEnum tileTypeEnum) {
		return this.takeTileFromTheGameBoard.get(tileTypeEnum);
	}

	public int getDiceModifierAddTileToYourEstate(TileTypeEnum tileTypeEnum) {
		return this.addTileToYourEstate.get(tileTypeEnum);
	}

	public int getWorkersModifiers() {
		return this.workers;
	}

}
