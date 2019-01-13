package tiles;

public class Cow extends Animal {

	public Cow(int numberOfAnimals) {
		super(numberOfAnimals);
		super.path += "cow" + super.numberOfAnimals;
	}

}
