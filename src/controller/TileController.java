package controller;

import enums.AnimalTypeEnum;
import enums.BuildingTypeEnum;
import enums.TileTypeEnum;
import tiles.Animal;
import tiles.AnimalBlack;
import tiles.Building;
import tiles.BuildingBlack;
import tiles.Castle;
import tiles.CastleBlack;
import tiles.Knowledge;
import tiles.KnowledgeBlack;
import tiles.Mine;
import tiles.MineBlack;
import tiles.Ship;
import tiles.ShipBlack;
import tiles.Tile;
import utils.ArrayList;
import utils.HashMap;

public class TileController {

	private HashMap<TileTypeEnum, ArrayList<Tile>> tilesNormal = new HashMap<>();
	private ArrayList<Tile> tilesBlack = new ArrayList<>();

	public TileController() {

		createTiles();
		createImageViews();

	}

	private void createTiles() {

		TileTypeEnum tileTypeEnum = null;

		// Ships

		tileTypeEnum = TileTypeEnum.SHIP;

		this.tilesNormal.put(tileTypeEnum, new ArrayList<>());

		for (int counter = 1; counter <= 10; counter++)
			this.tilesNormal.get(tileTypeEnum).addLast(new Ship());

		// Castles

		tileTypeEnum = TileTypeEnum.CASTLE;

		this.tilesNormal.put(tileTypeEnum, new ArrayList<>());

		for (int counter = 1; counter <= 11; counter++)
			this.tilesNormal.get(tileTypeEnum).addLast(new Castle());

		// Mines

		tileTypeEnum = TileTypeEnum.MINE;

		this.tilesNormal.put(tileTypeEnum, new ArrayList<>());

		for (int counter = 1; counter <= 10; counter++)
			this.tilesNormal.get(tileTypeEnum).addLast(new Mine());

		// Buildings

		tileTypeEnum = TileTypeEnum.BUILDING;

		this.tilesNormal.put(tileTypeEnum, new ArrayList<>());

		for (int counter = 1; counter <= 5; counter++)
			for (BuildingTypeEnum buildingTypeEnum : BuildingTypeEnum.values())
				this.tilesNormal.get(tileTypeEnum).addLast(new Building(buildingTypeEnum));

		// Animals

		tileTypeEnum = TileTypeEnum.ANIMAL;

		this.tilesNormal.put(tileTypeEnum, new ArrayList<>());

		for (int counter = 2; counter <= 3; counter++)
			for (AnimalTypeEnum animalTypeEnum : AnimalTypeEnum.values())
				for (int amount = 1; amount <= 2; amount++)
					this.tilesNormal.get(tileTypeEnum).addLast(new Animal(animalTypeEnum, counter));

		for (AnimalTypeEnum animalTypeEnum : AnimalTypeEnum.values())
			this.tilesNormal.get(tileTypeEnum).addLast(new Animal(animalTypeEnum, 4));

		// Knowledge

		tileTypeEnum = TileTypeEnum.KNOWLEDGE;

		this.tilesNormal.put(tileTypeEnum, new ArrayList<>());

		for (int counter = 1; counter <= 26; counter++) {

			if (counter == 7 || counter == 12 || counter == 14 || counter == 15 || counter == 24 || counter == 25)
				continue;

			this.tilesNormal.get(tileTypeEnum).addLast(new Knowledge(counter));

		}

		// Black

		for (int counter = 1; counter <= 6; counter++)
			this.tilesBlack.addLast(new ShipBlack());

		for (int counter = 1; counter <= 2; counter++)
			this.tilesBlack.addLast(new CastleBlack());

		for (int counter = 1; counter <= 2; counter++)
			this.tilesBlack.addLast(new MineBlack());

		for (int counter = 1; counter <= 2; counter++)
			for (BuildingTypeEnum buildingTypeEnum : BuildingTypeEnum.values())
				this.tilesBlack.addLast(new BuildingBlack(buildingTypeEnum));

		for (int counter = 3; counter <= 4; counter++)
			for (AnimalTypeEnum animalTypeEnum : AnimalTypeEnum.values())
				this.tilesBlack.addLast(new AnimalBlack(animalTypeEnum, counter));

		this.tilesBlack.addLast(new KnowledgeBlack(7));
		this.tilesBlack.addLast(new KnowledgeBlack(12));
		this.tilesBlack.addLast(new KnowledgeBlack(14));
		this.tilesBlack.addLast(new KnowledgeBlack(15));
		this.tilesBlack.addLast(new KnowledgeBlack(24));
		this.tilesBlack.addLast(new KnowledgeBlack(25));

	}

	private void createImageViews() {

		for (TileTypeEnum tileTypeEnum : this.tilesNormal)
			for (Tile tile : this.tilesNormal.get(tileTypeEnum))
				tile.createImageView();

	}

}
