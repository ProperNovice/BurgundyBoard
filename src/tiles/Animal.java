package tiles;

import enums.AnimalTypeEnum;

public class Animal extends Tile {

	private AnimalTypeEnum animalTypeEnum = null;
	private int numberOfAnimals = -1;

	public Animal(AnimalTypeEnum animalTypeEnum, int numberOfAnimals) {

		this.animalTypeEnum = animalTypeEnum;
		this.numberOfAnimals = numberOfAnimals;

		super.path += "animals/";
		super.path += this.animalTypeEnum.getText();
		super.path += this.numberOfAnimals;

	}

	public AnimalTypeEnum getAnimalTypeEnum() {
		return this.animalTypeEnum;
	}

	public int getNumberOfAnimals() {
		return this.numberOfAnimals;
	}

}
