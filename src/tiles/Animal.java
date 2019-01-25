package tiles;

import enums.AnimalTypeEnum;
import enums.TileTypeEnum;
import utils.Logger;

public class Animal extends Tile {

	private AnimalTypeEnum animalTypeEnum = null;
	private int numberOfAnimals = -1;

	public Animal(AnimalTypeEnum animalTypeEnum, int numberOfAnimals) {

		super("animals/" + animalTypeEnum.getText() + numberOfAnimals);
		setCredentials(animalTypeEnum, numberOfAnimals);

	}

	protected Animal(AnimalTypeEnum animalTypeEnum, int numberOfAnimals, String filePath) {

		super("animals/" + animalTypeEnum.getText() + numberOfAnimals + filePath);
		setCredentials(animalTypeEnum, numberOfAnimals);

	}

	private void setCredentials(AnimalTypeEnum animalTypeEnum, int numberOfAnimals) {

		this.animalTypeEnum = animalTypeEnum;
		this.numberOfAnimals = numberOfAnimals;
		super.tileTypeEnum = TileTypeEnum.ANIMAL;

	}

	public AnimalTypeEnum getAnimalTypeEnum() {
		return this.animalTypeEnum;
	}

	public int getNumberOfAnimals() {
		return this.numberOfAnimals;
	}

	@Override
	protected void printTile() {
		super.printTile();
		Logger.log(this.animalTypeEnum + " - " + this.numberOfAnimals);
	}

}
