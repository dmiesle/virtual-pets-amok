
public class ShelterResources {

	public int litterBox;
	private int tickCount;

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

	public void setTickCount() {
		tickCount += 1;
		
	}
	public int getTickCount() {
		return tickCount;
	}

}
