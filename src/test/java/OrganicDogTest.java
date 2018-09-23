import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrganicDogTest {
	OrganicDog underTest = new OrganicDog("1", "OrgnanicDogName", 1, 1, 10, 0, 3, 0);

	@Test
	public void shouldBeAbleToGetDogProperties() {
		String petTag = underTest.getPetTag();
		String name = underTest.getName();
		int happiness = underTest.getHappiness();
		int food = underTest.getFood();
		int cleanliness = underTest.getCleanliness();
		int health = underTest.getHealth();
		int water = underTest.getWater();
		assertThat(petTag, is("1"));
		assertThat(name, is("OrgnanicDogName"));
		assertThat(happiness, is(1));
		assertThat(food, is(1));
		assertThat(water, is(3));
		assertThat(cleanliness, is(10));
		assertThat(health, is(0));
	}

	@Test
	public void shouldBeAbleToGiveDogWater() {
		underTest.water();
		assertThat(underTest.getWater(), is(4));

	}

	@Test
	public void shouldBeAbleToGiveDogWaterAndIncreaseHealth() {
		underTest.water();
		assertThat(underTest.getHealth(), is(16));

	}

	@Test
	public void shouldBeAbleToWalkDogAndIncreaseHappinessLevelAndCleanliness() {
		underTest.walk();
		assertThat(underTest.getHealth(), is(15));
		assertThat(underTest.getCleanliness(), is(11));
		assertThat(underTest.getFood(), is(0));
		assertThat(underTest.getWater(), is(2));
	}

}
