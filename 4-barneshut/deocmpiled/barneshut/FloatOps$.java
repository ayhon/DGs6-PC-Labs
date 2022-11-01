package barneshut;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import scala.Tuple2;
import scala.collection.IterableOnce;
import scala.collection.IterableOnceOps;
import scala.collection.Seq;
import scala.runtime.ModuleSerializationProxy;

public final class FloatOps$ implements Serializable {
  private static final double precisionThreshold;
  
  private Object writeReplace() {
    return new ModuleSerializationProxy(FloatOps$.class);
  }
  
  public static final FloatOps$ MODULE$ = new FloatOps$();
  
  static {
    precisionThreshold = 1.0E-4D;
  }
  
  public double precisionThreshold() {
    return precisionThreshold;
  }
  
  public boolean $tilde$eq(float self, float that) {
    return (scala.math.package$.MODULE$.abs(self - that) < precisionThreshold());
  }
  
  public boolean $tilde$eq(double self, double that) {
    return (scala.math.package$.MODULE$.abs(self - that) < precisionThreshold());
  }
  
  public boolean $tilde$eq(Seq self, Seq that) {
    return (self.size() == that.size() && (
      (IterableOnceOps)self.zip((IterableOnce)that))
      
      .forall(x$1 -> {
          // Byte code:
          //   0: aload_1
          //   1: astore_2
          //   2: aload_2
          //   3: ifnull -> 50
          //   6: aload_2
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   13: fstore_3
          //   14: aload_2
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   21: fstore #4
          //   23: getstatic scala/math/package$.MODULE$ : Lscala/math/package$;
          //   26: fload_3
          //   27: fload #4
          //   29: fsub
          //   30: invokevirtual abs : (F)F
          //   33: f2d
          //   34: aload_0
          //   35: invokevirtual precisionThreshold : ()D
          //   38: dcmpg
          //   39: ifge -> 46
          //   42: iconst_1
          //   43: goto -> 47
          //   46: iconst_0
          //   47: goto -> 59
          //   50: new scala/MatchError
          //   53: dup
          //   54: aload_2
          //   55: invokespecial <init> : (Ljava/lang/Object;)V
          //   58: athrow
          //   59: ireturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #677	-> 0
          //   #678	-> 23
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	36	3	a	F
          //   23	27	4	b	F
          //   0	60	0	this	Lbarneshut/FloatOps$;
          //   0	60	1	x$1	Lscala/Tuple2;
        }));
  }
}
