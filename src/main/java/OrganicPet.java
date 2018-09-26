
public class OrganicPet extends VirtualPet {

	protected int water;
	protected int waste;

	public OrganicPet() {

	}

	public OrganicPet(String petTag, String name, int happiness, int food, int cleanliness, int health, String petDescription, int water, int waste) {
		super(petTag, name, happiness, food, cleanliness, health,petDescription);
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
	
	public void increaseWaste() {
		waste +=1;
		food -=1;
		water -=1;
		
	}
	
	public void eliminateWaste() {
		waste = 0;
		
	}


	@Override
	public int setHealth() {
		health = food + happiness + cleanliness + water;
		return getHealth();
	}
	@Override
	public void tick() {
		cleanliness -= 1;
		food -= 1;
		happiness -=1;
		water -= 1;
	}
}