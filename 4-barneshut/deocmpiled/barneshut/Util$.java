package barneshut;

import java.io.Serializable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicLong;
import scala.Function0;
import scala.collection.parallel.ForkJoinTaskSupport;
import scala.collection.parallel.ForkJoinTasks;
import scala.collection.parallel.Task;
import scala.runtime.ModuleSerializationProxy;

public final class Util$ implements Serializable {
  private Object writeReplace() {
    return new ModuleSerializationProxy(Util$.class);
  }
  
  public static final Util$ MODULE$ = new Util$();
  
  public ForkJoinTaskSupport trackingTaskSuport() {
    return new Util$$anon$1();
  }
  
  private static final class Util$$anon$1 extends ForkJoinTaskSupport implements Util.CallTracking, ForkJoinTasks {
    private final AtomicLong numberOfCalls_;
    
    public Util$$anon$1() {
      super(new ForkJoinPool(2));
      this.numberOfCalls_ = new AtomicLong(0L);
    }
    
    public long numberOfCalls() {
      return this.numberOfCalls_.get();
    }
    
    public Function0 execute(Task fjtask) {
      this.numberOfCalls_.incrementAndGet();
      return ForkJoinTasks.execute$(this, fjtask);
    }
    
    public Object executeAndWaitResult(Task task) {
      this.numberOfCalls_.incrementAndGet();
      return ForkJoinTasks.executeAndWaitResult$(this, task);
    }
  }
}
