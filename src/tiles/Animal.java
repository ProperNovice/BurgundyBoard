package tiles;

public abstract class Animal extends Tile {

	protected int numberOfAnimals = -1;

	public Animal(int numberOfAnimals) {

		this.numberOfAnimals = numberOfAnimals;
		super.path += "animals/";

	}

	public int getNumberOfAnimals() {
		return this.numberOfAnimals;
	}

}
