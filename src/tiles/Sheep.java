package tiles;

public class Sheep extends Animal {

	public Sheep(int numberOfAnimals) {
		super(numberOfAnimals);
		super.path += "sheep" + super.numberOfAnimals;
	}

}
