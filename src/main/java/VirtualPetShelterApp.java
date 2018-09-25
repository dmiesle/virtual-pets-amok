import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter myShelter = new VirtualPetShelter();
		VirtualPetShelter notSheltered = new VirtualPetShelter();
		PetStatus myStatus = new PetStatus();
		ShelterResources myResource = new ShelterResources(0);
		String menuOption;

		RoboticDog pet1 = new RoboticDog("1234", "Bob", 5, 3, 10, 18, "A bit fluffy, but seems kind hearted", false);
		RoboticCat pet2 = new RoboticCat("1235", "Sally", 5, 3, 10, 18,"With wide eyes, constantly moving", false);
		OrganicCat pet3 = new OrganicCat("1236", "Fluffy", 5, 3, 10, 18,"Your run of the mill cat.", 3, 0);
		OrganicDog pet4 = new OrganicDog("1237", "Rolf", 5, 3, 10, 18,"A giant furry dog, who can play the piano", 3, 0);
		RoboticDog pet5 = new RoboticDog("1238", "Kirk", 5, 3, 10, 18, "Seems over confident for his size.",false);
		RoboticCat pet6 = new RoboticCat("1239", "Archer", 5, 3, 10, 18,"Runs around a lot", false);
		OrganicDog pet7 = new OrganicDog("1240", "Picard", 5, 3, 10, 18,"finds the highest thing in the room to sit on.", 3, 0);
		OrganicCat pet8 = new OrganicCat("1241", "Janeway", 5, 3, 10, 18, "likes to be by herself.", 3, 0);
		
		myShelter.intake(pet1);
		myShelter.intake(pet2);
		myShelter.intake(pet3);
		myShelter.intake(pet4);
		Collection<VirtualPet> pets = myShelter.getAllPets();

		notSheltered.intake(pet5);
		notSheltered.intake(pet6);
		notSheltered.intake(pet7);
		notSheltered.intake(pet8);
		Collection<VirtualPet> freepets = notSheltered.getAllPets();

		System.out.println("Congratulations! You just openned a pet shelter. Here are your pets:");
		System.out.println("Name\t|Hunger\t\t|Happiness");
		System.out.println("--------|---------------|---------------");
		for (VirtualPet pet : pets) {
			System.out.println(pet.getName() + "\t|" + myStatus.getHungerStatus(pet.getFood()) + "\t|"
					+ myStatus.getEntertainmentStatus(pet.getHappiness()));
		}
		System.out.println("\n\nWhat would you like to do?\n");
		do {
			System.out.println("1 - Check on your pets.");
			System.out.println("2 - Take Care of your Pets");
			System.out.println("3 - Take Care of your Shelter");
			System.out.println("4 - Play with a specific pet.");
			System.out.println("5 - Admit a new pet to the shelter");
			System.out.println("6 - Let someone adopt a pet");
			System.out.println("7 - Go out drinking and leave your pets to their own devices.");
			System.out.println("8 - Abandon your shelter and let the pets run wild.");
			menuOption = input.nextLine();
			if (menuOption.equals("1")) {
				System.out.println("Congratulations! You just openned a pet shelter. Here are your pets:");
				System.out.println("Name\t|Hunger\t\t|Happiness");
				System.out.println("--------|---------------|---------------");
				for (VirtualPet pet : pets) {
					System.out.println(pet.getName() + "\t|" + myStatus.getHungerStatus(pet.getFood()) + "\t|"
							+ myStatus.getEntertainmentStatus(pet.getHappiness()));
				}
			}

			else if (menuOption.equals("2")) {
				System.out.println("1 - Oil Your Robotic Pets");
				System.out.println("2 - Charge your Robotic Pets");
				System.out.println("3 - Feed your Living Pets");
				System.out.println("4 - Give your Living Pets water");
				System.out.println("5 - Take your Dogs for a walk");
				System.out.println("6 - Go back to the shelter");
			}

			else if (menuOption.equals("3")) {
				System.out.println("1 - Clean the dog cages");
				System.out.println("2 - Clean the shelter litter box");
				System.out.println("3 - Go back to the shelter");
			}

			else if (menuOption.equals("4")) {
				System.out.println("Which pet would you like to play with?(enter your pet's tag number");
				for (VirtualPet pet : pets) {
					System.out.println(pet.getName() + ", " + pet.getPetDescription() + ": " + pet.getPetTag());
				}
				String petChoice = input.nextLine();
				if (myResource.getLastChoice() == "entertained") {
					System.out.println("Your pet is not interested in playing right now.");
					break;
				}
				myShelter.trainOne(petChoice);
			}

			else if (menuOption.equals("5")) {
				if (myResource.getLastChoice() == "entertained") {
					System.out.println("Your pets are not learning anything more right now.");
					break;
				} else {
					myShelter.trainAll();
					myShelter.trainAll();
				}
			}

			else if (menuOption.equals("6")) {
				if (myResource.getLastChoice() == "rested") {
					System.out.println("Your pets are not interested in going back to sleep.");
					break;
				} else {
					myShelter.restAll();
					myShelter.restAll();
					myShelter.restAll();
				}
			}

			else if (menuOption.equals("7")) {
				if (pets.size() < 9) {

				} else
					System.out.println("Your Shelter is full, and cannot accept more pets.");

			} else if (menuOption.equals("8")) {
				if (freepets.size() != 8) {
	
				} else
					System.out.println("There are no pets currently available in your shelter.");
			}

			else if (menuOption.equals("9")) {
				myShelter.tickAll();
			} else {
				System.out.println(
						"The police show up on your door 20 minutes later and you are arrested for animal endangerment.");
				System.exit(0);
			}
			System.out.println("What else do you want to do?");
			myResource.setTickCount();

		} while (menuOption != "10");
		input.close();
	}

}
