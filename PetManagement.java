/*
Jacob Wahlers
CSC 422 - Software Engineering
Assignment 2
*/

import java.util.Scanner;

public class PetManagement {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    PetDatabase petDB = new PetDatabase();
    int choice;

    System.out.println();
    do {
      printMenu();
      choice = Integer.parseInt(sc.nextLine().trim());
      switch (choice) {
        case 1: {
          System.out.println();
          petDB.viewAllPets();
          break;
        }
        case 2: {
          System.out.println();
          petDB.addNewPets();
          break;
        }
        case 3: {
          System.out.println();
          petDB.removeAPet();
          break;
        }
        case 4: {
          petDB.writeToFile();
          System.out.println("\nGoodbye!\n");
          System.exit(0);
        }
        default:
          System.out.println("\nInvalid choice!\n");
      }
    } while (choice != 4);
  }

  private static void printMenu() {
    System.out.print(
      "What would you like to do?\n" +
      "1. View all pets\n" +
      "2. Add new pets\n" +
      "3. Remove a pet\n" +
      "4. Exit program\n" +
      "Your choice: "
    );
  }
}
