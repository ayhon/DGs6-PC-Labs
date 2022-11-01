package barneshut;

import scala.collection.parallel.ForkJoinTaskSupport;

public final class Util {
  public static ForkJoinTaskSupport trackingTaskSuport() {
    return Util$.MODULE$.trackingTaskSuport();
  }
  
  public static interface CallTracking {
    long numberOfCalls();
  }
}
