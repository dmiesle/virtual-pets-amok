
public class VirtualPet {

	protected String petTag;
	protected String name;
	protected int happiness;
	protected int food;
	protected int cleanliness;
	protected int health;
	private String petDescription;

	public VirtualPet() {
	}

	public VirtualPet(String petTag, String name, int happiness, int food, int cleanliness, int health,
			String petDescription) {
		this.petTag = petTag;
		this.name = name;
		this.happiness = happiness;
		this.food = food;
		this.cleanliness = cleanliness;
		this.health = health;
		this.petDescription = petDescription;

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

	public String getPetDescription() {
		return petDescription;
	}

	public int setHealth() {
		health = food + happiness + cleanliness;
		return getHealth();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void attend() {
		if (happiness < 4) {
		happiness += 1;}
		setHealth();
	}

	public void feed() {
		if (food <10) {
		food += 1;}
		setHealth();
	}

	public void clean() {
		cleanliness = 10;
		setHealth();
	}

	public void tick() {
		cleanliness -= 1;
		food -= 1;
		happiness -= 1;
	}
}