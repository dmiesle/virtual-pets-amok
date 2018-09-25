import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PetStatus {
	List<String> hungers = Arrays.asList("Dead\t", "Starving", "Hangry", "Hungry", "Peckish", "Satisified", "Content",
			"Full\t", "Stuffed", "Bloated", "Lethargic");

	public String getHungerStatus(int foodLevel) {
		return hungers.get(foodLevel);

	}

	List<String> entertainments = Arrays.asList("Bored\t", "Restless", "Happy\t", "Loved\t", "Overstimulated");

	public String getEntertainmentStatus(int entertained) {
		return entertainments.get(entertained);

	}

	List<String> rests = Arrays.asList("Delerious", "Exhausted", "Tired\t", "Rested\t", "Well Rested");

	public String getRestedStatus(int rested) {
		return rests.get(rested);

	}

	List<String> personalities = Arrays.asList("Basic\t", "Curios\t", "Big Appetited", "High Maintenance", "Lazy\t",
			"Laid-back");


	public String getPersonality() {
		Random randomNumber = new Random();
		return personalities.get(randomNumber.nextInt((5 - 0)+1));
	}
}