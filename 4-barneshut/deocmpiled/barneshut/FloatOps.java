package barneshut;

import scala.collection.Seq;

public final class FloatOps {
  public static double precisionThreshold() {
    return FloatOps$.MODULE$.precisionThreshold();
  }
  
  public static boolean $tilde$eq(double paramDouble1, double paramDouble2) {
    return FloatOps$.MODULE$.$tilde$eq(paramDouble1, paramDouble2);
  }
  
  public static boolean $tilde$eq(float paramFloat1, float paramFloat2) {
    return FloatOps$.MODULE$.$tilde$eq(paramFloat1, paramFloat2);
  }
  
  public static boolean $tilde$eq(Seq<Object> paramSeq1, Seq<Object> paramSeq2) {
    return FloatOps$.MODULE$.$tilde$eq(paramSeq1, paramSeq2);
  }
}
