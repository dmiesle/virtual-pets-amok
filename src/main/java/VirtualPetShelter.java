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

}
