/*
Jacob Wahlers
CSC 422 - Software Engineering
Assignment 2
*/

public class runPetDatabase {

  //Array of pets
  static ArrayList<Pet> pets;

  //Main method
  public static void main(String[] args) {
    //Accepting a new pet
    Scanner sc = new Scanner(System.in);
    pets = new ArrayList<>();

    petList(pets, "petList.txt");
    int choice;

    do {
      menu();
      System.out.print("Choose one of the following: ");

      choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1 -> displayAllPets();
        case 2 -> addPets(pets, sc);
        case 3 -> searchName(sc);
        case 4 -> searchAge(sc);
        case 5 -> updatePetInfo(sc);
        case 6 -> removePet(sc);
        case 7 -> System.out.println("Thank you for using the Pet Database!");
        default -> System.out.println("Invalid choice!");
      }
    } while (choice != 5);

    sc.close();
  }

    private static void displayAllPets() {
    //header
    System.out.println("+--------------------------------------+");
    System.out.printf(
      "|%5s%5s%9s%10s%5s%5s\n",
      "ID",
      "|",
      "NAME",
      "|",
      "AGE",
      "|"
    );
    System.out.println("+--------------------------------------+");

    //setting parameters for rows
    int i = 0;
    for (Pet pet : pets) {
      System.out.printf("|%5d%5s", i, pet.toString());
      i++;
    }

    //is how the footer will display
    System.out.println("+--------------------------------------+");
    System.out.println((i) + " rows in set.");
  }
    private static void addPets(ArrayList<Pet> pets, Scanner sc) {
    int count = 0;
    String petStr = "";

    do {
      System.out.print(
        "add pet (name, age) or type done to return to main menu: "
      );
      String input;
      input = sc.nextLine();
      String[] data = input.split("\\s+");
      try {
        if (petStr.equalsIgnoreCase("done")) {
          break;
        }

        int age = Integer.parseInt(input.split("\\s+")[1]);
        //test for valid age

        if (age < 1 || age > 20) {
          System.out.println("Error: age is not within valid range.");
        } else {
          Pet p = new Pet(data[0], age);
          if (pets.size() < 5) {
            pets.add(p);
          } else {
            System.out.println("Error: Database is full");
            break;
          }
        }
      } catch (Exception e) {
        System.out.println("Error: " + input + " is not valid");
      }
      //pets.add(new Pet(data[0], age));
      count++;
    } while (!petStr.equalsIgnoreCase("done"));

    System.out.println(count + " pets added.");
  }
    private static void searchName(Scanner sc) {
    System.out.print("Enter name to search: ");
    String name = sc.nextLine();

    System.out.println("+--------------------------------------+");
    System.out.printf(
      "|%5s%5s%9s%10s%5s%5s\n",
      "ID",
      "|",
      "NAME",
      "|",
      "AGE",
      "|"
    );
    System.out.println("+--------------------------------------+");

    int i = 0;
    for (Pet pet : pets) {
      if (pet.getName().equalsIgnoreCase(name)) {
        System.out.printf("|%5d%5s", i, pet.toString());
        i++;
      }
    }
    System.out.println("+--------------------------------------+");
    System.out.println((i) + "rows in set.");
  }

  private static void searchAge(Scanner sc) {
    System.out.print("Enter age to search: ");
    int age = sc.nextInt();

    System.out.println("+--------------------------------------+");
    System.out.printf(
      "|%5s%5s%9s%10s%5s%5s\n",
      "ID",
      "|",
      "NAME",
      "|",
      "AGE",
      "|"
    );
    System.out.println("+--------------------------------------+");

    int i = 0;
    for (Pet pet : pets) {
      if (pet.getAge() == age) {
        System.out.printf("|%5d%5s", i, pet.toString());
        i++;
      }
    }
    System.out.println("+--------------------------------------+");
    System.out.println((i) + "rows in set.");
  }

  private static void updatePetInfo(Scanner sc) {
    displayAllPets();
    System.out.print("Enter ID of pet you want to update: ");

    int id = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter new name and new age: ");

    String petStr = sc.nextLine();
    String name = petStr.split("\\s+")[0];

    //change name
    int age = Integer.parseInt(petStr.split("\\s+")[1]);
    String prevName = pets.get(id).getName();

    //change age
    int prevAge = pets.get(id).getAge();
    pets.get(id).setName(name);
    pets.get(id).setAge(age);

    System.out.println(
      prevName + " " + prevAge + " changed to " + name + " " + age
    );
  }

  private static void removePet(Scanner scan) {
    displayAllPets();
    System.out.print("Enter ID of pet you want to remove: ");

    int id = scan.nextInt();
    scan.nextLine();

    String name = pets.get(id).getName();
    int age = pets.get(id).getAge();

    //delete pet by ID
    pets.remove(id);
    System.out.println(name + " " + age + " is removed.");
  }

  public static void menu() {
    System.out.println(
      """
      What would like to do?
      1) View all pets
      2) Add more pets
      3) Search pets by name
      4) Search pets by age
      5) Update an existing pet
      6) Remove an existing pet
      7) Exit program"""
    );
  }

  private static void petList(ArrayList<Pet> pets, String filename) {
    Scanner file;

    try {
      file = new Scanner(new File(filename));

      while (file.hasNextLine()) {
        String input = file.nextLine();
        String[] data = input.split(" ");

        //pet object
        Pet p = new Pet(data[0], Integer.parseInt(data[1]));
        //add pets
        pets.add(p);
      }
      file.close();
    } catch (FileNotFoundException e) {}
  }
}
