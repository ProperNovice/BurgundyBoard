package tiles;

import enums.AnimalTypeEnum;
import utils.Logger;

public class AnimalBlack extends Animal {

	public AnimalBlack(AnimalTypeEnum animalTypeEnum, int numberOfAnimals) {
		super(animalTypeEnum, numberOfAnimals, "B");
	}

	@Override
	protected void printTile() {
		super.printTile();
		Logger.log("Black");
	}

}
