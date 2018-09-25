
public class ShelterResources {

	public int litterBox;

	public ShelterResources(int litterBox) {
		this.litterBox = litterBox;
	}

	public void depositInLitterBox(int amount) {
		litterBox +=amount;
		
	}

	public Object getBoxLevel() {
		return litterBox;
	}

	public void emptyLitterBox() {
		litterBox = 0;
		
	}

}
