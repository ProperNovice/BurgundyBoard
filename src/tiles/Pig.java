package tiles;

public class Pig extends Animal {

	public Pig(int numberOfAnimals) {
		super(numberOfAnimals);
		super.path += "pig" + super.numberOfAnimals;
	}

}
