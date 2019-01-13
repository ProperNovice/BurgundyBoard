package tiles;

public class Hen extends Animal {

	public Hen(int numberOfAnimals) {
		super(numberOfAnimals);
		super.path += "hen" + super.numberOfAnimals;
	}

}
