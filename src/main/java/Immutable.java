import java.util.ArrayList;
import java.util.List;


public class Immutable {
  private final int z = 5;
  private final List<Integer> list = new ArrayList<>(); // Not really immutable - contents of the List can change.

  // No setters possible here
  // Can be initialized with a constructor

  // Immutable objects - values can be changes - but will create a new object on the heap, every time.
  Integer wrapper; // Wrapper classes
  String str; // String pool

  public static void main(String[] args) {
    Integer wrapper1 = new Integer(5);
    Integer wrapper2 = new Integer(5);
    Integer wrapper3 = Integer.valueOf(5); // valueOf factory method that tries pooling.
    Integer wrapper4 = Integer.valueOf(5);
    String str1 = "hello";
    String str2 = "hello";
    Person p1 = new Person();
    Person p2 = new Person();

    System.out.println("Not pooled:");
    System.out.println(p1 == p2); // False
    System.out.println(p1.equals(p2)); // False
    System.out.println(wrapper1 == wrapper2); // False
    System.out.println(wrapper1.equals(wrapper2)); // TRUE

    passIt(wrapper3, wrapper4);

    System.out.println("Pooling (only for non-primitives / non-primitives == have a reference):");
    System.out.println(str1 == str2); // TRUE
    System.out.println(str1.equals(str2)); // TRUE
    System.out.println(wrapper3 == wrapper4); // True
    System.out.println(wrapper3.equals(wrapper4)); // True


    System.out.println("String by default pooled:");
    p1.setName("hello");
    System.out.println(str1 == p1.getName()); // True
    p1.setInt1(5);
    System.out.println(wrapper1 == p1.getInt1()); // False
    System.out.println(wrapper3 == p1.getInt1()); // True

    System.out.println("String force no-pooling using 'new'':");
    String str3 = new String("hello");
    System.out.println(str1 == str3); // False
    System.out.println(str1.equals(str3)); // TRUE
  }

  public static void passIt(Integer wrapper1, Integer wrapper2) {
    System.out.println("Received by value:");
    System.out.println(wrapper1 == wrapper2); // TRUE
    System.out.println(wrapper1.equals(wrapper2)); // TRUE
    wrapper2 = Integer.valueOf(3);
    System.out.println("After mutation:");
    System.out.println(wrapper1 == wrapper2); // False
    System.out.println(wrapper1.equals(wrapper2)); // False
  }
}
