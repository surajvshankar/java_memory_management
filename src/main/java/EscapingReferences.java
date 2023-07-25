import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class EscapingReferences {
  // Escaping References are a "bad thing" - when references escape an object to the code using this class / library.

  public static void main(String[] args) { // EscapingReferences() {
    Person p1 = new Person();
    List<Integer> secretNumbers = p1.getSecretNumbers();
    secretNumbers.add(505);
    System.out.println(p1.getSecretNumbers());

    Person p2 = new Person();
    List<Integer> secretNumbersCopy = p2.getSecretNumbersCopy();
    secretNumbersCopy.add(404);
    System.out.println(p2.getSecretNumbers());
    System.out.println(p2.getSecretNumbersCopy());

    Person p3 = new Person();
    Address a = new Address();
    p3.setAddress(a);
    Person p4 = new Person();
    p4.setAddress(a);

    Address p3A = p3.getAddress();
    p3A.setCity("San Jose");

    System.out.println(p3.getAddress().getCity());
    System.out.println(p4.getAddress().getCity());

    List<Person> persons = new ArrayList<>(Arrays.asList(p4));
    // a.setCity("Sunny");
    persons.get(0).getAddress().setCity("Sunny");
    System.out.println(persons.get(0).getAddress().getCity());

    List<Person> shallowCopy = List.copyOf(persons);
    // a.setCity("Not Sunny");
    persons.get(0).getAddress().setCity("Not Sunny");
    System.out.println(shallowCopy.get(0).getAddress().getCity());
    persons.add(new Person());
    //shallowCopy.add(new Person()); // Immutable object is modified
    System.out.printf("%d - %d%n", persons.size(), shallowCopy.size());

    List<Person> immutable = Collections.unmodifiableList(persons);
    persons.add(new Person());
    //immutable.add(new Person()); // Immutable object is modified
    System.out.printf("%d - %d%n", persons.size(), immutable.size());

    // Deep copies are done by Overriding the clone method (look in Persons)
    try {
      Person p5 = (Person) p4.clone();
      a.setCity("Directly");
      System.out.println(p4.getAddress().getCity());
      System.out.println(p5.getAddress().getCity());
      p4.getAddress().setCity("Finally");
      System.out.println(p4.getAddress().getCity());
      System.out.println(p5.getAddress().getCity());
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
}
