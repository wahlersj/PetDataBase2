/*
Jacob Wahlers
CSC 422 - Software Engineering
Assignment 2
*/

public class Pet {

  private String name;
  private int age;

  //creating a new pet in the system
  public pet(String name, in age) {
    super();
    this.name = name;
    this.age = age;
  }

  //get name
  public String getName() {
    return name;
  }

  //set name
  public void setName(String name) {
    this.name = name;
  }

  //set age
  public void setAge(int age) {
    this.age = age;
  }

  //how it will be formatted
  @Override
  public String toString() {
    String str = "";
    str = String.format("%5s%10s%9s%5d%5s\n", "|", name, "|", age, "|");
    return str;
  }
}
