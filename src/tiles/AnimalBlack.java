package tiles;

import enums.AnimalTypeEnum;

public class AnimalBlack extends Animal {

	public AnimalBlack(AnimalTypeEnum animalTypeEnum, int numberOfAnimals) {

		super(animalTypeEnum, numberOfAnimals);
		super.path += "B";

	}

}
