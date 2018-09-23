
public class VirtualPet {

	protected String petTag;
	protected String name;
	protected int happiness;
	protected int food;
	protected int cleanliness;
	protected int health;

	public VirtualPet() {
	}

	public VirtualPet(String petTag, String name, int happiness, int food, int cleanliness, int health) {
		this.petTag = petTag;
		this.name = name;
		this.happiness = happiness;
		this.food = food;
		this.cleanliness = cleanliness;
		this.health = health;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getPetTag() {
		return petTag;
	}

	public int getHappiness() {
		return happiness;
	}

	public int getFood() {
		return food;
	}

	public int getCleanliness() {
		return cleanliness;
	}

	public int getHealth() {
		return health;
	}
	public int setHealth() {
		health = food + happiness + cleanliness;
		return getHealth();
	}

	public void attend() {
		happiness = happiness + 1;
		setHealth();
	}

	public void feed() {
		food = food + 1;
		setHealth();
	}

	public void clean() {
		cleanliness = cleanliness + 1;
		setHealth();
	}

}