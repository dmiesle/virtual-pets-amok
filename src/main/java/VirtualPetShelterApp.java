import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	private static VirtualPet petIntake;
	private static String nextKey = "1238";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter myShelter = new VirtualPetShelter();
		PetStatus myStatus = new PetStatus();
		ShelterResources myResource = new ShelterResources(0);
		String menuOption;

		RoboticDog pet1 = new RoboticDog("1234", "Bob", 3, 3, 10, 18, "A bit fluffy, but seems kind hearted", false);
		RoboticCat pet2 = new RoboticCat("1235", "Sally", 3, 3, 10, 18, "With wide eyes, constantly moving", false);
		OrganicCat pet3 = new OrganicCat("1236", "Fluffy", 3, 3, 10, 18, "Your run of the mill cat.", 3, 0);
		OrganicDog pet4 = new OrganicDog("1237", "Rolf", 3, 3, 10, 18, "A giant furry dog, who can play the piano", 3,
				0);

		myShelter.intake(pet1);
		myShelter.intake(pet2);
		myShelter.intake(pet3);
		myShelter.intake(pet4);
		Collection<VirtualPet> pets = myShelter.getAllPets();

		System.out.println("Congratulations! You just openned a pet shelter. Here are your pets:");
		System.out.println("Name\t|Hunger\t|Happiness");
		System.out.println("--------|---------------|---------------");
		for (VirtualPet pet : pets) {
			System.out.println(pet.getName() + "\t|" + myStatus.getHungerStatus(pet.getFood()) + "\t\t|"
					+ myStatus.getHappinessStatus(pet.getHappiness()));
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
				System.out.println("Name\t|Hunger\t|Happiness");
				System.out.println("--------|---------------|---------------");
				for (VirtualPet pet : pets) {
					System.out.println(pet.getName() + "\t|" + myStatus.getHungerStatus(pet.getFood()) + "\t|"
							+ myStatus.getHappinessStatus(pet.getHappiness()));
				}
			}

			else if (menuOption.equals("2")) {
				System.out.println("1 - Oil Your Robotic Pets");
				System.out.println("2 - Charge your Robotic Pets");
				System.out.println("3 - Feed your Living Pets");
				System.out.println("4 - Give your Living Pets water");
				System.out.println("5 - Take your Dogs for a walk");
				System.out.println("6 - Go back to the shelter");
				String petCare = input.nextLine();
				if (petCare.equals("1")) {
					myShelter.oilAllRobots();
				} else if (petCare.equals("2")) {
					myShelter.chargeAllRobots();
				} else if (petCare.equals("3")) {
					myShelter.feedAllLivingPets();
				} else if (petCare.equals("4")) {
					myShelter.waterAllOrganics();
				} else if (petCare.equals("5")) {
					myShelter.walkAllDogs();
				} else {
					break;
				}
			}

			else if (menuOption.equals("3")) {
				System.out.println("1 - Clean the dog cages");
				System.out.println("2 - Clean the shelter litter box");
				System.out.println("3 - Go back to the shelter");
				String shelterCare = input.nextLine();
				if (shelterCare.equals("1")) {
					myShelter.cleanDogCages();
				} else if (shelterCare.equals("2")) {
					myResource.emptyLitterBox();
				} else
					break;
			}

			else if (menuOption.equals("4")) {
				System.out.println("Which pet would you like to play with?(enter your pet's tag number");
				for (VirtualPet pet : pets) {
					System.out.println(pet.getName() + ", " + pet.getPetDescription() + ": " + pet.getPetTag());
				}
				String petChoice = input.nextLine();
				myShelter.findPet(petChoice).attend();
			}

			else if (menuOption.equals("5")) {
				System.out.println("Provide a name for the pet you want to admit to the shelter");
				String petNameChoice = input.nextLine();
				System.out.println("Enter a description for the new pet:");
				String petDescriptionChoice = input.nextLine();
				System.out.println(
						"What type of pet would you like to adopt: Robotic Dog, Robotic Cat, Organic Dog, or Organic Cat");
				String petTypeChoice = input.nextLine();
				if (petTypeChoice.equalsIgnoreCase("Robotic Dog")) {
					petIntake = new RoboticDog(nextKey, petNameChoice, 5, 3, 10, 18, petDescriptionChoice, false);
				} else if (petTypeChoice.equalsIgnoreCase("Robotic Cat")) {
					petIntake = new RoboticCat(nextKey, petNameChoice, 5, 3, 10, 18, petDescriptionChoice, false);
				} else if (petTypeChoice.equalsIgnoreCase("Organic Dog")) {
					petIntake = new OrganicDog(nextKey, petNameChoice, 5, 3, 10, 18, petDescriptionChoice, 3, 0);
				} else if (petTypeChoice.equalsIgnoreCase("Organic Cat")) {
					petIntake = new OrganicCat(nextKey, petNameChoice, 5, 3, 10, 18, petDescriptionChoice, 3, 0);
				}

				nextKey += 1;
				myShelter.intake(petIntake);
			} else if (menuOption.equals("7")) {
				myShelter.tickAll();
			} else {
				System.out.println(
						"The police show up on your door 20 minutes later and you are arrested for animal endangerment.");
				System.exit(0);
			}
			System.out.println("What else do you want to do?");
			if (myResource.getTickCount() == 5) {
				myShelter.tickAll();
				for (VirtualPet pet : pets) {
					if (pet.getFood() < 0 || pet.getHappiness() < 0 || pet.getCleanliness() < 0
							|| pet.getHealth() < 10) {
						String deathNotice = ("Your pet " + pet.getName() + " has died.");
						myShelter.adopt(pet.getPetTag());
						System.out.println(deathNotice);
					}
					myResource.setTickCountBase();
				}
				myResource.setTickCount();

			}

		} while (menuOption != "8");
		input.close();
	}
}