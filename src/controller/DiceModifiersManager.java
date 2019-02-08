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

	public void addDiceModifierTakeTileFromTheGameBoard(TileTypeEnum tileTypeEnum) {
		addDiceModifier(tileTypeEnum, this.takeTileFromTheGameBoard);
	}

	public void addDiceModifierAddTileToYourEstate(TileTypeEnum tileTypeEnum) {
		addDiceModifier(tileTypeEnum, this.addTileToYourEstate);
	}

	public void addWorkersModifier() {
		this.workers++;
	}

	private void addDiceModifier(TileTypeEnum tileTypeEnum, HashMap<TileTypeEnum, Integer> hashMap) {

		int value = hashMap.get(tileTypeEnum);
		value++;

		hashMap.put(tileTypeEnum, value);

	}

	public int getWorkersModifier() {
		return this.workers;
	}

	public void printTakeTileFromTheGameBoard() {
		this.takeTileFromTheGameBoard.print();
	}

	public void printAddTileToYourEstate() {
		this.addTileToYourEstate.print();
	}

}
