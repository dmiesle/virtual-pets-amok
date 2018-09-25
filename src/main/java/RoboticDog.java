
public class RoboticDog extends RoboticPet implements Dog {

	public RoboticDog(String petTag, String name, int happiness, int food, int cleanliness, int health, String petDescription,
			boolean broken) {
		super(petTag, name, happiness, food, cleanliness, health, petDescription, broken);
	}

	@Override
	public void walk() {
		attend();
		cleanliness -=  1;
		food -=  1;
		health = food + happiness + cleanliness;
	}

}