import java.util.ArrayList;
import java.util.Collection;
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

	public void adopt(VirtualPet pet) {
		shelteredPets.remove(pet.getPetTag(), pet);
		
	}

	public void oilAllRobots() {
		// TODO Auto-generated method stub
		
	}

	public VirtualPet getPetClass() {
		return findPet(shelteredPets.getClass().getSuperclass().toString());
		
	}

	public Collection<VirtualPet> getAllRobots() {
		Collection<VirtualPet> roboticPets = new ArrayList<>();
		for(VirtualPet shelteredPets: shelteredPets.values()) {
			if(shelteredPets instanceof RoboticPet){
				roboticPets.add(shelteredPets);
			}
		}
		return roboticPets;
		
	}

	public Collection<VirtualPet> getAllOrganicPets() {
		Collection<VirtualPet> organicPets = new ArrayList<>();
		for(VirtualPet shelteredPets: shelteredPets.values()) {
			if(shelteredPets instanceof OrganicPet){
				organicPets.add(shelteredPets);
			}
		}
		return organicPets;
		
	}

}
