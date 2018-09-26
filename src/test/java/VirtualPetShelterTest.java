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
	RoboticPet testRobotDog = new RoboticDog("1", "RobotDogName", 1, 2, 9, 0,"description1", false);
	RoboticCat testRobotCat = new RoboticCat("2", "RobotCatName", 1, 1, 9, 0, "description2",false);
	OrganicDog testOrganicDog = new OrganicDog("3", "OrganicDogName", 1, 1, 9, 0,"description3", 0, 1);
	OrganicCat testOrganicCat = new OrganicCat("4", "OrganicCatName", 1, 1, 9, 0,"description4", 0, 1);
	ShelterResources testResources = new ShelterResources(0);
	PetStatus testStatus = new PetStatus();

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
		underTest.adopt(testRobotDog.getPetTag());
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
		assertThat(testRobotDog.getCleanliness(), is(10));
		assertThat(testRobotCat.getCleanliness(), is(10));
		assertThat(testOrganicDog.getCleanliness(), is(9));
	}

	@Test
	public void shouldBeAbleToWalkAllDogs() {
		underTest.intake(testRobotDog);
		underTest.intake(testOrganicDog);
		underTest.intake(testRobotCat);
		underTest.walkAllDogs();
		assertThat(testRobotDog.getHappiness(), is(2));
		assertThat(testOrganicDog.getHappiness(), is(2));
		assertThat(testRobotCat.getHappiness(), is(1));

	}
	@Test
	public void shouldBeAbleToWaterAllOrganicPets() {
		underTest.intake(testRobotDog);
		underTest.intake(testOrganicDog);
		underTest.intake(testRobotCat);
		underTest.waterAllOrganics();
		assertThat(testOrganicDog.getWater(), is(1));

	}
	@Test
	public void shouldBeAbleToCleanAllDogCages() {
		underTest.intake(testRobotDog);
		underTest.intake(testOrganicDog);
		underTest.cleanDogCages();
		assertThat(testOrganicDog.getCleanliness(), is(10));
		assertThat(testRobotDog.getCleanliness(), is(9));
		
	}
	@Test
	public void shouldBeAbleToCleanShelterLitterBox() {
		testResources.emptyLitterBox();
		assertThat(testResources.getBoxLevel(), is (0));
	}
	
	@Test
	public void organicCatsShouldBeAbleToUseLitterBox() {
		int deposit = testOrganicCat.getWaste();
		testResources.depositInLitterBox(deposit);
		testOrganicCat.eliminateWaste();
		assertThat (testOrganicCat.getWaste(), is (0));
		assertThat (testResources.getBoxLevel(), is(1));
	}
	@Test
	public void shouldReturnFoodLevelof5() {
		underTest.intake(testRobotDog);
		VirtualPet foundPet = underTest.findPet("1");
		assertThat (foundPet.getFood(), is(2));
	}
	@Test
	public void shouldReturnhungerLevelOfHangry() {
		underTest.intake(testRobotDog);
		VirtualPet foundPet = underTest.findPet("1");
		assertThat (testStatus.getHungerStatus(foundPet.getFood()), is("Hangry"));
	}
}
