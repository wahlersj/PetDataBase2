/*
Jacob Wahlers
CSC 422 - Software Engineering
Assignment 2
*/

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properities;
import java.util.Scanner;

//creating class PetDatabase
public class PetDatabase {

  private String fileName;
  private ArrayList<Pet> pets;
  private int size;

  public PetDatabase() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter file name for pet data: ");
    this.fileName = sc.nextLine().trim();
    this.pets = new ArrayList<>();
    this.size = 0;
  }
   public void loadData() {
    Scanner fileReader;

    try {
      fileReader = new Scanner(new File(fileName));
      while (fileReader.hasNextLine()) {
        String line = fileReader.nextLine().trim();
        String[] data = line.split(",");

        String name = data[0];
        int age = Integer.parseInt(data[1]);
        this.pets.add(new Pet(name, age));
      }
      fileReader.close();
    } catch (FileNotFoundException fnfe) {
      System.out.println("Error: Cannot find " + fileName + ".\n");
      System.exit(1);
    }
  }
  //setting parameters for viewing of pets
  public void viewAllPets() {
    if (this.pets.isEmpty()) System.out.println(
      "Error: Sorry, there are no pets to show!\n"
    );
    else {
      System.out.println("+-----------------------+");
      System.out.printf("| %2s | %-10s | %3s |\n", "ID", "NAME", "AGE");
      System.out.println("+-----------------------+");

      for (int i = 0; i < size; i++) {
        System.out.printf(
          "| %2d | %-10s | %3d |\n",
          i,
          this.pets.get(i).getName(),
          this.pets.get(i).getAge()
        );
      }
      System.out.println(
        "+-----------------------+\n" + size + " rows in set.\n"
      );
    }
  }
  //setting parameters for adding new pets
  public void addNewPets() {
    Scanner sc = new Scanner(System.in);
    String line;

    do {
      System.out.print("add pet (name, age): ");
      line = sc.nextLine().trim();
      if (line.equalsIgnoreCase("done")) break;

      if (size >= 5) {
        System.out.println("Error: Database is full.\n");
        return;
      }

      String name;
      int age;
      while (
        line.split(" ").length != 2 ||
        isDigit(line.split(" ")[0]) ||
        (Integer.parseInt(line.split(" ")[1]) < 1 ||
          Integer.parseInt(line.split(" ")[1]) > 20)
      ) {
        if (line.split(" ").length != 2) {
          System.out.println("Error: " + line + " is not a valid input.");
          System.out.print("add pet (name, age): ");
          line = sc.nextLine().trim();
        }

        if (isDigit(line.split(" ")[0])) {
          System.out.println(
            "Error: " + line.split(" ")[0] + " is not a valid input."
          );
          System.out.print("add pet (name, age): ");
          line = sc.nextLine().trim();
        }

        if (
          Integer.parseInt(line.split(" ")[1]) < 1 ||
          Integer.parseInt(line.split(" ")[1]) > 20
        ) {
          System.out.println(
            "Error: " + line.split(" ")[1] + " is not a valid age."
          );
          System.out.print("add pet (name, age): ");
          line = sc.nextLine().trim();
        }
      }

      String[] data = line.split(" ");
      name = data[0];
      age = Integer.parseInt(data[1]);

      this.pets.add(new Pet(name, age));
      size++;
    } while (!line.equalsIgnoreCase("done"));

    System.out.println(size + " pets added.\n");
  }

//setting parameters for removing a pet
  public void removeAPet() {
    viewAllPets();

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the pet ID to remove: ");
    int Id = Integer.parseInt(sc.nextLine().trim());
    if (Id < 0 || Id > size) {
      System.out.println("Error: ID " + Id + " does not exist.\n");
    } else {
      String oldName = this.pets.get(Id).getName();
      int oldAge = this.pets.get(Id).getAge();

      this.pets.remove(Id);
      size--;
      System.out.println(oldName + " " + oldAge + " is removed.\n");
    }
  }

  public void writeToFile() {
    FileWriter fw;
    PrintWriter pw;

    try {
      fw = new FileWriter(new File(fileName));
      pw = new PrintWriter(fw);
      for (Pet pet : this.pets) {
        pw.write(pet.getName() + "," + pet.getAge() + System.lineSeparator());
      }

      pw.flush();
      fw.close();
      pw.close();
    } catch (IOException ex) {
      System.out.println(
        "Error: Writing to file " + fileName + " - " + ex.getMessage()
      );
    }
  }

  private boolean isDigit(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }
}
