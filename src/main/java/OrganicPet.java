
public class OrganicPet extends VirtualPet {

	public int water;

	public OrganicPet() {

	}

	public OrganicPet(String petTag, String name, int happiness, int food, int cleanliness, int health, int water) {
		super(petTag, name, happiness, food, cleanliness, health);
		this.water = water;
	}

	public int getWater() {
		return water;
	}

	public void water() {
		water = water + 1;
		setHealth();
	
	}

	@Override
	public int setHealth() {
		health = food + happiness + cleanliness + water;
		return getHealth();
	}

}