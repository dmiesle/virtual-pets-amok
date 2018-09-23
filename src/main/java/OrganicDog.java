
public class OrganicDog extends OrganicPet {

	public OrganicDog(String petTag, String name, int happiness, int food, int cleanliness, int health, int water) {
		super(petTag, name, happiness, food, cleanliness, health, water);
	}

	public void walk() {
		happiness = happiness + 1;
		cleanliness = cleanliness + 1;
		food = food - 1;
		water = water - 1;
		setHealth();

	}

}
