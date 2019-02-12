package controller;

import enums.TileTypeEnum;
import model.BoardSpace;
import tiles.Tile;
import utils.HashMap;

public class GameModifiers {

	private HashMap<TileTypeEnum, Integer> diceModifierTakeTileFromTheGameBoard = new HashMap<>();
	private HashMap<TileTypeEnum, Integer> diceModifierAddTileToYourEstate = new HashMap<>();
	private int diceModifierWorkers = 1;
	private boolean canBePlacedIdenticalBuildings = false;
	private Tile lastTileAddedToBoard = null;
	private BoardSpace lastBoardspaceTileAddedTo = null;

	public GameModifiers() {
		createHashMaps();
	}

	private void createHashMaps() {

		for (TileTypeEnum tileTypeEnum : TileTypeEnum.values()) {

			this.diceModifierTakeTileFromTheGameBoard.put(tileTypeEnum, 0);
			this.diceModifierAddTileToYourEstate.put(tileTypeEnum, 0);

		}

	}

	public int getDiceModifierTakeTileFromTheGameBoard(TileTypeEnum tileTypeEnum) {
		return this.diceModifierTakeTileFromTheGameBoard.get(tileTypeEnum);
	}

	public int getDiceModifierAddTileToYourEstate(TileTypeEnum tileTypeEnum) {
		return this.diceModifierAddTileToYourEstate.get(tileTypeEnum);
	}

	public int getDiceModifierWorkers() {
		return this.diceModifierWorkers;
	}

	public void addDiceModifierTakeTileFromTheGameBoard(TileTypeEnum tileTypeEnum) {
		addDiceModifier(tileTypeEnum, this.diceModifierTakeTileFromTheGameBoard);
	}

	public void addDiceModifierAddTileToYourEstate(TileTypeEnum tileTypeEnum) {
		addDiceModifier(tileTypeEnum, this.diceModifierAddTileToYourEstate);
	}

	public void addDiceModifierWorkers() {
		this.diceModifierWorkers++;
	}

	private void addDiceModifier(TileTypeEnum tileTypeEnum, HashMap<TileTypeEnum, Integer> hashMap) {

		int value = hashMap.get(tileTypeEnum);
		value++;

		hashMap.put(tileTypeEnum, value);

	}

	public void printTakeTileFromTheGameBoard() {
		this.diceModifierTakeTileFromTheGameBoard.print();
	}

	public void printAddTileToYourEstate() {
		this.diceModifierAddTileToYourEstate.print();
	}

	public boolean canBePlacedIdenticalBuildings() {
		return this.canBePlacedIdenticalBuildings;
	}

	public void setCanBePlacedIdenticalBuildingsTrue() {
		this.canBePlacedIdenticalBuildings = true;
	}

	public void setLastTileAddedToBoardSpace(Tile tile, BoardSpace boardSpace) {

		this.lastTileAddedToBoard = tile;
		this.lastBoardspaceTileAddedTo = boardSpace;

	}

	public Tile getLastTileAddedToBoard() {
		return this.lastTileAddedToBoard;
	}

}
