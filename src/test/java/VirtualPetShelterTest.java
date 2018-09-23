import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest = new VirtualPetShelter();
	RoboticPet testRobotDog = new RoboticDog("1", "RobotDogName", 1, 1, 10, 0, false);
	RoboticCat testRobotCat = new RoboticCat("2", "RobotCatName", 1, 1, 10, 0, false);
	OrganicDog testOrganicDog = new OrganicDog("3", "OrganicDogName", 1, 1, 10, 0, 0);
	OrganicCat testOrganicCat = new OrganicCat("4", "OrganicCatName", 1, 1, 10, 0, 0);

	@Test
	public void shouldAddRoboticDogToShelter() {
		underTest.intake(testRobotDog);
		VirtualPet foundPet = underTest.findPet("1");
		assertThat(foundPet.getPetTag(), is("1"));
	}

	@Test
	public void shouldAddRoboticDogAndOrganicDogToShelter() {
		underTest.intake(testRobotDog);
		underTest.intake(testOrganicDog);
		Collection<VirtualPet> shelteredPets = underTest.getAllPets();
		assertThat(shelteredPets, containsInAnyOrder(testRobotDog, testOrganicDog));
	}

	@Test
	public void shouldAddRoboticDogAndOrganicDogToShelterAndAdoptRobotDog() {
		underTest.intake(testRobotDog);
		underTest.intake(testOrganicDog);
		Collection<VirtualPet> shelteredPets = underTest.getAllPets();
		assertThat(shelteredPets, containsInAnyOrder(testRobotDog, testOrganicDog));
		underTest.adopt(testRobotDog);
		assertThat(shelteredPets, not(contains(testRobotDog)));
	}

	@Test
	public void shouldBeAbleToGetPetClassOfOrganicDog() {
		assertThat(testOrganicDog, instanceOf(OrganicPet.class));

	}

	@Test
	public void shouldFindAllRobots() {
		underTest.intake(testRobotDog);
		underTest.intake(testOrganicDog);
		underTest.intake(testRobotCat);
		underTest.getAllRobots();
		Collection<VirtualPet> roboticPets = underTest.getAllRobots();
		assertThat(roboticPets, containsInAnyOrder(testRobotDog, testRobotCat));

	}
	@Test
	public void shouldFindAllOrganicPets() {
		underTest.intake(testRobotDog);
		underTest.intake(testOrganicDog);
		underTest.intake(testRobotCat);
		underTest.getAllOrganicPets();
		Collection<VirtualPet> organicPets = underTest.getAllOrganicPets();
		assertThat(organicPets, containsInAnyOrder(testOrganicDog));

	}

	@Test
	public void shouldBeAbleToOilAllRoboticPets() {
		underTest.intake(testRobotDog);
		underTest.intake(testOrganicDog);
		underTest.intake(testRobotCat);
		underTest.intake(testOrganicCat);
		underTest.oilAllRobots();
	}

}
