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
	private boolean receiveWorkersAtTheEndOfThePhase = false;
	private boolean canOnlyBuyFromTheBlackDepot = true;
	private int animalTypeExtraPoints = 0;

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

	public void setDiceModifierTakeTileFromTheGameBoardToOne() {
		this.diceModifierTakeTileFromTheGameBoard = 1;
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

	public BoardSpace getLastBoardspaceTileAddedTo() {
		return this.lastBoardspaceTileAddedTo;
	}

	public void addOneSilverlingsReceivedAtTheEndOfThePhase() {
		this.silverlingsReceivedAtTheEndOfThePhase++;
	}

	public int getSilverlingsReceivedAtTheEndOfThePhase() {
		return this.silverlingsReceivedAtTheEndOfThePhase;
	}

	public void setReceiveWorkersAtTheEndOfThePhaseTrue() {
		this.receiveWorkersAtTheEndOfThePhase = true;
	}

	public boolean getReceiveWorkersAtTheEndOfThePhase() {
		return this.receiveWorkersAtTheEndOfThePhase;
	}

	public void setCanOnlyBuyFromTheBlackDepotFalse() {
		this.canOnlyBuyFromTheBlackDepot = false;
	}

	public boolean canOnlyBuyFromTheBlackDepot() {
		return this.canOnlyBuyFromTheBlackDepot;
	}

	public void setAnimalTypeExtraPointsToOne() {
		this.animalTypeExtraPoints = 1;
	}

	public int getAnimalTypeExtraPoints() {
		return this.animalTypeExtraPoints;
	}

}
