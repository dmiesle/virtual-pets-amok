
public class RoboticDog extends VirtualPet {



	public RoboticDog(String petTag, String name, int happiness, int food, int cleanliness, int health) {
		super (petTag, name, happiness, food, cleanliness, health);
	}
		public void walk() {
			attend();
			cleanliness = cleanliness -1;
			food = food -1;
			health = food + happiness + cleanliness;
	}

	
}