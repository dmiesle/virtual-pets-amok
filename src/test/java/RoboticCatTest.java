import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoboticCatTest {
	
	Pet underTest = new RoboticCat("1", "RobotCatName", 1, 0, 10, 50);
	
	@Test
	public void shouldBeAbleToGetCatProperties() {
		String petTag = underTest.getPetTag();
		String name = underTest.getName();
		int boredom = underTest.getBoredom();
		int food = underTest.getFood();
		int cleanliness = underTest.getCleanliness();
		int health = underTest.getHealth();
		assertThat (petTag, is("1"));
		assertThat (name, is("RobotCatName"));
		assertThat (boredom, is(1));
		assertThat (food, is(0));
		assertThat (cleanliness, is(10));
		assertThat (health, is(50));
	}
	@Test
	public void shouldBeAbleToPlayWithCat() {
	underTest.play();
	assertThat (underTest.getBoredom(), is(2));
	}
	
	@Test
	public void shouldBeAbleToFeedCat() {
	underTest.feed();
	assertThat (underTest.getFood(), is(1));
	}
	
	@Test
	public void shouldBeAbleToCleanCat() {
	underTest.clean();
	assertThat (underTest.getCleanliness(), is(11));
	}

}
