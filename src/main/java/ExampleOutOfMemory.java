import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class ExampleOutOfMemory {
  public static void main(String[] args) {
//   slowerOption();
//   fasterOption();
   forHeapDumpAnalysis();
  }

  public static void forHeapDumpAnalysis() {
    // -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath:=/Users/surshank/Downloads/heapdump
    // Make heapdump dir.
    List<Person> persons = new ArrayList<>();
    int i = 0;
    while(true) {
      Person p = new Person();
      persons.add(p);
      if (i > 1000) { // This part of the code never reached, since i++ missing.
        persons = new ArrayList<>();
        i = 0;
      }
    }
  }

  public static void slowerOption() { // jvisualvm
    Map<Double, String> map = new HashMap<>();

    Random random = new Random();
    while (true) {
      map.put(Math.pow(random.nextDouble(), random.nextDouble()), "placeHolder");
    }
  }

  public static void fasterOption() {
   List<byte[]> list = new LinkedList<>(); // List is not a primitive type.
   int index = 1;

   while(true) {
     byte[] b = new byte[10 * 1024 * 1024]; // 10Mb
     list.add(b);
     Runtime runtime = Runtime.getRuntime();
     System.out.printf("[%3s] Available heap memory: %s%n", index++, runtime.freeMemory());
   }
 }
}
