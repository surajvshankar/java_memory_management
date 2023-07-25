import java.util.ArrayList;
import java.util.List;


public class GarbageCollection {
  public static void main(String[] args) {
    List<Integer> temporaryObject = new ArrayList<>();
    int i = 0;
    while(true) {
      temporaryObject.add(i++);
      if (i > 1000) {
        temporaryObject = new ArrayList<>(); // Release earlier object for GC.
        i = 0;
      }
    }
  }
  // -Xmx1024m - heap size
  // -XX:MaxMetaspaceSize=8m - Metaspace size  // NO initial size, uses what it needs, and grows as needed (by default).

  // -XX:+UseSerialGC
  // -XX:+UseParallelGC
  // -XX:+UseConcMarkSweepGC
  // -XX:+UseG1GC
  // -XX:+UseZGC
}
