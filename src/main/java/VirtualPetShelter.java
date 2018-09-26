import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> shelteredPets = new HashMap<>();

	public void intake(VirtualPet pet) {
		shelteredPets.put(pet.getPetTag(), pet);

	}

	public VirtualPet findPet(String petTag) {
		return shelteredPets.get(petTag);

	}

	public Collection<VirtualPet> getAllPets() {
		return shelteredPets.values();
	}

	public void adopt(String petTag) {
		shelteredPets.remove(shelteredPets.get(petTag), petTag);

	}

	public VirtualPet getPetClass() {
		return findPet(shelteredPets.getClass().getSuperclass().toString());

	}

	public Collection<VirtualPet> getAllRobots() {
		Collection<VirtualPet> roboticPets = new ArrayList<>();
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof RoboticPet) {
				roboticPets.add(shelteredPets);
			}
		}
		return roboticPets;

	}

	public Collection<VirtualPet> getAllOrganicPets() {
		Collection<VirtualPet> organicPets = new ArrayList<>();
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof OrganicPet) {
				organicPets.add(shelteredPets);
			}
		}
		return organicPets;

	}

	public void oilAllRobots() {
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof RoboticPet) {
				shelteredPets.clean();
			}
		}

	}

	public void walkAllDogs() {
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof Dog) {
				((Dog) shelteredPets).walk();
			}
		}

	}

	public void waterAllOrganics() {
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof OrganicPet) {
				((OrganicPet) shelteredPets).water();
			}
		}

	}

	public void cleanDogCages() {
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof OrganicDog) {
				((OrganicDog) shelteredPets).clean();
			}
		}
	}

	public void chargeAllRobots() {
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof RoboticPet) {
				((RoboticPet) shelteredPets).feed();
			}
		}
	}

	public void feedAllLivingPets() {
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof OrganicPet) {
				((OrganicPet) shelteredPets).feed();
			}
		}
	}

	public void cleanAllCages() {
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof OrganicDog) {
				((OrganicDog) shelteredPets).clean();
			}
		}
	}

	public void tickAll() {
		for (VirtualPet shelteredPets : shelteredPets.values()) {
			if (shelteredPets instanceof OrganicPet) {
				((OrganicPet) shelteredPets).eliminateWaste();
			}
			shelteredPets.tick();
		}

	}

}
