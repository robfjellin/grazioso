import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static final ArrayList<Dog> dogList = new ArrayList<>();

    // Created a new array for the Monkey class to store the objects of type Monkey
    private static final ArrayList<Monkey> monkeyList = new ArrayList<>();
    static String[] monkeySpecies = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"};
    // Instance variables (if needed)

    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        // For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods
        // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

        Scanner scanner = new Scanner(System.in);
        char input;

        // Do-While loop used to accept an input from the user

        do {
            displayMenu();
            input = scanner.next().charAt(0);

            scanner.nextLine();

            switch (input) {
                case '1':
                    intakeNewDog(scanner);
                    break;
                case '2':
                    intakeNewMonkey(scanner);
                    break;
                case '3':
                    reserveAnimal(scanner);
                    break;
                case '4':
                case '5':
                case '6':
                    printAnimals(input);
                    break;
                case 'q':
                    System.out.println("Application terminated");
                    break;
                default:
                    System.out.println("Please enter a valid command");
                    break;
            }
        } while (input != 'q');
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");

    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Chip", "male", "5", "32.8", "02-14-2023", "United States", "intake", true, "United States", "11.8", "24.5", "15.4", "Orangutan");

        monkeyList.add(monkey1);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();

        // Loop that checks every Dog object if entered name matches an existing name

        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        System.out.println("What is " + name + "'s breed?");
        String breed = scanner.nextLine();
        System.out.println("What is " + name + "'s gender?");
        String gender = scanner.nextLine();
        System.out.println("What is " + name + "'s age?");
        String age = scanner.nextLine();
        System.out.println("What is " + name + "'s weight?");
        String weight = scanner.nextLine();
        System.out.println("When was " + name + " acquired?");
        String date = scanner.nextLine();
        System.out.println("Where was " + name + " acquired?");
        String location = scanner.nextLine();
        System.out.println("What is " + name + "'s training status?");
        String status = scanner.nextLine();
        System.out.println("Is " + name + " already reserved? Enter true or false");
        String temp = scanner.nextLine();
        boolean reserved = Boolean.parseBoolean(temp);
        System.out.println("What country will " + name + " be serviced in?");
        String country = scanner.nextLine();

        System.out.println(name + " has been added to the database. \nPress Enter to return to the main menu.");
        scanner.nextLine();




        // Creating new object of class Dog using the inputs from the user and adding it to the dogList array

        Dog dog = new Dog(name, breed, gender, age, weight, date, location, status, reserved, country);
        dogList.add(dog);

    }


    // Complete intakeNewMonkey
    //Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also  validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        boolean isTrue = true;

        // Reused input validation from intakeNewDog.
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("This monkey is already in our system.");
                return;
            }
        }
        System.out.println("Is " + name + " a male or female?");
        String gender = scanner.nextLine();
        while (isTrue) {
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                isTrue = false;
            } else {
                System.out.println("Please enter a valid gender!");
                gender = scanner.nextLine();
            }
        }

        isTrue = true;
        // Implemented species validation to check if user input a valid species
        System.out.println("What is " + name + " species?");
        String species = scanner.nextLine();

        while (isTrue) {
            boolean isValidSpecies = false;
            for (String validSpecies : monkeySpecies) {
                if (species.equalsIgnoreCase(validSpecies)) {
                    isValidSpecies = true;
                    break;
                }
            }
            if (isValidSpecies) {
                isTrue = false;
            } else {
                System.out.println("That is not a valid species! Enter a valid species");
                species = scanner.nextLine();
            }
        }


        System.out.println("What is " + name + "'s age?");
        String age = scanner.nextLine();
        System.out.println("What is " + name + "'s weight");
        String weight = scanner.nextLine();
        System.out.println("When was " + name + " acquired?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Where was " + name + " acquired?");
        String acquisitionLocation = scanner.nextLine();
        System.out.println("What is " + name + "'s training status?");
        String trainingStatus = scanner.nextLine();

        // Converted input to boolean
        System.out.println("Is " + name + " reserved? Enter true or false.");
        String temp = scanner.nextLine();
        boolean reserved = Boolean.parseBoolean(temp);
        System.out.println("What country will " + name + " be serviced in?");
        String inServiceLocation = scanner.nextLine();
        System.out.println("How long is " + name + "'s tail?");
        String tailLength = scanner.nextLine();
        System.out.println("How tall is " + name + "?");
        String height = scanner.nextLine();
        System.out.println("What is " + name + " body length?");
        String bodyLength = scanner.nextLine();

        // Tried out adding an "Enter to continue." Might implement throughout all code.
        System.out.println(name + " has been added to the database. \nPress Enter to continue.");
        scanner.nextLine();

        // Creating new monkey object
        Monkey monkey = new Monkey(name, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus, reserved, inServiceLocation,tailLength, height, bodyLength, species);

        // Setting animalType to monkey manually
        monkey.setAnimalType("monkey");

        // New Monkey object is being added to the monkeyList
        monkeyList.add(monkey);

    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Do you want to reserve a dog or a monkey?");
        String animalType = scanner.nextLine();
        if (!animalType.equalsIgnoreCase("dog") && !animalType.equalsIgnoreCase("monkey")) {
            System.out.println("Invalid command. Returning to main menu.");
            return;
        }
        System.out.println("Which in service country?");
        String country = scanner.nextLine();

        boolean animalFound = false;

        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                if (dog.getInServiceLocation().equalsIgnoreCase(country)) {
                    System.out.println(dog);
                    animalFound = true;
                }
            }
            if (!animalFound) {
                System.out.println("No dogs were found in that country.");
                return;
            }
        }
        else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceLocation().equalsIgnoreCase(country)) {
                    System.out.println(monkey);
                    animalFound = true;
                }
            }
            if (!animalFound) {
                System.out.println("No monkeys were found in that country.");
                return;
            }
        }
        System.out.println("Please enter the name of the animal you'd like to reserve");
        String name = scanner.nextLine();
        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                if (dog.getName().equalsIgnoreCase(name)) {
                    if (dog.getReserved()) {
                        System.out.println(name + " has already been reserved.");
                    } else {
                        dog.setReserved(true);
                        System.out.println(name + " has been reserved.");
                        break;
                    }
                }
            }
        } else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name)) {
                    if (monkey.getReserved()) {
                        System.out.println(name + " has already been reserved.");
                        return;
                    } else {
                        monkey.setReserved(true);
                        System.out.println(name + " has been reserved.");
                        break;
                    }
                }
            }
        }
    }

    // Complete printAnimals
    // Include the animal name, status, acquisition country and if the animal is reserved.
    // Remember that this method connects to three different menu items.
    // The printAnimals() method has three different outputs
    // based on the listType parameter
    // dog - prints the list of dogs
    // monkey - prints the list of monkeys
    // available - prints a combined list of all animals that are
    // fully trained ("in service") but not reserved
    // Remember that you only have to fully implement ONE of these lists.
    // The other lists can have a print statement saying "This option needs to be implemented".
    // To score "exemplary" you must correctly implement the "available" list.
    public static void printAnimals(char input) {
        if (input == '4') {
            for (Dog dog : dogList) {
                System.out.println(dog.toString());
            }
        }
        else if (input == '5') {
            for (Monkey monkey : monkeyList) {
                System.out.println(monkey);
            }
        }
        else if (input == '6') {
            for (Dog dog : dogList) {
                if (!dog.getReserved()) {
                    System.out.println(dog);
                }
            }
            for (Monkey monkey : monkeyList) {
                if (!monkey.getReserved()) {
                    System.out.println(monkey);
                }
            }
        }
    }
}

