
public class RoboticDog extends RoboticPet implements Dog {

	public RoboticDog(String petTag, String name, int happiness, int food, int cleanliness, int health,
			boolean broken) {
		super(petTag, name, happiness, food, cleanliness, health, broken);
	}

	@Override
	public void walk() {
		attend();
		cleanliness = cleanliness - 1;
		food = food - 1;
		health = food + happiness + cleanliness;
	}

}