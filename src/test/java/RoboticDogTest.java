import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoboticDogTest {
RoboticDog underTest = new RoboticDog("1", "RobotCatName", 1, 0, 0, 10, 50);
	
	@Test
	public void shouldBeAbleToGetCatProperties() {
		String petTag = underTest.getPetTag();
		String name = underTest.getName();
		int boredom = underTest.getBoredom();
		int food = underTest.getFood();
		int water = underTest.getWater();
		int cleanliness = underTest.getCleanliness();
		int health = underTest.getHealth();
		assertThat (petTag, is("1"));
		assertThat (name, is("RobotCatName"));
		assertThat (boredom, is(1));
		assertThat (food, is(0));
		assertThat (water, is(0));
		assertThat (cleanliness, is(10));
		assertThat (health, is(50));
	}
	@Test
	public void shouldBeAbleToPlayWithDog() {
	underTest.play();
	assertThat (underTest.getBoredom(), is(2));
	}
	
	@Test
	public void shouldBeAbleToFeedDog() {
	underTest.feed();
	assertThat (underTest.getFood(), is(1));
	}
	
	@Test
	public void shouldBeAbleToWaterDog() {
	underTest.water();
	assertThat (underTest.getWater(), is(1));
	}
	
	@Test
	public void shouldBeAbleToCleanDogCage() {
	underTest.clean();
	assertThat (underTest.getCleanliness(), is(11));
	}

}