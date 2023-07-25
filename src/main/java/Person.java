import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Person implements Cloneable {
  boolean lovesJava;
  int yearOfBirth;
  String name;
  Address address;
  Integer int1;

  final private List<Integer> secretNumbers = new ArrayList<>(Arrays.asList(202));
  public List<Integer> getSecretNumbers() {
    return secretNumbers;
  }
  public List<Integer> getSecretNumbersCopy() {
    List<Integer> secretNumbersCopy = new ArrayList<>(secretNumbers);
    return secretNumbersCopy;
  }

  public Integer getInt1() {
    return int1;
  }

  public void setInt1(Integer int1) {
    this.int1 = int1;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public boolean isLovesJava() {
    return lovesJava;
  }

  public void setLovesJava(boolean lovesJava) {
    this.lovesJava = lovesJava;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override // Object/Person needs to implement Cloneable interface - else CloneNotSupportedException
  protected Object clone() throws CloneNotSupportedException {
    Person clonedPerson = null;
    clonedPerson = (Person) super.clone();
    // Very important:
    clonedPerson.setAddress(new Address()); // Or a clonedPerson.setAddress((Address) address.clone())
                                            // - in a try block, if it throws an exception
    return clonedPerson;
  }
}
