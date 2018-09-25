
public class OrganicDog extends OrganicPet implements Dog {

	public OrganicDog(String petTag, String name, int happiness, int food, int cleanliness, int health, String petDescription, int water, int waste) {
		super(petTag, name, happiness, food, cleanliness, health,petDescription, water, waste);
	}

	@Override
	public void walk() {
		happiness += 1;
		cleanliness += 1;
		food -= 1;
		water -= 1;
		eliminateWaste();
		setHealth();

	}

}
