
public class RoboticPet extends VirtualPet {

	protected boolean broken;

	public RoboticPet(String petTag, String name, int happiness, int food, int cleanliness, int health,
			boolean broken) {
		super(petTag, name, happiness, food, cleanliness, health);
		this.broken = broken;
	}

	public Object getBroken() {
		return broken;
	}

	public void breakdown() {
		broken = true;
	}

	public void repair() {
		broken = false;
	}
	
}