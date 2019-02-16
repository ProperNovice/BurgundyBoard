package controller;

import enums.TileTypeEnum;
import model.BoardSpace;
import tiles.Tile;
import utils.HashMap;

public class GameModifiers {

	private int diceModifierTakeTileFromTheGameBoard = 0;
	private HashMap<TileTypeEnum, Integer> diceModifierAddTileToYourEstate = new HashMap<>();
	private int diceModifierWorkers = 1;
	private boolean canBePlacedIdenticalBuildings = false;
	private Tile lastTileAddedToBoard = null;
	private BoardSpace lastBoardspaceTileAddedTo = null;
	private int silverlingsReceivedAtTheEndOfThePhase = 0;

	public GameModifiers() {
		createHashMaps();
	}

	private void createHashMaps() {

		for (TileTypeEnum tileTypeEnum : TileTypeEnum.values()) {
			this.diceModifierAddTileToYourEstate.put(tileTypeEnum, 0);
		}

	}

	public int getDiceModifierTakeTileFromTheGameBoard() {
		return this.diceModifierTakeTileFromTheGameBoard;
	}

	public int getDiceModifierAddTileToYourEstate(TileTypeEnum tileTypeEnum) {
		return this.diceModifierAddTileToYourEstate.get(tileTypeEnum);
	}

	public int getDiceModifierWorkers() {
		return this.diceModifierWorkers;
	}

	public void addDiceModifierTakeTileFromTheGameBoard() {
		this.diceModifierTakeTileFromTheGameBoard++;
	}

	public void addDiceModifierAddTileToYourEstate(TileTypeEnum tileTypeEnum) {
		addDiceModifierTilePlusOne(tileTypeEnum, this.diceModifierAddTileToYourEstate);
	}

	public void addDiceModifierWorkersPlusOne() {
		this.diceModifierWorkers++;
	}

	private void addDiceModifierTilePlusOne(TileTypeEnum tileTypeEnum, HashMap<TileTypeEnum, Integer> hashMap) {

		int value = hashMap.get(tileTypeEnum);
		value++;

		hashMap.put(tileTypeEnum, value);

	}

	public void testPrintAddTileToYourEstate() {
		this.diceModifierAddTileToYourEstate.print();
	}

	public boolean canPlaceIdenticalBuildings() {
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

	public void addOneSilverlingsReceivedAtTheEndOfThePhase() {
		this.silverlingsReceivedAtTheEndOfThePhase++;
	}

	public int getSilverlingsReceivedAtTheEndOfThePhase() {
		return this.silverlingsReceivedAtTheEndOfThePhase;
	}

	public BoardSpace getLastBoardspaceTileAddedTo() {
		return this.lastBoardspaceTileAddedTo;
	}

}
