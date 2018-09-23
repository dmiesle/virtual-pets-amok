
public class OrganicPet extends VirtualPet {

	public int water;
	private int waste;

	public OrganicPet() {

	}

	public OrganicPet(String petTag, String name, int happiness, int food, int cleanliness, int health, int water, int waste) {
		super(petTag, name, happiness, food, cleanliness, health);
		this.water = water;
		this.waste = waste;
	}

	public int getWater() {
		return water;
	}

	public void water() {
		water = water + 1;
		setHealth();
	
	}
	public int getWaste() {
		return waste;
	}


	@Override
	public int setHealth() {
		health = food + happiness + cleanliness + water;
		return getHealth();
	}

}