package tiles;

import enums.AnimalTypeEnum;
import enums.TileTypeEnum;

public class Animal extends Tile {

	private AnimalTypeEnum animalTypeEnum = null;
	private int numberOfAnimals = -1;

	public Animal(AnimalTypeEnum animalTypeEnum, int numberOfAnimals) {

		this.animalTypeEnum = animalTypeEnum;
		this.numberOfAnimals = numberOfAnimals;
		super.tileTypeEnum = TileTypeEnum.ANIMAL;

		super.filePath += "animals/";
		super.filePath += this.animalTypeEnum.getText();
		super.filePath += this.numberOfAnimals;

	}

	public AnimalTypeEnum getAnimalTypeEnum() {
		return this.animalTypeEnum;
	}

	public int getNumberOfAnimals() {
		return this.numberOfAnimals;
	}

}
