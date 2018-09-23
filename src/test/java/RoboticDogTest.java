import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoboticDogTest {
	RoboticDog underTest = new RoboticDog("1", "RobotDogName", 1, 1, 10, 0);

	@Test
	public void shouldBeAbleToGetDogProperties() {
		String petTag = underTest.getPetTag();
		String name = underTest.getName();
		int happiness = underTest.getHappiness();
		int food = underTest.getFood();
		int cleanliness = underTest.getCleanliness();
		int health = underTest.getHealth();
		assertThat(petTag, is("1"));
		assertThat(name, is("RobotDogName"));
		assertThat(happiness, is(1));
		assertThat(food, is(1));
		assertThat(cleanliness, is(10));
		assertThat(health, is(0));
	}

	@Test
	public void shouldBeAbleToGetDogPetTag() {
		underTest.getPetTag();
		assertThat(underTest.getPetTag(), is("1"));
	}

	@Test
	public void shouldBeAbleToPlayWithDog() {
		underTest.attend();
		assertThat(underTest.getHappiness(), is(2));
	}

	@Test
	public void shouldBeAbleToChargeDog() {
		underTest.feed();
		assertThat(underTest.getFood(), is(2));
	}

	@Test
	public void shouldBeAbleToOilDog() {
		underTest.clean();
		assertThat(underTest.getCleanliness(), is(11));
	}
	
	@Test
	public void shouldBeAbleToIncreaseHealthByPlayingWithDog() {
		underTest.attend();
		assertThat(underTest.getHealth(), is(13));
	}
	@Test
	public void shouldBeAbleToWalkDogAndIncreaseHappinessLevelAndDecreaseCleanlinessFood() {
		underTest.walk();
		assertThat (underTest.getHealth(), is(11));
		assertThat (underTest.getCleanliness(), is(9));
		assertThat (underTest.getFood(), is (0));
	}

}