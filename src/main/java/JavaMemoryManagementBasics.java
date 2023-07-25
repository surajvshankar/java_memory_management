public class JavaMemoryManagementBasics {
  public static void main(String[] args) {
    // Stack Memory: Primitives
    int x = 5;
    double y = 3;
    boolean b = true;
    final int xy = 3;

    // Stack and Heap: Reference - p, a (on stack) / Objects - Person(), Address() (on heap)
    Person p = new Person();
    Address a = new Address();

    // heap:
    a.setCity("Sunnyvale");
    a.setCountry("USA");
    a.setNumber("b1");
    a.setStreetName("Maude");
    a.setZipCode("94085");

    p.setLovesJava(true);
    p.setYearOfBirth(1977);
    p.setName("Suraj");

    // Connect the two - in heap.
    p.setAddress(a);


    final int s = 5;
    method(5);
    System.out.println(s);
  }

  static void method(int s) {
    // s received by value - therefore, No longer immutable == no longer "final"
    s = 3;
    System.out.println(s);
  }
}
