
public class Pet {

	protected String petTag;
	protected String name;
	protected int boredom;
	protected int food;
	protected int cleanliness;
	protected int health;

	public Pet() {
	}

	public Pet(String petTag, String name, int boredom, int food, int cleanliness, int health) {
		// TODO Auto-generated constructor stub
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

	public int getBoredom() {
		return boredom;
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

	public void play() {
		boredom = boredom +1;
	}

	public void feed() {
		food = food +1;	
	}

	public void clean() {
	cleanliness = cleanliness +1;
	}

}