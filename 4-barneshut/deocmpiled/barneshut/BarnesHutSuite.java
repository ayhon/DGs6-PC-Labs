package barneshut;

import barneshut.conctrees.ConcBuffer;
import java.lang.invoke.SerializedLambda;
import munit.FunSuite;
import munit.Location;
import scala.;
import scala.$less$colon$less$;
import scala.Function0;
import scala.Function1;
import scala.Predef$;
import scala.Tuple2;
import scala.Tuple2$;
import scala.collection.IterableOnceOps;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqOps;
import scala.collection.Set$;
import scala.collection.immutable.List;
import scala.collection.immutable.Seq;
import scala.collection.parallel.ForkJoinTaskSupport;
import scala.collection.parallel.TaskSupport;
import scala.collection.parallel.package$;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.package;
import scala.concurrent.duration.package$;
import scala.package$;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

public class BarnesHutSuite extends FunSuite {
  private final Duration munitTimeout;
  
  public BarnesHutSuite() {
    test("Empty: center of mass should be the center of the cell", (Function0)this::$init$$$anonfun$1, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 17));
    test("Empty: mass should be 0", (Function0)this::$init$$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 22));
    test("Empty: total should be 0", (Function0)this::$init$$$anonfun$3, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 27));
    test("Leaf with 1 body", (Function0)this::$init$$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 37));
    test("Leaf with 2 bodies (2pts)", (Function0)this::$init$$$anonfun$5, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 49));
    test("Fork with 4 empty quadrants (2pts)", (Function0)this::$init$$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 64));
    test("Fork with 3 empty quadrants and 1 leaf (nw)", (Function0)this::$init$$$anonfun$7, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 81));
    test("Fork with 3 empty quadrants and 1 leaf (ne)", (Function0)this::$init$$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 98));
    test("Fork with 3 empty quadrants and 1 leaf (sw)", (Function0)this::$init$$$anonfun$9, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 114));
    test("Fork with 3 empty quadrants and 1 leaf (se)", (Function0)this::$init$$$anonfun$10, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 130));
    test("Fork with 4 leaves (2pts)", (Function0)this::$init$$$anonfun$11, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 149));
    test("Empty.insert(b) should return a Leaf with only that body (2pts)", (Function0)this::$init$$$anonfun$12, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 164));
    test("Leaf.insert(b) should return another Leaf if size < minimumSize (2pts)", (Function0)this::$init$$$anonfun$13, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 189));
    test("Leaf.insert(b) should return a new Fork if size > minimumSize (2pts)", (Function0)this::$init$$$anonfun$14, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 244));
    test("Fork.insert(b) should insert recursively in the appropriate quadrant (2pts)", (Function0)this::$init$$$anonfun$15, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 310));
    test("'insert' should work correctly on an empty cell with center (1,1) and size 2 (2pts)", (Function0)this::$init$$$anonfun$16, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 317));
    test("'insert' should work correctly on a leaf with center (1,1) and size 2 (2pts)", (Function0)this::$init$$$anonfun$17, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 327));
    test("'insert' should work correctly on a leaf with center (1,1) and size <= minimumSize (2pts)", (Function0)this::$init$$$anonfun$18, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 342));
    test("Body.updated should do nothing for Empty quad trees", (Function0)this::$init$$$anonfun$19, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 353));
    test("Body.updated should take bodies in a Leaf into account (2pts)", (Function0)this::$init$$$anonfun$20, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 366));
    test("Body.updated should not count the interaction with itself in a Leaf (2pts)", (Function0)this::$init$$$anonfun$21, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 380));
    test("Body.updated should recursively traverse a Fork close to it (2pts)", (Function0)this::$init$$$anonfun$22, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 403));
    test("Body.updated should consider a Fork as opaque if it is far away (2pts)", (Function0)this::$init$$$anonfun$23, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 426));
    test("'SectorMatrix.+=' should add a body at (25,47) to the correct bucket of a sector matrix of size 96 (2pts)", (Function0)this::$init$$$anonfun$24, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 442));
    test("'SectorMatrix.+=' should add a body at (25,47) to the correct bucket of a sector matrix of size 100 (2pts)", (Function0)this::$init$$$anonfun$25, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 456));
    test("'SectorMatrix.+=' should add a body at (64,27) to the correct bucket of a sector matrix of size 108 when the sector precision is 12 (2pts)", (Function0)this::$init$$$anonfun$26, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 469));
    test("'SectorMatrix.combine' should correctly combine two sector matrices of size 96 containing points: (12, 34), (23, 45), (56, 9), (8, 79), (5, 99) (2pts)", (Function0)this::$init$$$anonfun$27, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 497));
    test("'SectorMatrix.combine' should correctly combine two sector matrices of size 96 a that contain some points in the same sector (2pts)", (Function0)this::$init$$$anonfun$28, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 528));
    test("'updateBoundaries' should correctly update the boundary given a body at (3,5) (2pts)", (Function0)this::$init$$$anonfun$29, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 538));
    test("'updateBoundaries' should correctly update the boundary when invoked repeatedly with points in the range (0,0) to (100,100) (2pts)", (Function0)this::$init$$$anonfun$30, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 548));
    test("'mergeBoundaries' should correctly merge two boundaries (2pts)", (Function0)this::$init$$$anonfun$31, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 564));
    test("'computeSectorMatrix' should correctly add points to buckets given 7 points within a boundary of size 96 (2pts)", (Function0)this::$init$$$anonfun$32, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 582));
    test("'computeSectorMatrix' should correctly work given 5 points within a boundary of size 96 when some points map to the same sector (2pts)", (Function0)this::$init$$$anonfun$33, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 604));
    test("computeSectorMatrix should be parallel (2pts)", (Function0)this::$init$$$anonfun$34, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 622));
    test("updateBodies should correctly update all bodies wrt to a Quad (2pts)", (Function0)this::$init$$$anonfun$35, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 642));
    test("updateBodies should be parallel (2pts)", (Function0)this::$init$$$anonfun$36, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 657));
    this.munitTimeout = (Duration)(new package.DurationInt(package$.MODULE$.DurationInt(10))).seconds();
  }
  
  private final void $init$$$anonfun$1() {
    Empty quad = Empty$.MODULE$.apply(51.0F, 46.3F, 5.0F);
    assert(quad::$init$$$anonfun$37$$anonfun$1, quad::$init$$$anonfun$38$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 15));
    assert(quad::$init$$$anonfun$39$$anonfun$3, quad::$init$$$anonfun$40$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 16));
  }
  
  private static final boolean $init$$$anonfun$37$$anonfun$1(Empty quad$1) {
    return (quad$1.massX() == 51.0F);
  }
  
  private static final String $init$$$anonfun$38$$anonfun$2(Empty quad$2) {
    return (new StringBuilder(14)).append(quad$2.massX()).append(" should be 51f").toString();
  }
  
  private static final boolean $init$$$anonfun$39$$anonfun$3(Empty quad$3) {
    return (quad$3.massY() == 46.3F);
  }
  
  private static final String $init$$$anonfun$40$$anonfun$4(Empty quad$4) {
    return (new StringBuilder(16)).append(quad$4.massY()).append(" should be 46.3f").toString();
  }
  
  private final void $init$$$anonfun$2() {
    Empty quad = Empty$.MODULE$.apply(51.0F, 46.3F, 5.0F);
    assert(quad::$init$$$anonfun$41$$anonfun$1, quad::$init$$$anonfun$42$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 21));
  }
  
  private static final boolean $init$$$anonfun$41$$anonfun$1(Empty quad$5) {
    return (quad$5.mass() == 0.0F);
  }
  
  private static final String $init$$$anonfun$42$$anonfun$2(Empty quad$6) {
    return (new StringBuilder(13)).append(quad$6.mass()).append(" should be 0f").toString();
  }
  
  private final void $init$$$anonfun$3() {
    Empty quad = Empty$.MODULE$.apply(51.0F, 46.3F, 5.0F);
    assert(quad::$init$$$anonfun$43$$anonfun$1, quad::$init$$$anonfun$44$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 26));
  }
  
  private static final boolean $init$$$anonfun$43$$anonfun$1(Empty quad$7) {
    return (quad$7.total() == 0);
  }
  
  private static final String $init$$$anonfun$44$$anonfun$2(Empty quad$8) {
    return (new StringBuilder(12)).append(quad$8.total()).append(" should be 0").toString();
  }
  
  private final void $init$$$anonfun$4() {
    Body b = new Body(123.0F, 18.0F, 26.0F, 0.0F, 0.0F);
    Leaf quad = Leaf$.MODULE$.apply(17.5F, 27.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b })));
    assert(quad::$init$$$anonfun$45$$anonfun$1, quad::$init$$$anonfun$46$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 33));
    assert(quad::$init$$$anonfun$47$$anonfun$3, quad::$init$$$anonfun$48$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 34));
    assert(quad::$init$$$anonfun$49$$anonfun$5, quad::$init$$$anonfun$50$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 35));
    assert(quad::$init$$$anonfun$51$$anonfun$7, quad::$init$$$anonfun$52$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 36));
  }
  
  private static final boolean $init$$$anonfun$45$$anonfun$1(Leaf quad$9) {
    return FloatOps$.MODULE$.$tilde$eq(quad$9.mass(), 123.0F);
  }
  
  private static final String $init$$$anonfun$46$$anonfun$2(Leaf quad$10) {
    return (new StringBuilder(15)).append(quad$10.mass()).append(" should be 123f").toString();
  }
  
  private static final boolean $init$$$anonfun$47$$anonfun$3(Leaf quad$11) {
    return FloatOps$.MODULE$.$tilde$eq(quad$11.massX(), 18.0F);
  }
  
  private static final String $init$$$anonfun$48$$anonfun$4(Leaf quad$12) {
    return (new StringBuilder(14)).append(quad$12.massX()).append(" should be 18f").toString();
  }
  
  private static final boolean $init$$$anonfun$49$$anonfun$5(Leaf quad$13) {
    return FloatOps$.MODULE$.$tilde$eq(quad$13.massY(), 26.0F);
  }
  
  private static final String $init$$$anonfun$50$$anonfun$6(Leaf quad$14) {
    return (new StringBuilder(14)).append(quad$14.massY()).append(" should be 26f").toString();
  }
  
  private static final boolean $init$$$anonfun$51$$anonfun$7(Leaf quad$15) {
    return (quad$15.total() == 1);
  }
  
  private static final String $init$$$anonfun$52$$anonfun$8(Leaf quad$16) {
    return (new StringBuilder(12)).append(quad$16.total()).append(" should be 1").toString();
  }
  
  private final void $init$$$anonfun$5() {
    Body b1 = new Body(123.0F, 18.0F, 26.0F, 0.0F, 0.0F);
    Body b2 = new Body(524.5F, 14.5F, 25.5F, 0.0F, 0.0F);
    Leaf quad = Leaf$.MODULE$.apply(17.5F, 27.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b1, b2 })));
    assert(quad::$init$$$anonfun$53$$anonfun$1, quad::$init$$$anonfun$54$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 45));
    assert(quad::$init$$$anonfun$55$$anonfun$3, quad::$init$$$anonfun$56$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 46));
    assert(quad::$init$$$anonfun$57$$anonfun$5, quad::$init$$$anonfun$58$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 47));
    assert(quad::$init$$$anonfun$59$$anonfun$7, quad::$init$$$anonfun$60$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 48));
  }
  
  private static final boolean $init$$$anonfun$53$$anonfun$1(Leaf quad$17) {
    return FloatOps$.MODULE$.$tilde$eq(quad$17.mass(), 647.5F);
  }
  
  private static final String $init$$$anonfun$54$$anonfun$2(Leaf quad$18) {
    return (new StringBuilder(17)).append(quad$18.mass()).append(" should be 647.5f").toString();
  }
  
  private static final boolean $init$$$anonfun$55$$anonfun$3(Leaf quad$19) {
    return FloatOps$.MODULE$.$tilde$eq(quad$19.massX(), 15.164865F);
  }
  
  private static final String $init$$$anonfun$56$$anonfun$4(Leaf quad$20) {
    return (new StringBuilder(21)).append(quad$20.massX()).append(" should be 15.164865f").toString();
  }
  
  private static final boolean $init$$$anonfun$57$$anonfun$5(Leaf quad$21) {
    return FloatOps$.MODULE$.$tilde$eq(quad$21.massY(), 25.59498F);
  }
  
  private static final String $init$$$anonfun$58$$anonfun$6(Leaf quad$22) {
    return (new StringBuilder(20)).append(quad$22.massY()).append(" should be 25.59498f").toString();
  }
  
  private static final boolean $init$$$anonfun$59$$anonfun$7(Leaf quad$23) {
    return (quad$23.total() == 2);
  }
  
  private static final String $init$$$anonfun$60$$anonfun$8(Leaf quad$24) {
    return (new StringBuilder(12)).append(quad$24.total()).append(" should be 2").toString();
  }
  
  private final void $init$$$anonfun$6() {
    Empty nw = Empty$.MODULE$.apply(17.5F, 27.5F, 5.0F);
    Empty ne = Empty$.MODULE$.apply(22.5F, 27.5F, 5.0F);
    Empty sw = Empty$.MODULE$.apply(17.5F, 32.5F, 5.0F);
    Empty se = Empty$.MODULE$.apply(22.5F, 32.5F, 5.0F);
    Fork quad = Fork$.MODULE$.apply((Quad)nw, (Quad)ne, (Quad)sw, (Quad)se);
    assert(quad::$init$$$anonfun$61$$anonfun$1, quad::$init$$$anonfun$62$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 58));
    assert(quad::$init$$$anonfun$63$$anonfun$3, quad::$init$$$anonfun$64$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 59));
    assert(quad::$init$$$anonfun$65$$anonfun$5, quad::$init$$$anonfun$66$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 60));
    assert(quad::$init$$$anonfun$67$$anonfun$7, quad::$init$$$anonfun$68$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 61));
    assert(quad::$init$$$anonfun$69$$anonfun$9, quad::$init$$$anonfun$70$$anonfun$10, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 62));
    assert(quad::$init$$$anonfun$71$$anonfun$11, quad::$init$$$anonfun$72$$anonfun$12, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 63));
  }
  
  private static final boolean $init$$$anonfun$61$$anonfun$1(Fork quad$25) {
    return (quad$25.centerX() == 20.0F);
  }
  
  private static final String $init$$$anonfun$62$$anonfun$2(Fork quad$26) {
    return (new StringBuilder(14)).append(quad$26.centerX()).append(" should be 20f").toString();
  }
  
  private static final boolean $init$$$anonfun$63$$anonfun$3(Fork quad$27) {
    return (quad$27.centerY() == 30.0F);
  }
  
  private static final String $init$$$anonfun$64$$anonfun$4(Fork quad$28) {
    return (new StringBuilder(14)).append(quad$28.centerY()).append(" should be 30f").toString();
  }
  
  private static final boolean $init$$$anonfun$65$$anonfun$5(Fork quad$29) {
    return (quad$29.mass() == 0.0F);
  }
  
  private static final String $init$$$anonfun$66$$anonfun$6(Fork quad$30) {
    return (new StringBuilder(13)).append(quad$30.mass()).append(" should be 0f").toString();
  }
  
  private static final boolean $init$$$anonfun$67$$anonfun$7(Fork quad$31) {
    return (quad$31.massX() == 20.0F);
  }
  
  private static final String $init$$$anonfun$68$$anonfun$8(Fork quad$32) {
    return (new StringBuilder(14)).append(quad$32.massX()).append(" should be 20f").toString();
  }
  
  private static final boolean $init$$$anonfun$69$$anonfun$9(Fork quad$33) {
    return (quad$33.massY() == 30.0F);
  }
  
  private static final String $init$$$anonfun$70$$anonfun$10(Fork quad$34) {
    return (new StringBuilder(14)).append(quad$34.massY()).append(" should be 30f").toString();
  }
  
  private static final boolean $init$$$anonfun$71$$anonfun$11(Fork quad$35) {
    return (quad$35.total() == 0);
  }
  
  private static final String $init$$$anonfun$72$$anonfun$12(Fork quad$36) {
    return (new StringBuilder(12)).append(quad$36.total()).append(" should be 0").toString();
  }
  
  private final void $init$$$anonfun$7() {
    Body b = new Body(123.0F, 18.0F, 26.0F, 0.0F, 0.0F);
    Leaf nw = Leaf$.MODULE$.apply(17.5F, 27.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b })));
    Empty ne = Empty$.MODULE$.apply(22.5F, 27.5F, 5.0F);
    Empty sw = Empty$.MODULE$.apply(17.5F, 32.5F, 5.0F);
    Empty se = Empty$.MODULE$.apply(22.5F, 32.5F, 5.0F);
    Fork quad = Fork$.MODULE$.apply((Quad)nw, (Quad)ne, (Quad)sw, (Quad)se);
    assert(quad::$init$$$anonfun$73$$anonfun$1, quad::$init$$$anonfun$74$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 75));
    assert(quad::$init$$$anonfun$75$$anonfun$3, quad::$init$$$anonfun$76$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 76));
    assert(quad::$init$$$anonfun$77$$anonfun$5, quad::$init$$$anonfun$78$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 77));
    assert(quad::$init$$$anonfun$79$$anonfun$7, quad::$init$$$anonfun$80$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 78));
    assert(quad::$init$$$anonfun$81$$anonfun$9, quad::$init$$$anonfun$82$$anonfun$10, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 79));
    assert(quad::$init$$$anonfun$83$$anonfun$11, quad::$init$$$anonfun$84$$anonfun$12, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 80));
  }
  
  private static final boolean $init$$$anonfun$73$$anonfun$1(Fork quad$37) {
    return (quad$37.centerX() == 20.0F);
  }
  
  private static final String $init$$$anonfun$74$$anonfun$2(Fork quad$38) {
    return (new StringBuilder(14)).append(quad$38.centerX()).append(" should be 20f").toString();
  }
  
  private static final boolean $init$$$anonfun$75$$anonfun$3(Fork quad$39) {
    return (quad$39.centerY() == 30.0F);
  }
  
  private static final String $init$$$anonfun$76$$anonfun$4(Fork quad$40) {
    return (new StringBuilder(14)).append(quad$40.centerY()).append(" should be 30f").toString();
  }
  
  private static final boolean $init$$$anonfun$77$$anonfun$5(Fork quad$41) {
    return FloatOps$.MODULE$.$tilde$eq(quad$41.mass(), 123.0F);
  }
  
  private static final String $init$$$anonfun$78$$anonfun$6(Fork quad$42) {
    return (new StringBuilder(15)).append(quad$42.mass()).append(" should be 123f").toString();
  }
  
  private static final boolean $init$$$anonfun$79$$anonfun$7(Fork quad$43) {
    return FloatOps$.MODULE$.$tilde$eq(quad$43.massX(), 18.0F);
  }
  
  private static final String $init$$$anonfun$80$$anonfun$8(Fork quad$44) {
    return (new StringBuilder(14)).append(quad$44.massX()).append(" should be 18f").toString();
  }
  
  private static final boolean $init$$$anonfun$81$$anonfun$9(Fork quad$45) {
    return FloatOps$.MODULE$.$tilde$eq(quad$45.massY(), 26.0F);
  }
  
  private static final String $init$$$anonfun$82$$anonfun$10(Fork quad$46) {
    return (new StringBuilder(14)).append(quad$46.massY()).append(" should be 26f").toString();
  }
  
  private static final boolean $init$$$anonfun$83$$anonfun$11(Fork quad$47) {
    return (quad$47.total() == 1);
  }
  
  private static final String $init$$$anonfun$84$$anonfun$12(Fork quad$48) {
    return (new StringBuilder(12)).append(quad$48.total()).append(" should be 1").toString();
  }
  
  private final void $init$$$anonfun$8() {
    Body b = new Body(123.0F, 20.5F, 26.0F, 0.0F, 0.0F);
    Empty nw = Empty$.MODULE$.apply(17.5F, 27.5F, 5.0F);
    Leaf ne = Leaf$.MODULE$.apply(22.5F, 27.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b })));
    Empty sw = Empty$.MODULE$.apply(17.5F, 32.5F, 5.0F);
    Empty se = Empty$.MODULE$.apply(22.5F, 32.5F, 5.0F);
    Fork quad = Fork$.MODULE$.apply((Quad)nw, (Quad)ne, (Quad)sw, (Quad)se);
    assert(quad::$init$$$anonfun$85$$anonfun$1, quad::$init$$$anonfun$86$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 92));
    assert(quad::$init$$$anonfun$87$$anonfun$3, quad::$init$$$anonfun$88$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 93));
    assert(quad::$init$$$anonfun$89$$anonfun$5, quad::$init$$$anonfun$90$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 94));
    assert(quad::$init$$$anonfun$91$$anonfun$7, quad::$init$$$anonfun$92$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 95));
    assert(quad::$init$$$anonfun$93$$anonfun$9, quad::$init$$$anonfun$94$$anonfun$10, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 96));
    assert(quad::$init$$$anonfun$95$$anonfun$11, quad::$init$$$anonfun$96$$anonfun$12, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 97));
  }
  
  private static final boolean $init$$$anonfun$85$$anonfun$1(Fork quad$49) {
    return (quad$49.centerX() == 20.0F);
  }
  
  private static final String $init$$$anonfun$86$$anonfun$2(Fork quad$50) {
    return (new StringBuilder(14)).append(quad$50.centerX()).append(" should be 20f").toString();
  }
  
  private static final boolean $init$$$anonfun$87$$anonfun$3(Fork quad$51) {
    return (quad$51.centerY() == 30.0F);
  }
  
  private static final String $init$$$anonfun$88$$anonfun$4(Fork quad$52) {
    return (new StringBuilder(14)).append(quad$52.centerY()).append(" should be 30f").toString();
  }
  
  private static final boolean $init$$$anonfun$89$$anonfun$5(Fork quad$53) {
    return FloatOps$.MODULE$.$tilde$eq(quad$53.mass(), 123.0F);
  }
  
  private static final String $init$$$anonfun$90$$anonfun$6(Fork quad$54) {
    return (new StringBuilder(15)).append(quad$54.mass()).append(" should be 123f").toString();
  }
  
  private static final boolean $init$$$anonfun$91$$anonfun$7(Fork quad$55) {
    return FloatOps$.MODULE$.$tilde$eq(quad$55.massX(), 20.5F);
  }
  
  private static final String $init$$$anonfun$92$$anonfun$8(Fork quad$56) {
    return (new StringBuilder(14)).append(quad$56.massX()).append(" should be 18f").toString();
  }
  
  private static final boolean $init$$$anonfun$93$$anonfun$9(Fork quad$57) {
    return FloatOps$.MODULE$.$tilde$eq(quad$57.massY(), 26.0F);
  }
  
  private static final String $init$$$anonfun$94$$anonfun$10(Fork quad$58) {
    return (new StringBuilder(14)).append(quad$58.massY()).append(" should be 26f").toString();
  }
  
  private static final boolean $init$$$anonfun$95$$anonfun$11(Fork quad$59) {
    return (quad$59.total() == 1);
  }
  
  private static final String $init$$$anonfun$96$$anonfun$12(Fork quad$60) {
    return (new StringBuilder(12)).append(quad$60.total()).append(" should be 1").toString();
  }
  
  private final void $init$$$anonfun$9() {
    Body b = new Body(123.0F, 18.0F, 33.0F, 0.0F, 0.0F);
    Empty nw = Empty$.MODULE$.apply(17.5F, 27.5F, 5.0F);
    Empty ne = Empty$.MODULE$.apply(22.5F, 27.5F, 5.0F);
    Leaf sw = Leaf$.MODULE$.apply(17.5F, 32.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b })));
    Empty se = Empty$.MODULE$.apply(22.5F, 32.5F, 5.0F);
    Fork quad = Fork$.MODULE$.apply((Quad)nw, (Quad)ne, (Quad)sw, (Quad)se);
    assert(quad::$init$$$anonfun$97$$anonfun$1, quad::$init$$$anonfun$98$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 108));
    assert(quad::$init$$$anonfun$99$$anonfun$3, quad::$init$$$anonfun$100$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 109));
    assert(quad::$init$$$anonfun$101$$anonfun$5, quad::$init$$$anonfun$102$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 110));
    assert(quad::$init$$$anonfun$103$$anonfun$7, quad::$init$$$anonfun$104$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 111));
    assert(quad::$init$$$anonfun$105$$anonfun$9, quad::$init$$$anonfun$106$$anonfun$10, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 112));
    assert(quad::$init$$$anonfun$107$$anonfun$11, quad::$init$$$anonfun$108$$anonfun$12, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 113));
  }
  
  private static final boolean $init$$$anonfun$97$$anonfun$1(Fork quad$61) {
    return (quad$61.centerX() == 20.0F);
  }
  
  private static final String $init$$$anonfun$98$$anonfun$2(Fork quad$62) {
    return (new StringBuilder(14)).append(quad$62.centerX()).append(" should be 20f").toString();
  }
  
  private static final boolean $init$$$anonfun$99$$anonfun$3(Fork quad$63) {
    return (quad$63.centerY() == 30.0F);
  }
  
  private static final String $init$$$anonfun$100$$anonfun$4(Fork quad$64) {
    return (new StringBuilder(14)).append(quad$64.centerY()).append(" should be 30f").toString();
  }
  
  private static final boolean $init$$$anonfun$101$$anonfun$5(Fork quad$65) {
    return FloatOps$.MODULE$.$tilde$eq(quad$65.mass(), 123.0F);
  }
  
  private static final String $init$$$anonfun$102$$anonfun$6(Fork quad$66) {
    return (new StringBuilder(15)).append(quad$66.mass()).append(" should be 123f").toString();
  }
  
  private static final boolean $init$$$anonfun$103$$anonfun$7(Fork quad$67) {
    return FloatOps$.MODULE$.$tilde$eq(quad$67.massX(), 18.0F);
  }
  
  private static final String $init$$$anonfun$104$$anonfun$8(Fork quad$68) {
    return (new StringBuilder(14)).append(quad$68.massX()).append(" should be 18f").toString();
  }
  
  private static final boolean $init$$$anonfun$105$$anonfun$9(Fork quad$69) {
    return FloatOps$.MODULE$.$tilde$eq(quad$69.massY(), 33.0F);
  }
  
  private static final String $init$$$anonfun$106$$anonfun$10(Fork quad$70) {
    return (new StringBuilder(14)).append(quad$70.massY()).append(" should be 26f").toString();
  }
  
  private static final boolean $init$$$anonfun$107$$anonfun$11(Fork quad$71) {
    return (quad$71.total() == 1);
  }
  
  private static final String $init$$$anonfun$108$$anonfun$12(Fork quad$72) {
    return (new StringBuilder(12)).append(quad$72.total()).append(" should be 1").toString();
  }
  
  private final void $init$$$anonfun$10() {
    Body b = new Body(123.0F, 24.6F, 33.0F, 0.0F, 0.0F);
    Empty nw = Empty$.MODULE$.apply(17.5F, 27.5F, 5.0F);
    Empty ne = Empty$.MODULE$.apply(22.5F, 27.5F, 5.0F);
    Empty sw = Empty$.MODULE$.apply(17.5F, 32.5F, 5.0F);
    Leaf se = Leaf$.MODULE$.apply(22.5F, 32.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b })));
    Fork quad = Fork$.MODULE$.apply((Quad)nw, (Quad)ne, (Quad)sw, (Quad)se);
    assert(quad::$init$$$anonfun$109$$anonfun$1, quad::$init$$$anonfun$110$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 124));
    assert(quad::$init$$$anonfun$111$$anonfun$3, quad::$init$$$anonfun$112$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 125));
    assert(quad::$init$$$anonfun$113$$anonfun$5, quad::$init$$$anonfun$114$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 126));
    assert(quad::$init$$$anonfun$115$$anonfun$7, quad::$init$$$anonfun$116$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 127));
    assert(quad::$init$$$anonfun$117$$anonfun$9, quad::$init$$$anonfun$118$$anonfun$10, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 128));
    assert(quad::$init$$$anonfun$119$$anonfun$11, quad::$init$$$anonfun$120$$anonfun$12, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 129));
  }
  
  private static final boolean $init$$$anonfun$109$$anonfun$1(Fork quad$73) {
    return (quad$73.centerX() == 20.0F);
  }
  
  private static final String $init$$$anonfun$110$$anonfun$2(Fork quad$74) {
    return (new StringBuilder(14)).append(quad$74.centerX()).append(" should be 20f").toString();
  }
  
  private static final boolean $init$$$anonfun$111$$anonfun$3(Fork quad$75) {
    return (quad$75.centerY() == 30.0F);
  }
  
  private static final String $init$$$anonfun$112$$anonfun$4(Fork quad$76) {
    return (new StringBuilder(14)).append(quad$76.centerY()).append(" should be 30f").toString();
  }
  
  private static final boolean $init$$$anonfun$113$$anonfun$5(Fork quad$77) {
    return FloatOps$.MODULE$.$tilde$eq(quad$77.mass(), 123.0F);
  }
  
  private static final String $init$$$anonfun$114$$anonfun$6(Fork quad$78) {
    return (new StringBuilder(15)).append(quad$78.mass()).append(" should be 123f").toString();
  }
  
  private static final boolean $init$$$anonfun$115$$anonfun$7(Fork quad$79) {
    return FloatOps$.MODULE$.$tilde$eq(quad$79.massX(), 24.6F);
  }
  
  private static final String $init$$$anonfun$116$$anonfun$8(Fork quad$80) {
    return (new StringBuilder(14)).append(quad$80.massX()).append(" should be 18f").toString();
  }
  
  private static final boolean $init$$$anonfun$117$$anonfun$9(Fork quad$81) {
    return FloatOps$.MODULE$.$tilde$eq(quad$81.massY(), 33.0F);
  }
  
  private static final String $init$$$anonfun$118$$anonfun$10(Fork quad$82) {
    return (new StringBuilder(14)).append(quad$82.massY()).append(" should be 26f").toString();
  }
  
  private static final boolean $init$$$anonfun$119$$anonfun$11(Fork quad$83) {
    return (quad$83.total() == 1);
  }
  
  private static final String $init$$$anonfun$120$$anonfun$12(Fork quad$84) {
    return (new StringBuilder(12)).append(quad$84.total()).append(" should be 1").toString();
  }
  
  private final void $init$$$anonfun$11() {
    Body bnw = new Body(15.5F, 18.0F, 26.0F, 0.0F, 0.0F);
    Body bne = new Body(25.0F, 20.5F, 26.0F, 0.0F, 0.0F);
    Body bsw = new Body(99.5F, 18.0F, 33.0F, 0.0F, 0.0F);
    Body bse = new Body(123.0F, 24.6F, 33.0F, 0.0F, 0.0F);
    Leaf nw = Leaf$.MODULE$.apply(17.5F, 27.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { bnw })));
    Leaf ne = Leaf$.MODULE$.apply(22.5F, 27.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { bne })));
    Leaf sw = Leaf$.MODULE$.apply(17.5F, 32.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { bsw })));
    Leaf se = Leaf$.MODULE$.apply(22.5F, 32.5F, 5.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { bse })));
    Fork quad = Fork$.MODULE$.apply((Quad)nw, (Quad)ne, (Quad)sw, (Quad)se);
    assert(quad::$init$$$anonfun$121$$anonfun$1, quad::$init$$$anonfun$122$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 143));
    assert(quad::$init$$$anonfun$123$$anonfun$3, quad::$init$$$anonfun$124$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 144));
    assert(quad::$init$$$anonfun$125$$anonfun$5, quad::$init$$$anonfun$126$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 145));
    assert(quad::$init$$$anonfun$127$$anonfun$7, quad::$init$$$anonfun$128$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 146));
    assert(quad::$init$$$anonfun$129$$anonfun$9, quad::$init$$$anonfun$130$$anonfun$10, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 147));
    assert(quad::$init$$$anonfun$131$$anonfun$11, quad::$init$$$anonfun$132$$anonfun$12, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 148));
  }
  
  private static final boolean $init$$$anonfun$121$$anonfun$1(Fork quad$85) {
    return (quad$85.centerX() == 20.0F);
  }
  
  private static final String $init$$$anonfun$122$$anonfun$2(Fork quad$86) {
    return (new StringBuilder(14)).append(quad$86.centerX()).append(" should be 20f").toString();
  }
  
  private static final boolean $init$$$anonfun$123$$anonfun$3(Fork quad$87) {
    return (quad$87.centerY() == 30.0F);
  }
  
  private static final String $init$$$anonfun$124$$anonfun$4(Fork quad$88) {
    return (new StringBuilder(14)).append(quad$88.centerY()).append(" should be 30f").toString();
  }
  
  private static final boolean $init$$$anonfun$125$$anonfun$5(Fork quad$89) {
    return FloatOps$.MODULE$.$tilde$eq(quad$89.mass(), 263.0F);
  }
  
  private static final String $init$$$anonfun$126$$anonfun$6(Fork quad$90) {
    return (new StringBuilder(15)).append(quad$90.mass()).append(" should be 263f").toString();
  }
  
  private static final boolean $init$$$anonfun$127$$anonfun$7(Fork quad$91) {
    return FloatOps$.MODULE$.$tilde$eq(quad$91.massX(), 21.324333F);
  }
  
  private static final String $init$$$anonfun$128$$anonfun$8(Fork quad$92) {
    return (new StringBuilder(21)).append(quad$92.massX()).append(" should be 21.324333f").toString();
  }
  
  private static final boolean $init$$$anonfun$129$$anonfun$9(Fork quad$93) {
    return FloatOps$.MODULE$.$tilde$eq(quad$93.massY(), 31.922052F);
  }
  
  private static final String $init$$$anonfun$130$$anonfun$10(Fork quad$94) {
    return (new StringBuilder(21)).append(quad$94.massY()).append(" should be 31.922052f").toString();
  }
  
  private static final boolean $init$$$anonfun$131$$anonfun$11(Fork quad$95) {
    return (quad$95.total() == 4);
  }
  
  private static final String $init$$$anonfun$132$$anonfun$12(Fork quad$96) {
    return (new StringBuilder(12)).append(quad$96.total()).append(" should be 4").toString();
  }
  
  private final void $init$$$anonfun$12() {
    // Byte code:
    //   0: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   3: ldc_w 51.0
    //   6: ldc_w 46.3
    //   9: ldc_w 5.0
    //   12: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   15: astore_1
    //   16: new barneshut/Body
    //   19: dup
    //   20: ldc_w 3.0
    //   23: ldc_w 54.0
    //   26: ldc_w 46.0
    //   29: fconst_0
    //   30: fconst_0
    //   31: invokespecial <init> : (FFFFF)V
    //   34: astore_2
    //   35: aload_1
    //   36: aload_2
    //   37: invokevirtual insert : (Lbarneshut/Body;)Lbarneshut/Quad;
    //   40: astore_3
    //   41: aload_3
    //   42: astore #4
    //   44: aload #4
    //   46: instanceof barneshut/Leaf
    //   49: ifeq -> 233
    //   52: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   55: aload #4
    //   57: checkcast barneshut/Leaf
    //   60: invokevirtual unapply : (Lbarneshut/Leaf;)Lbarneshut/Leaf;
    //   63: astore #5
    //   65: aload #5
    //   67: invokevirtual _1 : ()F
    //   70: fstore #6
    //   72: aload #5
    //   74: invokevirtual _2 : ()F
    //   77: fstore #7
    //   79: aload #5
    //   81: invokevirtual _3 : ()F
    //   84: fstore #8
    //   86: aload #5
    //   88: invokevirtual _4 : ()Lscala/collection/Seq;
    //   91: astore #9
    //   93: fload #6
    //   95: fstore #10
    //   97: fload #7
    //   99: fstore #11
    //   101: fload #8
    //   103: fstore #12
    //   105: aload #9
    //   107: astore #13
    //   109: aload_0
    //   110: fload #10
    //   112: <illegal opcode> apply : (F)Lscala/Function0;
    //   117: fload #10
    //   119: <illegal opcode> apply : (F)Lscala/Function0;
    //   124: new munit/Location
    //   127: dup
    //   128: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   130: sipush #158
    //   133: invokespecial <init> : (Ljava/lang/String;I)V
    //   136: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   139: aload_0
    //   140: fload #11
    //   142: <illegal opcode> apply : (F)Lscala/Function0;
    //   147: fload #11
    //   149: <illegal opcode> apply : (F)Lscala/Function0;
    //   154: new munit/Location
    //   157: dup
    //   158: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   160: sipush #159
    //   163: invokespecial <init> : (Ljava/lang/String;I)V
    //   166: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   169: aload_0
    //   170: fload #12
    //   172: <illegal opcode> apply : (F)Lscala/Function0;
    //   177: fload #12
    //   179: <illegal opcode> apply : (F)Lscala/Function0;
    //   184: new munit/Location
    //   187: dup
    //   188: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   190: sipush #160
    //   193: invokespecial <init> : (Ljava/lang/String;I)V
    //   196: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   199: aload_0
    //   200: aload_2
    //   201: aload #13
    //   203: <illegal opcode> apply : (Lbarneshut/Body;Lscala/collection/Seq;)Lscala/Function0;
    //   208: aload #13
    //   210: <illegal opcode> apply : (Lscala/collection/Seq;)Lscala/Function0;
    //   215: new munit/Location
    //   218: dup
    //   219: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   221: sipush #161
    //   224: invokespecial <init> : (Ljava/lang/String;I)V
    //   227: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   230: goto -> 260
    //   233: aload_0
    //   234: ldc_w 'Empty.insert() should have returned a Leaf, was $inserted'
    //   237: aload_0
    //   238: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   241: new munit/Location
    //   244: dup
    //   245: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   247: sipush #163
    //   250: invokespecial <init> : (Ljava/lang/String;I)V
    //   253: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   256: athrow
    //   257: nop
    //   258: nop
    //   259: athrow
    //   260: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #152	-> 0
    //   #153	-> 0
    //   #154	-> 16
    //   #155	-> 35
    //   #156	-> 41
    //   #157	-> 44
    //   #157	-> 52
    //   #158	-> 65
    //   #159	-> 139
    //   #160	-> 169
    //   #161	-> 199
    //   #163	-> 233
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   97	136	10	centerX	F
    //   101	132	11	centerY	F
    //   105	128	12	size	F
    //   109	124	13	bodies	Lscala/collection/Seq;
    //   16	244	1	quad	Lbarneshut/Empty;
    //   35	225	2	b	Lbarneshut/Body;
    //   41	219	3	inserted	Lbarneshut/Quad;
    //   0	261	0	this	Lbarneshut/BarnesHutSuite;
  }
  
  private static final boolean $init$$$anonfun$133$$anonfun$1(float centerX$1) {
    return (centerX$1 == 51.0F);
  }
  
  private static final String $init$$$anonfun$134$$anonfun$2(float centerX$2) {
    return (new StringBuilder(14)).append(centerX$2).append(" should be 51f").toString();
  }
  
  private static final boolean $init$$$anonfun$135$$anonfun$3(float centerY$1) {
    return (centerY$1 == 46.3F);
  }
  
  private static final String $init$$$anonfun$136$$anonfun$4(float centerY$2) {
    return (new StringBuilder(16)).append(centerY$2).append(" should be 46.3f").toString();
  }
  
  private static final boolean $init$$$anonfun$137$$anonfun$5(float size$1) {
    return (size$1 == 5.0F);
  }
  
  private static final String $init$$$anonfun$138$$anonfun$6(float size$2) {
    return (new StringBuilder(13)).append(size$2).append(" should be 5f").toString();
  }
  
  private static final boolean $init$$$anonfun$139$$anonfun$7(Body b$1, Seq bodies$1) {
    SeqOps seqOps = Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b$1 }));
    if (bodies$1 == null) {
      if (seqOps != null);
    } else if (bodies$1.equals(seqOps)) {
    
    } 
  }
  
  private static final String $init$$$anonfun$140$$anonfun$8(Seq bodies$2) {
    return (new StringBuilder(38)).append(bodies$2).append(" should contain only the inserted body").toString();
  }
  
  private final void $init$$$anonfun$13() {
    // Byte code:
    //   0: new barneshut/Body
    //   3: dup
    //   4: ldc_w 26.0
    //   7: ldc_w 1.000002
    //   10: ldc_w 2.000003
    //   13: fconst_0
    //   14: fconst_0
    //   15: invokespecial <init> : (FFFFF)V
    //   18: astore_1
    //   19: new barneshut/Body
    //   22: dup
    //   23: ldc_w 35.0
    //   26: ldc_w 0.999999
    //   29: fconst_2
    //   30: fconst_0
    //   31: fconst_0
    //   32: invokespecial <init> : (FFFFF)V
    //   35: astore_2
    //   36: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   39: fconst_1
    //   40: fconst_2
    //   41: ldc_w 5.0E-6
    //   44: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   47: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   50: iconst_1
    //   51: anewarray barneshut/Body
    //   54: dup
    //   55: iconst_0
    //   56: aload_1
    //   57: aastore
    //   58: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   61: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   64: checkcast scala/collection/Seq
    //   67: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   70: astore_3
    //   71: aload_3
    //   72: aload_2
    //   73: invokevirtual insert : (Lbarneshut/Body;)Lbarneshut/Quad;
    //   76: astore #4
    //   78: aload #4
    //   80: astore #5
    //   82: aload #5
    //   84: instanceof barneshut/Leaf
    //   87: ifeq -> 170
    //   90: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   93: aload #5
    //   95: checkcast barneshut/Leaf
    //   98: invokevirtual unapply : (Lbarneshut/Leaf;)Lbarneshut/Leaf;
    //   101: astore #6
    //   103: aload #6
    //   105: invokevirtual _1 : ()F
    //   108: fstore #7
    //   110: aload #6
    //   112: invokevirtual _2 : ()F
    //   115: fstore #8
    //   117: aload #6
    //   119: invokevirtual _3 : ()F
    //   122: fstore #9
    //   124: aload #6
    //   126: invokevirtual _4 : ()Lscala/collection/Seq;
    //   129: astore #10
    //   131: aload #10
    //   133: astore #11
    //   135: aload_0
    //   136: aload_1
    //   137: aload_2
    //   138: aload #11
    //   140: <illegal opcode> apply : (Lbarneshut/Body;Lbarneshut/Body;Lscala/collection/Seq;)Lscala/Function0;
    //   145: aload #11
    //   147: <illegal opcode> apply : (Lscala/collection/Seq;)Lscala/Function0;
    //   152: new munit/Location
    //   155: dup
    //   156: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   158: sipush #177
    //   161: invokespecial <init> : (Ljava/lang/String;I)V
    //   164: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   167: goto -> 218
    //   170: aload_0
    //   171: new java/lang/StringBuilder
    //   174: dup
    //   175: ldc_w 17
    //   178: invokespecial <init> : (I)V
    //   181: aload #4
    //   183: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: ldc_w ' should be a Leaf'
    //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual toString : ()Ljava/lang/String;
    //   195: aload_0
    //   196: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   199: new munit/Location
    //   202: dup
    //   203: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   205: sipush #179
    //   208: invokespecial <init> : (Ljava/lang/String;I)V
    //   211: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   214: athrow
    //   215: nop
    //   216: nop
    //   217: athrow
    //   218: aload_0
    //   219: fconst_1
    //   220: invokestatic boxToFloat : (F)Ljava/lang/Float;
    //   223: aload #4
    //   225: invokevirtual centerX : ()F
    //   228: invokestatic boxToFloat : (F)Ljava/lang/Float;
    //   231: <illegal opcode> apply : ()Lscala/Function0;
    //   236: new munit/Location
    //   239: dup
    //   240: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   242: sipush #181
    //   245: invokespecial <init> : (Ljava/lang/String;I)V
    //   248: getstatic scala/$less$colon$less$.MODULE$ : Lscala/$less$colon$less$;
    //   251: invokevirtual refl : ()Lscala/$eq$colon$eq;
    //   254: invokevirtual assertEquals : (Ljava/lang/Object;Ljava/lang/Object;Lscala/Function0;Lmunit/Location;Lscala/$less$colon$less;)V
    //   257: aload_0
    //   258: fconst_2
    //   259: invokestatic boxToFloat : (F)Ljava/lang/Float;
    //   262: aload #4
    //   264: invokevirtual centerY : ()F
    //   267: invokestatic boxToFloat : (F)Ljava/lang/Float;
    //   270: <illegal opcode> apply : ()Lscala/Function0;
    //   275: new munit/Location
    //   278: dup
    //   279: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   281: sipush #182
    //   284: invokespecial <init> : (Ljava/lang/String;I)V
    //   287: getstatic scala/$less$colon$less$.MODULE$ : Lscala/$less$colon$less$;
    //   290: invokevirtual refl : ()Lscala/$eq$colon$eq;
    //   293: invokevirtual assertEquals : (Ljava/lang/Object;Ljava/lang/Object;Lscala/Function0;Lmunit/Location;Lscala/$less$colon$less;)V
    //   296: aload_0
    //   297: ldc_w 5.0E-6
    //   300: invokestatic boxToFloat : (F)Ljava/lang/Float;
    //   303: aload #4
    //   305: invokevirtual size : ()F
    //   308: invokestatic boxToFloat : (F)Ljava/lang/Float;
    //   311: <illegal opcode> apply : ()Lscala/Function0;
    //   316: new munit/Location
    //   319: dup
    //   320: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   322: sipush #183
    //   325: invokespecial <init> : (Ljava/lang/String;I)V
    //   328: getstatic scala/$less$colon$less$.MODULE$ : Lscala/$less$colon$less$;
    //   331: invokevirtual refl : ()Lscala/$eq$colon$eq;
    //   334: invokevirtual assertEquals : (Ljava/lang/Object;Ljava/lang/Object;Lscala/Function0;Lmunit/Location;Lscala/$less$colon$less;)V
    //   337: aload_0
    //   338: aload #4
    //   340: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   345: aload #4
    //   347: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   352: new munit/Location
    //   355: dup
    //   356: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   358: sipush #185
    //   361: invokespecial <init> : (Ljava/lang/String;I)V
    //   364: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   367: aload_0
    //   368: aload #4
    //   370: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   375: aload #4
    //   377: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   382: new munit/Location
    //   385: dup
    //   386: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   388: sipush #186
    //   391: invokespecial <init> : (Ljava/lang/String;I)V
    //   394: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   397: aload_0
    //   398: aload #4
    //   400: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   405: aload #4
    //   407: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   412: new munit/Location
    //   415: dup
    //   416: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   418: sipush #187
    //   421: invokespecial <init> : (Ljava/lang/String;I)V
    //   424: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   427: aload_0
    //   428: aload #4
    //   430: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   435: aload #4
    //   437: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   442: new munit/Location
    //   445: dup
    //   446: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   448: sipush #188
    //   451: invokespecial <init> : (Ljava/lang/String;I)V
    //   454: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   457: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #167	-> 0
    //   #168	-> 0
    //   #169	-> 19
    //   #171	-> 36
    //   #172	-> 71
    //   #174	-> 78
    //   #175	-> 82
    //   #176	-> 135
    //   #177	-> 145
    //   #176	-> 167
    //   #179	-> 170
    //   #181	-> 218
    //   #182	-> 257
    //   #183	-> 296
    //   #185	-> 337
    //   #186	-> 367
    //   #187	-> 397
    //   #188	-> 427
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   135	35	11	bodies	Lscala/collection/Seq;
    //   19	438	1	b1	Lbarneshut/Body;
    //   36	421	2	b2	Lbarneshut/Body;
    //   71	386	3	initialLeaf	Lbarneshut/Leaf;
    //   78	379	4	quad	Lbarneshut/Quad;
    //   0	458	0	this	Lbarneshut/BarnesHutSuite;
  }
  
  private static final boolean $init$$$anonfun$141$$anonfun$1(Body b1$1, Body b2$1, Seq bodies$3) {
    Object object = Set$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b1$1, b2$1 }));
    if (bodies$3.toSet() == null) {
      bodies$3.toSet();
      if (object != null);
    } else if (bodies$3.toSet().equals(object)) {
    
    } 
  }
  
  private static final String $init$$$anonfun$142$$anonfun$2(Seq bodies$4) {
    return (new StringBuilder(35)).append(bodies$4).append(" should contain only the two bodies").toString();
  }
  
  private static final double $init$$$anonfun$143$$anonfun$3() {
    return FloatOps$.MODULE$.precisionThreshold();
  }
  
  private static final double $init$$$anonfun$144$$anonfun$4() {
    return FloatOps$.MODULE$.precisionThreshold();
  }
  
  private static final double $init$$$anonfun$145$$anonfun$5() {
    return FloatOps$.MODULE$.precisionThreshold();
  }
  
  private static final boolean $init$$$anonfun$146$$anonfun$6(Quad quad$97) {
    return FloatOps$.MODULE$.$tilde$eq(quad$97.mass(), 61.0F);
  }
  
  private static final String $init$$$anonfun$147$$anonfun$7(Quad quad$98) {
    return (new StringBuilder(14)).append(quad$98.mass()).append(" should be 61f").toString();
  }
  
  private static final boolean $init$$$anonfun$148$$anonfun$8(Quad quad$99) {
    return FloatOps$.MODULE$.$tilde$eq(quad$99.massX(), 1.0000004F);
  }
  
  private static final String $init$$$anonfun$149$$anonfun$9(Quad quad$100) {
    return (new StringBuilder(21)).append(quad$100.massX()).append(" should be 1.0000004f").toString();
  }
  
  private static final boolean $init$$$anonfun$150$$anonfun$10(Quad quad$101) {
    return FloatOps$.MODULE$.$tilde$eq(quad$101.massY(), 2.0000012F);
  }
  
  private static final String $init$$$anonfun$151$$anonfun$11(Quad quad$102) {
    return (new StringBuilder(21)).append(quad$102.massY()).append(" should be 2.0000012f").toString();
  }
  
  private static final boolean $init$$$anonfun$152$$anonfun$12(Quad quad$103) {
    return (quad$103.total() == 2);
  }
  
  private static final String $init$$$anonfun$153$$anonfun$13(Quad quad$104) {
    return (new StringBuilder(12)).append(quad$104.total()).append(" should be 2").toString();
  }
  
  private final void $init$$$anonfun$14() {
    // Byte code:
    //   0: new barneshut/Body
    //   3: dup
    //   4: ldc_w 123.0
    //   7: ldc_w 18.0
    //   10: ldc_w 26.0
    //   13: fconst_0
    //   14: fconst_0
    //   15: invokespecial <init> : (FFFFF)V
    //   18: astore_1
    //   19: new barneshut/Body
    //   22: dup
    //   23: ldc_w 524.5
    //   26: ldc_w 24.5
    //   29: ldc_w 25.5
    //   32: fconst_0
    //   33: fconst_0
    //   34: invokespecial <init> : (FFFFF)V
    //   37: astore_2
    //   38: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   41: ldc_w 20.0
    //   44: ldc_w 30.0
    //   47: ldc_w 10.0
    //   50: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   53: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   56: iconst_1
    //   57: anewarray barneshut/Body
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   67: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   70: checkcast scala/collection/Seq
    //   73: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   76: astore_3
    //   77: aload_3
    //   78: aload_2
    //   79: invokevirtual insert : (Lbarneshut/Body;)Lbarneshut/Quad;
    //   82: astore #4
    //   84: aload #4
    //   86: astore #5
    //   88: aload #5
    //   90: instanceof barneshut/Fork
    //   93: ifeq -> 1044
    //   96: getstatic barneshut/Fork$.MODULE$ : Lbarneshut/Fork$;
    //   99: aload #5
    //   101: checkcast barneshut/Fork
    //   104: invokevirtual unapply : (Lbarneshut/Fork;)Lbarneshut/Fork;
    //   107: astore #6
    //   109: aload #6
    //   111: invokevirtual _1 : ()Lbarneshut/Quad;
    //   114: astore #7
    //   116: aload #6
    //   118: invokevirtual _2 : ()Lbarneshut/Quad;
    //   121: astore #8
    //   123: aload #6
    //   125: invokevirtual _3 : ()Lbarneshut/Quad;
    //   128: astore #9
    //   130: aload #6
    //   132: invokevirtual _4 : ()Lbarneshut/Quad;
    //   135: astore #10
    //   137: aload #7
    //   139: astore #11
    //   141: aload #8
    //   143: astore #12
    //   145: aload #9
    //   147: astore #13
    //   149: aload #10
    //   151: astore #14
    //   153: aload #11
    //   155: astore #15
    //   157: aload #15
    //   159: instanceof barneshut/Leaf
    //   162: ifeq -> 341
    //   165: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   168: aload #15
    //   170: checkcast barneshut/Leaf
    //   173: invokevirtual unapply : (Lbarneshut/Leaf;)Lbarneshut/Leaf;
    //   176: astore #16
    //   178: aload #16
    //   180: invokevirtual _1 : ()F
    //   183: fstore #17
    //   185: aload #16
    //   187: invokevirtual _2 : ()F
    //   190: fstore #18
    //   192: aload #16
    //   194: invokevirtual _3 : ()F
    //   197: fstore #19
    //   199: aload #16
    //   201: invokevirtual _4 : ()Lscala/collection/Seq;
    //   204: astore #20
    //   206: fload #17
    //   208: fstore #21
    //   210: fload #18
    //   212: fstore #22
    //   214: fload #19
    //   216: fstore #23
    //   218: aload #20
    //   220: astore #24
    //   222: aload_0
    //   223: fload #21
    //   225: <illegal opcode> apply : (F)Lscala/Function0;
    //   230: aload_0
    //   231: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   236: new munit/Location
    //   239: dup
    //   240: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   242: sipush #202
    //   245: invokespecial <init> : (Ljava/lang/String;I)V
    //   248: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   251: aload_0
    //   252: fload #22
    //   254: <illegal opcode> apply : (F)Lscala/Function0;
    //   259: aload_0
    //   260: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   265: new munit/Location
    //   268: dup
    //   269: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   271: sipush #203
    //   274: invokespecial <init> : (Ljava/lang/String;I)V
    //   277: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   280: aload_0
    //   281: fload #23
    //   283: <illegal opcode> apply : (F)Lscala/Function0;
    //   288: aload_0
    //   289: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   294: new munit/Location
    //   297: dup
    //   298: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   300: sipush #204
    //   303: invokespecial <init> : (Ljava/lang/String;I)V
    //   306: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   309: aload_0
    //   310: aload_1
    //   311: aload #24
    //   313: <illegal opcode> apply : (Lbarneshut/Body;Lscala/collection/Seq;)Lscala/Function0;
    //   318: <illegal opcode> apply : ()Lscala/Function0;
    //   323: new munit/Location
    //   326: dup
    //   327: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   329: sipush #205
    //   332: invokespecial <init> : (Ljava/lang/String;I)V
    //   335: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   338: goto -> 395
    //   341: aload_0
    //   342: new java/lang/StringBuilder
    //   345: dup
    //   346: ldc_w 34
    //   349: invokespecial <init> : (I)V
    //   352: ldc_w 'nw of the Fork, '
    //   355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload #11
    //   360: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   363: ldc_w ', should be a Leaf'
    //   366: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual toString : ()Ljava/lang/String;
    //   372: aload_0
    //   373: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   376: new munit/Location
    //   379: dup
    //   380: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   382: sipush #207
    //   385: invokespecial <init> : (Ljava/lang/String;I)V
    //   388: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   391: athrow
    //   392: nop
    //   393: nop
    //   394: athrow
    //   395: aload #12
    //   397: astore #25
    //   399: aload #25
    //   401: instanceof barneshut/Leaf
    //   404: ifeq -> 583
    //   407: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   410: aload #25
    //   412: checkcast barneshut/Leaf
    //   415: invokevirtual unapply : (Lbarneshut/Leaf;)Lbarneshut/Leaf;
    //   418: astore #26
    //   420: aload #26
    //   422: invokevirtual _1 : ()F
    //   425: fstore #27
    //   427: aload #26
    //   429: invokevirtual _2 : ()F
    //   432: fstore #28
    //   434: aload #26
    //   436: invokevirtual _3 : ()F
    //   439: fstore #29
    //   441: aload #26
    //   443: invokevirtual _4 : ()Lscala/collection/Seq;
    //   446: astore #30
    //   448: fload #27
    //   450: fstore #31
    //   452: fload #28
    //   454: fstore #32
    //   456: fload #29
    //   458: fstore #33
    //   460: aload #30
    //   462: astore #34
    //   464: aload_0
    //   465: fload #31
    //   467: <illegal opcode> apply : (F)Lscala/Function0;
    //   472: aload_0
    //   473: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   478: new munit/Location
    //   481: dup
    //   482: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   484: sipush #211
    //   487: invokespecial <init> : (Ljava/lang/String;I)V
    //   490: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   493: aload_0
    //   494: fload #32
    //   496: <illegal opcode> apply : (F)Lscala/Function0;
    //   501: aload_0
    //   502: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   507: new munit/Location
    //   510: dup
    //   511: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   513: sipush #212
    //   516: invokespecial <init> : (Ljava/lang/String;I)V
    //   519: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   522: aload_0
    //   523: fload #33
    //   525: <illegal opcode> apply : (F)Lscala/Function0;
    //   530: aload_0
    //   531: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   536: new munit/Location
    //   539: dup
    //   540: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   542: sipush #213
    //   545: invokespecial <init> : (Ljava/lang/String;I)V
    //   548: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   551: aload_0
    //   552: aload_2
    //   553: aload #34
    //   555: <illegal opcode> apply : (Lbarneshut/Body;Lscala/collection/Seq;)Lscala/Function0;
    //   560: <illegal opcode> apply : ()Lscala/Function0;
    //   565: new munit/Location
    //   568: dup
    //   569: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   571: sipush #214
    //   574: invokespecial <init> : (Ljava/lang/String;I)V
    //   577: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   580: goto -> 637
    //   583: aload_0
    //   584: new java/lang/StringBuilder
    //   587: dup
    //   588: ldc_w 34
    //   591: invokespecial <init> : (I)V
    //   594: ldc_w 'ne of the Fork, '
    //   597: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload #12
    //   602: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   605: ldc_w ', should be a Leaf'
    //   608: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual toString : ()Ljava/lang/String;
    //   614: aload_0
    //   615: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   618: new munit/Location
    //   621: dup
    //   622: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   624: sipush #216
    //   627: invokespecial <init> : (Ljava/lang/String;I)V
    //   630: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   633: athrow
    //   634: nop
    //   635: nop
    //   636: athrow
    //   637: aload #13
    //   639: astore #35
    //   641: aload #35
    //   643: instanceof barneshut/Empty
    //   646: ifeq -> 785
    //   649: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   652: aload #35
    //   654: checkcast barneshut/Empty
    //   657: invokevirtual unapply : (Lbarneshut/Empty;)Lbarneshut/Empty;
    //   660: astore #36
    //   662: aload #36
    //   664: invokevirtual _1 : ()F
    //   667: fstore #37
    //   669: aload #36
    //   671: invokevirtual _2 : ()F
    //   674: fstore #38
    //   676: aload #36
    //   678: invokevirtual _3 : ()F
    //   681: fstore #39
    //   683: fload #37
    //   685: fstore #40
    //   687: fload #38
    //   689: fstore #41
    //   691: fload #39
    //   693: fstore #42
    //   695: aload_0
    //   696: fload #40
    //   698: <illegal opcode> apply : (F)Lscala/Function0;
    //   703: aload_0
    //   704: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   709: new munit/Location
    //   712: dup
    //   713: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   715: sipush #220
    //   718: invokespecial <init> : (Ljava/lang/String;I)V
    //   721: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   724: aload_0
    //   725: fload #41
    //   727: <illegal opcode> apply : (F)Lscala/Function0;
    //   732: aload_0
    //   733: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   738: new munit/Location
    //   741: dup
    //   742: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   744: sipush #221
    //   747: invokespecial <init> : (Ljava/lang/String;I)V
    //   750: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   753: aload_0
    //   754: fload #42
    //   756: <illegal opcode> apply : (F)Lscala/Function0;
    //   761: aload_0
    //   762: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   767: new munit/Location
    //   770: dup
    //   771: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   773: sipush #222
    //   776: invokespecial <init> : (Ljava/lang/String;I)V
    //   779: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   782: goto -> 839
    //   785: aload_0
    //   786: new java/lang/StringBuilder
    //   789: dup
    //   790: ldc_w 36
    //   793: invokespecial <init> : (I)V
    //   796: ldc_w 'sw of the Fork, '
    //   799: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload #13
    //   804: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   807: ldc_w ', should be an Empty'
    //   810: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: invokevirtual toString : ()Ljava/lang/String;
    //   816: aload_0
    //   817: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   820: new munit/Location
    //   823: dup
    //   824: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   826: sipush #224
    //   829: invokespecial <init> : (Ljava/lang/String;I)V
    //   832: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   835: athrow
    //   836: nop
    //   837: nop
    //   838: athrow
    //   839: aload #14
    //   841: astore #43
    //   843: aload #43
    //   845: instanceof barneshut/Empty
    //   848: ifeq -> 987
    //   851: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   854: aload #43
    //   856: checkcast barneshut/Empty
    //   859: invokevirtual unapply : (Lbarneshut/Empty;)Lbarneshut/Empty;
    //   862: astore #44
    //   864: aload #44
    //   866: invokevirtual _1 : ()F
    //   869: fstore #45
    //   871: aload #44
    //   873: invokevirtual _2 : ()F
    //   876: fstore #46
    //   878: aload #44
    //   880: invokevirtual _3 : ()F
    //   883: fstore #47
    //   885: fload #45
    //   887: fstore #48
    //   889: fload #46
    //   891: fstore #49
    //   893: fload #47
    //   895: fstore #50
    //   897: aload_0
    //   898: fload #48
    //   900: <illegal opcode> apply : (F)Lscala/Function0;
    //   905: aload_0
    //   906: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   911: new munit/Location
    //   914: dup
    //   915: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   917: sipush #228
    //   920: invokespecial <init> : (Ljava/lang/String;I)V
    //   923: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   926: aload_0
    //   927: fload #49
    //   929: <illegal opcode> apply : (F)Lscala/Function0;
    //   934: aload_0
    //   935: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   940: new munit/Location
    //   943: dup
    //   944: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   946: sipush #229
    //   949: invokespecial <init> : (Ljava/lang/String;I)V
    //   952: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   955: aload_0
    //   956: fload #50
    //   958: <illegal opcode> apply : (F)Lscala/Function0;
    //   963: aload_0
    //   964: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   969: new munit/Location
    //   972: dup
    //   973: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   975: sipush #230
    //   978: invokespecial <init> : (Ljava/lang/String;I)V
    //   981: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   984: goto -> 1041
    //   987: aload_0
    //   988: new java/lang/StringBuilder
    //   991: dup
    //   992: ldc_w 36
    //   995: invokespecial <init> : (I)V
    //   998: ldc_w 'se of the Fork, '
    //   1001: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload #14
    //   1006: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1009: ldc_w ', should be an Empty'
    //   1012: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual toString : ()Ljava/lang/String;
    //   1018: aload_0
    //   1019: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   1022: new munit/Location
    //   1025: dup
    //   1026: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1028: sipush #232
    //   1031: invokespecial <init> : (Ljava/lang/String;I)V
    //   1034: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   1037: athrow
    //   1038: nop
    //   1039: nop
    //   1040: athrow
    //   1041: goto -> 1092
    //   1044: aload_0
    //   1045: new java/lang/StringBuilder
    //   1048: dup
    //   1049: ldc_w 17
    //   1052: invokespecial <init> : (I)V
    //   1055: aload #4
    //   1057: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1060: ldc_w ' should be a Fork'
    //   1063: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokevirtual toString : ()Ljava/lang/String;
    //   1069: aload_0
    //   1070: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   1073: new munit/Location
    //   1076: dup
    //   1077: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1079: sipush #234
    //   1082: invokespecial <init> : (Ljava/lang/String;I)V
    //   1085: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   1088: athrow
    //   1089: nop
    //   1090: nop
    //   1091: athrow
    //   1092: aload_0
    //   1093: getstatic scala/Float$.MODULE$ : Lscala/Float$;
    //   1096: aload #4
    //   1098: invokevirtual centerX : ()F
    //   1101: invokevirtual float2double : (F)D
    //   1104: ldc2_w 20.0
    //   1107: getstatic barneshut/FloatOps$.MODULE$ : Lbarneshut/FloatOps$;
    //   1110: invokevirtual precisionThreshold : ()D
    //   1113: aload_0
    //   1114: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   1119: new munit/Location
    //   1122: dup
    //   1123: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1125: sipush #236
    //   1128: invokespecial <init> : (Ljava/lang/String;I)V
    //   1131: invokevirtual assertEqualsDouble : (DDDLscala/Function0;Lmunit/Location;)V
    //   1134: aload_0
    //   1135: getstatic scala/Float$.MODULE$ : Lscala/Float$;
    //   1138: aload #4
    //   1140: invokevirtual centerY : ()F
    //   1143: invokevirtual float2double : (F)D
    //   1146: ldc2_w 30.0
    //   1149: getstatic barneshut/FloatOps$.MODULE$ : Lbarneshut/FloatOps$;
    //   1152: invokevirtual precisionThreshold : ()D
    //   1155: aload_0
    //   1156: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   1161: new munit/Location
    //   1164: dup
    //   1165: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1167: sipush #237
    //   1170: invokespecial <init> : (Ljava/lang/String;I)V
    //   1173: invokevirtual assertEqualsDouble : (DDDLscala/Function0;Lmunit/Location;)V
    //   1176: aload_0
    //   1177: aload #4
    //   1179: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   1184: aload #4
    //   1186: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   1191: new munit/Location
    //   1194: dup
    //   1195: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1197: sipush #240
    //   1200: invokespecial <init> : (Ljava/lang/String;I)V
    //   1203: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1206: aload_0
    //   1207: aload #4
    //   1209: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   1214: aload #4
    //   1216: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   1221: new munit/Location
    //   1224: dup
    //   1225: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1227: sipush #241
    //   1230: invokespecial <init> : (Ljava/lang/String;I)V
    //   1233: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1236: aload_0
    //   1237: aload #4
    //   1239: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   1244: aload #4
    //   1246: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   1251: new munit/Location
    //   1254: dup
    //   1255: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1257: sipush #242
    //   1260: invokespecial <init> : (Ljava/lang/String;I)V
    //   1263: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1266: aload_0
    //   1267: aload #4
    //   1269: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   1274: aload #4
    //   1276: <illegal opcode> apply : (Lbarneshut/Quad;)Lscala/Function0;
    //   1281: new munit/Location
    //   1284: dup
    //   1285: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1287: sipush #243
    //   1290: invokespecial <init> : (Ljava/lang/String;I)V
    //   1293: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1296: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #191	-> 0
    //   #192	-> 0
    //   #193	-> 19
    //   #195	-> 38
    //   #196	-> 77
    //   #198	-> 84
    //   #199	-> 88
    //   #199	-> 96
    //   #200	-> 109
    //   #200	-> 153
    //   #201	-> 157
    //   #201	-> 165
    //   #202	-> 178
    //   #203	-> 251
    //   #204	-> 280
    //   #205	-> 309
    //   #207	-> 341
    //   #209	-> 395
    //   #210	-> 399
    //   #210	-> 407
    //   #211	-> 420
    //   #212	-> 493
    //   #213	-> 522
    //   #214	-> 551
    //   #216	-> 583
    //   #218	-> 637
    //   #219	-> 641
    //   #219	-> 649
    //   #220	-> 662
    //   #221	-> 724
    //   #222	-> 753
    //   #224	-> 785
    //   #226	-> 839
    //   #227	-> 843
    //   #227	-> 851
    //   #228	-> 864
    //   #229	-> 926
    //   #230	-> 955
    //   #232	-> 987
    //   #227	-> 1041
    //   #234	-> 1044
    //   #236	-> 1092
    //   #237	-> 1134
    //   #240	-> 1176
    //   #241	-> 1206
    //   #242	-> 1236
    //   #243	-> 1266
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   210	131	21	centerX	F
    //   214	127	22	centerY	F
    //   218	123	23	size	F
    //   222	119	24	bodies	Lscala/collection/Seq;
    //   452	131	31	centerX	F
    //   456	127	32	centerY	F
    //   460	123	33	size	F
    //   464	119	34	bodies	Lscala/collection/Seq;
    //   687	98	40	centerX	F
    //   691	94	41	centerY	F
    //   695	90	42	size	F
    //   889	98	48	centerX	F
    //   893	94	49	centerY	F
    //   897	90	50	size	F
    //   141	903	11	nw	Lbarneshut/Quad;
    //   145	899	12	ne	Lbarneshut/Quad;
    //   149	895	13	sw	Lbarneshut/Quad;
    //   153	891	14	se	Lbarneshut/Quad;
    //   19	1277	1	b1	Lbarneshut/Body;
    //   38	1258	2	b2	Lbarneshut/Body;
    //   77	1219	3	initialLeaf	Lbarneshut/Leaf;
    //   84	1212	4	quad	Lbarneshut/Quad;
    //   0	1297	0	this	Lbarneshut/BarnesHutSuite;
  }
  
  private static final boolean $init$$$anonfun$154$$anonfun$1(float centerX$3) {
    return FloatOps$.MODULE$.$tilde$eq(centerX$3, 17.5F);
  }
  
  private final String $init$$$anonfun$155$$anonfun$2() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$156$$anonfun$3(float centerY$3) {
    return FloatOps$.MODULE$.$tilde$eq(centerY$3, 27.5F);
  }
  
  private final String $init$$$anonfun$157$$anonfun$4() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$158$$anonfun$5(float size$3) {
    return FloatOps$.MODULE$.$tilde$eq(size$3, 5.0F);
  }
  
  private final String $init$$$anonfun$159$$anonfun$6() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$160$$anonfun$7(Body b1$2, Seq bodies$5) {
    Object object = Set$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b1$2 }));
    if (bodies$5.toSet() == null) {
      bodies$5.toSet();
      if (object != null);
    } else if (bodies$5.toSet().equals(object)) {
    
    } 
  }
  
  private static final String $init$$$anonfun$161$$anonfun$8() {
    return "nw should contain the first body";
  }
  
  private static final boolean $init$$$anonfun$162$$anonfun$9(float centerX$4) {
    return FloatOps$.MODULE$.$tilde$eq(centerX$4, 22.5F);
  }
  
  private final String $init$$$anonfun$163$$anonfun$10() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$164$$anonfun$11(float centerY$4) {
    return FloatOps$.MODULE$.$tilde$eq(centerY$4, 27.5F);
  }
  
  private final String $init$$$anonfun$165$$anonfun$12() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$166$$anonfun$13(float size$4) {
    return FloatOps$.MODULE$.$tilde$eq(size$4, 5.0F);
  }
  
  private final String $init$$$anonfun$167$$anonfun$14() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$168$$anonfun$15(Body b2$2, Seq bodies$6) {
    Object object = Set$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b2$2 }));
    if (bodies$6.toSet() == null) {
      bodies$6.toSet();
      if (object != null);
    } else if (bodies$6.toSet().equals(object)) {
    
    } 
  }
  
  private static final String $init$$$anonfun$169$$anonfun$16() {
    return "ne should contain the second body";
  }
  
  private static final boolean $init$$$anonfun$170$$anonfun$17(float centerX$5) {
    return FloatOps$.MODULE$.$tilde$eq(centerX$5, 17.5F);
  }
  
  private final String $init$$$anonfun$171$$anonfun$18() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$172$$anonfun$19(float centerY$5) {
    return FloatOps$.MODULE$.$tilde$eq(centerY$5, 32.5F);
  }
  
  private final String $init$$$anonfun$173$$anonfun$20() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$174$$anonfun$21(float size$5) {
    return FloatOps$.MODULE$.$tilde$eq(size$5, 5.0F);
  }
  
  private final String $init$$$anonfun$175$$anonfun$22() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$176$$anonfun$23(float centerX$6) {
    return FloatOps$.MODULE$.$tilde$eq(centerX$6, 22.5F);
  }
  
  private final String $init$$$anonfun$177$$anonfun$24() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$178$$anonfun$25(float centerY$6) {
    return FloatOps$.MODULE$.$tilde$eq(centerY$6, 32.5F);
  }
  
  private final String $init$$$anonfun$179$$anonfun$26() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$180$$anonfun$27(float size$6) {
    return FloatOps$.MODULE$.$tilde$eq(size$6, 5.0F);
  }
  
  private final String $init$$$anonfun$181$$anonfun$28() {
    return assert$default$2();
  }
  
  private final String $init$$$anonfun$182$$anonfun$29() {
    return assertEqualsDouble$default$4();
  }
  
  private final String $init$$$anonfun$183$$anonfun$30() {
    return assertEqualsDouble$default$4();
  }
  
  private static final boolean $init$$$anonfun$184$$anonfun$31(Quad quad$105) {
    return FloatOps$.MODULE$.$tilde$eq(quad$105.mass(), 647.5F);
  }
  
  private static final String $init$$$anonfun$185$$anonfun$32(Quad quad$106) {
    return (new StringBuilder(17)).append(quad$106.mass()).append(" should be 647.5f").toString();
  }
  
  private static final boolean $init$$$anonfun$186$$anonfun$33(Quad quad$107) {
    return FloatOps$.MODULE$.$tilde$eq(quad$107.massX(), 23.265251F);
  }
  
  private static final String $init$$$anonfun$187$$anonfun$34(Quad quad$108) {
    return (new StringBuilder(21)).append(quad$108.massX()).append(" should be 23.265251f").toString();
  }
  
  private static final boolean $init$$$anonfun$188$$anonfun$35(Quad quad$109) {
    return FloatOps$.MODULE$.$tilde$eq(quad$109.massY(), 25.59498F);
  }
  
  private static final String $init$$$anonfun$189$$anonfun$36(Quad quad$110) {
    return (new StringBuilder(20)).append(quad$110.massY()).append(" should be 25.59498f").toString();
  }
  
  private static final boolean $init$$$anonfun$190$$anonfun$37(Quad quad$111) {
    return (quad$111.total() == 2);
  }
  
  private static final String $init$$$anonfun$191$$anonfun$38(Quad quad$112) {
    return (new StringBuilder(12)).append(quad$112.total()).append(" should be 2").toString();
  }
  
  private final void $init$$$anonfun$15() {
    // Byte code:
    //   0: new barneshut/Body
    //   3: dup
    //   4: ldc_w 123.0
    //   7: ldc_w 18.0
    //   10: ldc_w 26.0
    //   13: fconst_0
    //   14: fconst_0
    //   15: invokespecial <init> : (FFFFF)V
    //   18: astore_1
    //   19: new barneshut/Body
    //   22: dup
    //   23: ldc_w 524.5
    //   26: ldc_w 24.5
    //   29: ldc_w 25.5
    //   32: fconst_0
    //   33: fconst_0
    //   34: invokespecial <init> : (FFFFF)V
    //   37: astore_2
    //   38: new barneshut/Body
    //   41: dup
    //   42: ldc_w 245.0
    //   45: ldc_w 22.4
    //   48: ldc_w 41.0
    //   51: fconst_0
    //   52: fconst_0
    //   53: invokespecial <init> : (FFFFF)V
    //   56: astore_3
    //   57: getstatic barneshut/Fork$.MODULE$ : Lbarneshut/Fork$;
    //   60: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   63: ldc_w 10.0
    //   66: ldc_w 30.0
    //   69: ldc_w 10.0
    //   72: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   75: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   78: ldc_w 20.0
    //   81: ldc_w 30.0
    //   84: ldc_w 10.0
    //   87: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   90: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   93: iconst_1
    //   94: anewarray barneshut/Body
    //   97: dup
    //   98: iconst_0
    //   99: aload_1
    //   100: aastore
    //   101: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   104: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   107: checkcast scala/collection/Seq
    //   110: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   113: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   116: ldc_w 10.0
    //   119: ldc_w 40.0
    //   122: ldc_w 10.0
    //   125: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   128: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   131: ldc_w 20.0
    //   134: ldc_w 40.0
    //   137: ldc_w 10.0
    //   140: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   143: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   146: iconst_1
    //   147: anewarray barneshut/Body
    //   150: dup
    //   151: iconst_0
    //   152: aload_3
    //   153: aastore
    //   154: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   157: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   160: checkcast scala/collection/Seq
    //   163: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   166: invokevirtual apply : (Lbarneshut/Quad;Lbarneshut/Quad;Lbarneshut/Quad;Lbarneshut/Quad;)Lbarneshut/Fork;
    //   169: astore #4
    //   171: aload #4
    //   173: aload_2
    //   174: invokevirtual insert : (Lbarneshut/Body;)Lbarneshut/Fork;
    //   177: astore #5
    //   179: aload #5
    //   181: astore #6
    //   183: aload #6
    //   185: ifnull -> 1337
    //   188: getstatic barneshut/Fork$.MODULE$ : Lbarneshut/Fork$;
    //   191: aload #6
    //   193: invokevirtual unapply : (Lbarneshut/Fork;)Lbarneshut/Fork;
    //   196: astore #7
    //   198: aload #7
    //   200: invokevirtual _1 : ()Lbarneshut/Quad;
    //   203: astore #8
    //   205: aload #7
    //   207: invokevirtual _2 : ()Lbarneshut/Quad;
    //   210: astore #9
    //   212: aload #7
    //   214: invokevirtual _3 : ()Lbarneshut/Quad;
    //   217: astore #10
    //   219: aload #7
    //   221: invokevirtual _4 : ()Lbarneshut/Quad;
    //   224: astore #11
    //   226: aload #4
    //   228: invokevirtual nw : ()Lbarneshut/Quad;
    //   231: aload #8
    //   233: astore #12
    //   235: dup
    //   236: ifnonnull -> 248
    //   239: pop
    //   240: aload #12
    //   242: ifnull -> 256
    //   245: goto -> 1337
    //   248: aload #12
    //   250: invokevirtual equals : (Ljava/lang/Object;)Z
    //   253: ifeq -> 1337
    //   256: aload #9
    //   258: astore #13
    //   260: aload #4
    //   262: invokevirtual sw : ()Lbarneshut/Quad;
    //   265: aload #10
    //   267: astore #14
    //   269: dup
    //   270: ifnonnull -> 282
    //   273: pop
    //   274: aload #14
    //   276: ifnull -> 290
    //   279: goto -> 1337
    //   282: aload #14
    //   284: invokevirtual equals : (Ljava/lang/Object;)Z
    //   287: ifeq -> 1337
    //   290: aload #4
    //   292: invokevirtual se : ()Lbarneshut/Quad;
    //   295: aload #11
    //   297: astore #15
    //   299: dup
    //   300: ifnonnull -> 312
    //   303: pop
    //   304: aload #15
    //   306: ifnull -> 320
    //   309: goto -> 1337
    //   312: aload #15
    //   314: invokevirtual equals : (Ljava/lang/Object;)Z
    //   317: ifeq -> 1337
    //   320: aload #13
    //   322: astore #16
    //   324: aload #16
    //   326: instanceof barneshut/Fork
    //   329: ifeq -> 1280
    //   332: getstatic barneshut/Fork$.MODULE$ : Lbarneshut/Fork$;
    //   335: aload #16
    //   337: checkcast barneshut/Fork
    //   340: invokevirtual unapply : (Lbarneshut/Fork;)Lbarneshut/Fork;
    //   343: astore #17
    //   345: aload #17
    //   347: invokevirtual _1 : ()Lbarneshut/Quad;
    //   350: astore #18
    //   352: aload #17
    //   354: invokevirtual _2 : ()Lbarneshut/Quad;
    //   357: astore #19
    //   359: aload #17
    //   361: invokevirtual _3 : ()Lbarneshut/Quad;
    //   364: astore #20
    //   366: aload #17
    //   368: invokevirtual _4 : ()Lbarneshut/Quad;
    //   371: astore #21
    //   373: aload #18
    //   375: astore #22
    //   377: aload #19
    //   379: astore #23
    //   381: aload #20
    //   383: astore #24
    //   385: aload #21
    //   387: astore #25
    //   389: aload #22
    //   391: astore #26
    //   393: aload #26
    //   395: instanceof barneshut/Leaf
    //   398: ifeq -> 577
    //   401: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   404: aload #26
    //   406: checkcast barneshut/Leaf
    //   409: invokevirtual unapply : (Lbarneshut/Leaf;)Lbarneshut/Leaf;
    //   412: astore #27
    //   414: aload #27
    //   416: invokevirtual _1 : ()F
    //   419: fstore #28
    //   421: aload #27
    //   423: invokevirtual _2 : ()F
    //   426: fstore #29
    //   428: aload #27
    //   430: invokevirtual _3 : ()F
    //   433: fstore #30
    //   435: aload #27
    //   437: invokevirtual _4 : ()Lscala/collection/Seq;
    //   440: astore #31
    //   442: fload #28
    //   444: fstore #32
    //   446: fload #29
    //   448: fstore #33
    //   450: fload #30
    //   452: fstore #34
    //   454: aload #31
    //   456: astore #35
    //   458: aload_0
    //   459: fload #32
    //   461: <illegal opcode> apply : (F)Lscala/Function0;
    //   466: aload_0
    //   467: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   472: new munit/Location
    //   475: dup
    //   476: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   478: sipush #265
    //   481: invokespecial <init> : (Ljava/lang/String;I)V
    //   484: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   487: aload_0
    //   488: fload #33
    //   490: <illegal opcode> apply : (F)Lscala/Function0;
    //   495: aload_0
    //   496: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   501: new munit/Location
    //   504: dup
    //   505: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   507: sipush #266
    //   510: invokespecial <init> : (Ljava/lang/String;I)V
    //   513: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   516: aload_0
    //   517: fload #34
    //   519: <illegal opcode> apply : (F)Lscala/Function0;
    //   524: aload_0
    //   525: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   530: new munit/Location
    //   533: dup
    //   534: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   536: sipush #267
    //   539: invokespecial <init> : (Ljava/lang/String;I)V
    //   542: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   545: aload_0
    //   546: aload_1
    //   547: aload #35
    //   549: <illegal opcode> apply : (Lbarneshut/Body;Lscala/collection/Seq;)Lscala/Function0;
    //   554: <illegal opcode> apply : ()Lscala/Function0;
    //   559: new munit/Location
    //   562: dup
    //   563: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   565: sipush #268
    //   568: invokespecial <init> : (Ljava/lang/String;I)V
    //   571: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   574: goto -> 631
    //   577: aload_0
    //   578: new java/lang/StringBuilder
    //   581: dup
    //   582: ldc_w 34
    //   585: invokespecial <init> : (I)V
    //   588: ldc_w 'nw of the Fork, '
    //   591: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload #22
    //   596: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   599: ldc_w ', should be a Leaf'
    //   602: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual toString : ()Ljava/lang/String;
    //   608: aload_0
    //   609: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   612: new munit/Location
    //   615: dup
    //   616: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   618: sipush #270
    //   621: invokespecial <init> : (Ljava/lang/String;I)V
    //   624: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   627: athrow
    //   628: nop
    //   629: nop
    //   630: athrow
    //   631: aload #23
    //   633: astore #36
    //   635: aload #36
    //   637: instanceof barneshut/Leaf
    //   640: ifeq -> 819
    //   643: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   646: aload #36
    //   648: checkcast barneshut/Leaf
    //   651: invokevirtual unapply : (Lbarneshut/Leaf;)Lbarneshut/Leaf;
    //   654: astore #37
    //   656: aload #37
    //   658: invokevirtual _1 : ()F
    //   661: fstore #38
    //   663: aload #37
    //   665: invokevirtual _2 : ()F
    //   668: fstore #39
    //   670: aload #37
    //   672: invokevirtual _3 : ()F
    //   675: fstore #40
    //   677: aload #37
    //   679: invokevirtual _4 : ()Lscala/collection/Seq;
    //   682: astore #41
    //   684: fload #38
    //   686: fstore #42
    //   688: fload #39
    //   690: fstore #43
    //   692: fload #40
    //   694: fstore #44
    //   696: aload #41
    //   698: astore #45
    //   700: aload_0
    //   701: fload #42
    //   703: <illegal opcode> apply : (F)Lscala/Function0;
    //   708: aload_0
    //   709: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   714: new munit/Location
    //   717: dup
    //   718: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   720: sipush #274
    //   723: invokespecial <init> : (Ljava/lang/String;I)V
    //   726: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   729: aload_0
    //   730: fload #43
    //   732: <illegal opcode> apply : (F)Lscala/Function0;
    //   737: aload_0
    //   738: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   743: new munit/Location
    //   746: dup
    //   747: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   749: sipush #275
    //   752: invokespecial <init> : (Ljava/lang/String;I)V
    //   755: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   758: aload_0
    //   759: fload #44
    //   761: <illegal opcode> apply : (F)Lscala/Function0;
    //   766: aload_0
    //   767: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   772: new munit/Location
    //   775: dup
    //   776: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   778: sipush #276
    //   781: invokespecial <init> : (Ljava/lang/String;I)V
    //   784: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   787: aload_0
    //   788: aload_2
    //   789: aload #45
    //   791: <illegal opcode> apply : (Lbarneshut/Body;Lscala/collection/Seq;)Lscala/Function0;
    //   796: <illegal opcode> apply : ()Lscala/Function0;
    //   801: new munit/Location
    //   804: dup
    //   805: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   807: sipush #277
    //   810: invokespecial <init> : (Ljava/lang/String;I)V
    //   813: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   816: goto -> 873
    //   819: aload_0
    //   820: new java/lang/StringBuilder
    //   823: dup
    //   824: ldc_w 34
    //   827: invokespecial <init> : (I)V
    //   830: ldc_w 'ne of the Fork, '
    //   833: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload #23
    //   838: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   841: ldc_w ', should be a Leaf'
    //   844: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: invokevirtual toString : ()Ljava/lang/String;
    //   850: aload_0
    //   851: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   854: new munit/Location
    //   857: dup
    //   858: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   860: sipush #279
    //   863: invokespecial <init> : (Ljava/lang/String;I)V
    //   866: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   869: athrow
    //   870: nop
    //   871: nop
    //   872: athrow
    //   873: aload #24
    //   875: astore #46
    //   877: aload #46
    //   879: instanceof barneshut/Empty
    //   882: ifeq -> 1021
    //   885: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   888: aload #46
    //   890: checkcast barneshut/Empty
    //   893: invokevirtual unapply : (Lbarneshut/Empty;)Lbarneshut/Empty;
    //   896: astore #47
    //   898: aload #47
    //   900: invokevirtual _1 : ()F
    //   903: fstore #48
    //   905: aload #47
    //   907: invokevirtual _2 : ()F
    //   910: fstore #49
    //   912: aload #47
    //   914: invokevirtual _3 : ()F
    //   917: fstore #50
    //   919: fload #48
    //   921: fstore #51
    //   923: fload #49
    //   925: fstore #52
    //   927: fload #50
    //   929: fstore #53
    //   931: aload_0
    //   932: fload #51
    //   934: <illegal opcode> apply : (F)Lscala/Function0;
    //   939: aload_0
    //   940: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   945: new munit/Location
    //   948: dup
    //   949: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   951: sipush #283
    //   954: invokespecial <init> : (Ljava/lang/String;I)V
    //   957: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   960: aload_0
    //   961: fload #52
    //   963: <illegal opcode> apply : (F)Lscala/Function0;
    //   968: aload_0
    //   969: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   974: new munit/Location
    //   977: dup
    //   978: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   980: sipush #284
    //   983: invokespecial <init> : (Ljava/lang/String;I)V
    //   986: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   989: aload_0
    //   990: fload #53
    //   992: <illegal opcode> apply : (F)Lscala/Function0;
    //   997: aload_0
    //   998: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   1003: new munit/Location
    //   1006: dup
    //   1007: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1009: sipush #285
    //   1012: invokespecial <init> : (Ljava/lang/String;I)V
    //   1015: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1018: goto -> 1075
    //   1021: aload_0
    //   1022: new java/lang/StringBuilder
    //   1025: dup
    //   1026: ldc_w 36
    //   1029: invokespecial <init> : (I)V
    //   1032: ldc_w 'sw of the Fork, '
    //   1035: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload #24
    //   1040: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1043: ldc_w ', should be an Empty'
    //   1046: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: invokevirtual toString : ()Ljava/lang/String;
    //   1052: aload_0
    //   1053: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   1056: new munit/Location
    //   1059: dup
    //   1060: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1062: sipush #287
    //   1065: invokespecial <init> : (Ljava/lang/String;I)V
    //   1068: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   1071: athrow
    //   1072: nop
    //   1073: nop
    //   1074: athrow
    //   1075: aload #25
    //   1077: astore #54
    //   1079: aload #54
    //   1081: instanceof barneshut/Empty
    //   1084: ifeq -> 1223
    //   1087: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   1090: aload #54
    //   1092: checkcast barneshut/Empty
    //   1095: invokevirtual unapply : (Lbarneshut/Empty;)Lbarneshut/Empty;
    //   1098: astore #55
    //   1100: aload #55
    //   1102: invokevirtual _1 : ()F
    //   1105: fstore #56
    //   1107: aload #55
    //   1109: invokevirtual _2 : ()F
    //   1112: fstore #57
    //   1114: aload #55
    //   1116: invokevirtual _3 : ()F
    //   1119: fstore #58
    //   1121: fload #56
    //   1123: fstore #59
    //   1125: fload #57
    //   1127: fstore #60
    //   1129: fload #58
    //   1131: fstore #61
    //   1133: aload_0
    //   1134: fload #59
    //   1136: <illegal opcode> apply : (F)Lscala/Function0;
    //   1141: aload_0
    //   1142: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   1147: new munit/Location
    //   1150: dup
    //   1151: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1153: sipush #291
    //   1156: invokespecial <init> : (Ljava/lang/String;I)V
    //   1159: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1162: aload_0
    //   1163: fload #60
    //   1165: <illegal opcode> apply : (F)Lscala/Function0;
    //   1170: aload_0
    //   1171: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   1176: new munit/Location
    //   1179: dup
    //   1180: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1182: sipush #292
    //   1185: invokespecial <init> : (Ljava/lang/String;I)V
    //   1188: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1191: aload_0
    //   1192: fload #61
    //   1194: <illegal opcode> apply : (F)Lscala/Function0;
    //   1199: aload_0
    //   1200: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   1205: new munit/Location
    //   1208: dup
    //   1209: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1211: sipush #293
    //   1214: invokespecial <init> : (Ljava/lang/String;I)V
    //   1217: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1220: goto -> 1277
    //   1223: aload_0
    //   1224: new java/lang/StringBuilder
    //   1227: dup
    //   1228: ldc_w 36
    //   1231: invokespecial <init> : (I)V
    //   1234: ldc_w 'se of the Fork, '
    //   1237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload #25
    //   1242: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1245: ldc_w ', should be an Empty'
    //   1248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: invokevirtual toString : ()Ljava/lang/String;
    //   1254: aload_0
    //   1255: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   1258: new munit/Location
    //   1261: dup
    //   1262: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1264: sipush #295
    //   1267: invokespecial <init> : (Ljava/lang/String;I)V
    //   1270: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   1273: athrow
    //   1274: nop
    //   1275: nop
    //   1276: athrow
    //   1277: goto -> 1334
    //   1280: aload_0
    //   1281: new java/lang/StringBuilder
    //   1284: dup
    //   1285: ldc_w 30
    //   1288: invokespecial <init> : (I)V
    //   1291: ldc_w 'The new ne, '
    //   1294: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: aload #13
    //   1299: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1302: ldc_w ', should be a Fork'
    //   1305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: invokevirtual toString : ()Ljava/lang/String;
    //   1311: aload_0
    //   1312: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   1315: new munit/Location
    //   1318: dup
    //   1319: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1321: sipush #297
    //   1324: invokespecial <init> : (Ljava/lang/String;I)V
    //   1327: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   1330: athrow
    //   1331: nop
    //   1332: nop
    //   1333: athrow
    //   1334: goto -> 1385
    //   1337: aload_0
    //   1338: new java/lang/StringBuilder
    //   1341: dup
    //   1342: ldc_w 39
    //   1345: invokespecial <init> : (I)V
    //   1348: aload #5
    //   1350: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1353: ldc_w ' should be a Fork where only ne changed'
    //   1356: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: invokevirtual toString : ()Ljava/lang/String;
    //   1362: aload_0
    //   1363: invokevirtual fail$default$2 : ()Lmunit/Clues;
    //   1366: new munit/Location
    //   1369: dup
    //   1370: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1372: sipush #300
    //   1375: invokespecial <init> : (Ljava/lang/String;I)V
    //   1378: invokevirtual fail : (Ljava/lang/String;Lmunit/Clues;Lmunit/Location;)Lscala/runtime/Nothing$;
    //   1381: athrow
    //   1382: nop
    //   1383: nop
    //   1384: athrow
    //   1385: aload_0
    //   1386: getstatic scala/Float$.MODULE$ : Lscala/Float$;
    //   1389: aload #5
    //   1391: invokevirtual centerX : ()F
    //   1394: invokevirtual float2double : (F)D
    //   1397: ldc2_w 15.0
    //   1400: getstatic barneshut/FloatOps$.MODULE$ : Lbarneshut/FloatOps$;
    //   1403: invokevirtual precisionThreshold : ()D
    //   1406: aload_0
    //   1407: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   1412: new munit/Location
    //   1415: dup
    //   1416: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1418: sipush #302
    //   1421: invokespecial <init> : (Ljava/lang/String;I)V
    //   1424: invokevirtual assertEqualsDouble : (DDDLscala/Function0;Lmunit/Location;)V
    //   1427: aload_0
    //   1428: getstatic scala/Float$.MODULE$ : Lscala/Float$;
    //   1431: aload #5
    //   1433: invokevirtual centerY : ()F
    //   1436: invokevirtual float2double : (F)D
    //   1439: ldc2_w 35.0
    //   1442: getstatic barneshut/FloatOps$.MODULE$ : Lbarneshut/FloatOps$;
    //   1445: invokevirtual precisionThreshold : ()D
    //   1448: aload_0
    //   1449: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   1454: new munit/Location
    //   1457: dup
    //   1458: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1460: sipush #303
    //   1463: invokespecial <init> : (Ljava/lang/String;I)V
    //   1466: invokevirtual assertEqualsDouble : (DDDLscala/Function0;Lmunit/Location;)V
    //   1469: aload_0
    //   1470: getstatic scala/Float$.MODULE$ : Lscala/Float$;
    //   1473: aload #5
    //   1475: invokevirtual size : ()F
    //   1478: invokevirtual float2double : (F)D
    //   1481: ldc2_w 20.0
    //   1484: getstatic barneshut/FloatOps$.MODULE$ : Lbarneshut/FloatOps$;
    //   1487: invokevirtual precisionThreshold : ()D
    //   1490: aload_0
    //   1491: <illegal opcode> apply : (Lbarneshut/BarnesHutSuite;)Lscala/Function0;
    //   1496: new munit/Location
    //   1499: dup
    //   1500: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1502: sipush #304
    //   1505: invokespecial <init> : (Ljava/lang/String;I)V
    //   1508: invokevirtual assertEqualsDouble : (DDDLscala/Function0;Lmunit/Location;)V
    //   1511: aload_0
    //   1512: aload #5
    //   1514: <illegal opcode> apply : (Lbarneshut/Fork;)Lscala/Function0;
    //   1519: aload #5
    //   1521: <illegal opcode> apply : (Lbarneshut/Fork;)Lscala/Function0;
    //   1526: new munit/Location
    //   1529: dup
    //   1530: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1532: sipush #306
    //   1535: invokespecial <init> : (Ljava/lang/String;I)V
    //   1538: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1541: aload_0
    //   1542: aload #5
    //   1544: <illegal opcode> apply : (Lbarneshut/Fork;)Lscala/Function0;
    //   1549: aload #5
    //   1551: <illegal opcode> apply : (Lbarneshut/Fork;)Lscala/Function0;
    //   1556: new munit/Location
    //   1559: dup
    //   1560: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1562: sipush #307
    //   1565: invokespecial <init> : (Ljava/lang/String;I)V
    //   1568: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1571: aload_0
    //   1572: aload #5
    //   1574: <illegal opcode> apply : (Lbarneshut/Fork;)Lscala/Function0;
    //   1579: aload #5
    //   1581: <illegal opcode> apply : (Lbarneshut/Fork;)Lscala/Function0;
    //   1586: new munit/Location
    //   1589: dup
    //   1590: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1592: sipush #308
    //   1595: invokespecial <init> : (Ljava/lang/String;I)V
    //   1598: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1601: aload_0
    //   1602: aload #5
    //   1604: <illegal opcode> apply : (Lbarneshut/Fork;)Lscala/Function0;
    //   1609: aload #5
    //   1611: <illegal opcode> apply : (Lbarneshut/Fork;)Lscala/Function0;
    //   1616: new munit/Location
    //   1619: dup
    //   1620: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   1622: sipush #309
    //   1625: invokespecial <init> : (Ljava/lang/String;I)V
    //   1628: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   1631: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #246	-> 0
    //   #247	-> 0
    //   #248	-> 19
    //   #249	-> 38
    //   #251	-> 57
    //   #252	-> 60
    //   #253	-> 75
    //   #254	-> 113
    //   #255	-> 128
    //   #257	-> 171
    //   #259	-> 179
    //   #260	-> 183
    //   #261	-> 320
    //   #262	-> 324
    //   #262	-> 332
    //   #263	-> 345
    //   #263	-> 389
    //   #264	-> 393
    //   #264	-> 401
    //   #265	-> 414
    //   #266	-> 487
    //   #267	-> 516
    //   #268	-> 545
    //   #270	-> 577
    //   #272	-> 631
    //   #273	-> 635
    //   #273	-> 643
    //   #274	-> 656
    //   #275	-> 729
    //   #276	-> 758
    //   #277	-> 787
    //   #279	-> 819
    //   #281	-> 873
    //   #282	-> 877
    //   #282	-> 885
    //   #283	-> 898
    //   #284	-> 960
    //   #285	-> 989
    //   #287	-> 1021
    //   #289	-> 1075
    //   #290	-> 1079
    //   #290	-> 1087
    //   #291	-> 1100
    //   #292	-> 1162
    //   #293	-> 1191
    //   #295	-> 1223
    //   #290	-> 1277
    //   #297	-> 1280
    //   #262	-> 1334
    //   #300	-> 1337
    //   #302	-> 1385
    //   #303	-> 1427
    //   #304	-> 1469
    //   #306	-> 1511
    //   #307	-> 1541
    //   #308	-> 1571
    //   #309	-> 1601
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   446	131	32	centerX	F
    //   450	127	33	centerY	F
    //   454	123	34	size	F
    //   458	119	35	bodies	Lscala/collection/Seq;
    //   688	131	42	centerX	F
    //   692	127	43	centerY	F
    //   696	123	44	size	F
    //   700	119	45	bodies	Lscala/collection/Seq;
    //   923	98	51	centerX	F
    //   927	94	52	centerY	F
    //   931	90	53	size	F
    //   1125	98	59	centerX	F
    //   1129	94	60	centerY	F
    //   1133	90	61	size	F
    //   377	903	22	nw	Lbarneshut/Quad;
    //   381	899	23	ne	Lbarneshut/Quad;
    //   385	895	24	sw	Lbarneshut/Quad;
    //   389	891	25	se	Lbarneshut/Quad;
    //   260	1077	13	newNE	Lbarneshut/Quad;
    //   19	1612	1	b1	Lbarneshut/Body;
    //   38	1593	2	b2	Lbarneshut/Body;
    //   57	1574	3	b3	Lbarneshut/Body;
    //   171	1460	4	initialFork	Lbarneshut/Fork;
    //   179	1452	5	quad	Lbarneshut/Fork;
    //   0	1632	0	this	Lbarneshut/BarnesHutSuite;
  }
  
  private static final boolean $init$$$anonfun$192$$anonfun$1(float centerX$7) {
    return FloatOps$.MODULE$.$tilde$eq(centerX$7, 17.5F);
  }
  
  private final String $init$$$anonfun$193$$anonfun$2() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$194$$anonfun$3(float centerY$7) {
    return FloatOps$.MODULE$.$tilde$eq(centerY$7, 27.5F);
  }
  
  private final String $init$$$anonfun$195$$anonfun$4() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$196$$anonfun$5(float size$7) {
    return FloatOps$.MODULE$.$tilde$eq(size$7, 5.0F);
  }
  
  private final String $init$$$anonfun$197$$anonfun$6() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$198$$anonfun$7(Body b1$3, Seq bodies$7) {
    Object object = Set$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b1$3 }));
    if (bodies$7.toSet() == null) {
      bodies$7.toSet();
      if (object != null);
    } else if (bodies$7.toSet().equals(object)) {
    
    } 
  }
  
  private static final String $init$$$anonfun$199$$anonfun$8() {
    return "nw should contain the first body";
  }
  
  private static final boolean $init$$$anonfun$200$$anonfun$9(float centerX$8) {
    return FloatOps$.MODULE$.$tilde$eq(centerX$8, 22.5F);
  }
  
  private final String $init$$$anonfun$201$$anonfun$10() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$202$$anonfun$11(float centerY$8) {
    return FloatOps$.MODULE$.$tilde$eq(centerY$8, 27.5F);
  }
  
  private final String $init$$$anonfun$203$$anonfun$12() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$204$$anonfun$13(float size$8) {
    return FloatOps$.MODULE$.$tilde$eq(size$8, 5.0F);
  }
  
  private final String $init$$$anonfun$205$$anonfun$14() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$206$$anonfun$15(Body b2$3, Seq bodies$8) {
    Object object = Set$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b2$3 }));
    if (bodies$8.toSet() == null) {
      bodies$8.toSet();
      if (object != null);
    } else if (bodies$8.toSet().equals(object)) {
    
    } 
  }
  
  private static final String $init$$$anonfun$207$$anonfun$16() {
    return "ne should contain the second body";
  }
  
  private static final boolean $init$$$anonfun$208$$anonfun$17(float centerX$9) {
    return FloatOps$.MODULE$.$tilde$eq(centerX$9, 17.5F);
  }
  
  private final String $init$$$anonfun$209$$anonfun$18() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$210$$anonfun$19(float centerY$9) {
    return FloatOps$.MODULE$.$tilde$eq(centerY$9, 32.5F);
  }
  
  private final String $init$$$anonfun$211$$anonfun$20() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$212$$anonfun$21(float size$9) {
    return FloatOps$.MODULE$.$tilde$eq(size$9, 5.0F);
  }
  
  private final String $init$$$anonfun$213$$anonfun$22() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$214$$anonfun$23(float centerX$10) {
    return FloatOps$.MODULE$.$tilde$eq(centerX$10, 22.5F);
  }
  
  private final String $init$$$anonfun$215$$anonfun$24() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$216$$anonfun$25(float centerY$10) {
    return FloatOps$.MODULE$.$tilde$eq(centerY$10, 32.5F);
  }
  
  private final String $init$$$anonfun$217$$anonfun$26() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$218$$anonfun$27(float size$10) {
    return FloatOps$.MODULE$.$tilde$eq(size$10, 5.0F);
  }
  
  private final String $init$$$anonfun$219$$anonfun$28() {
    return assert$default$2();
  }
  
  private final String $init$$$anonfun$220$$anonfun$29() {
    return assertEqualsDouble$default$4();
  }
  
  private final String $init$$$anonfun$221$$anonfun$30() {
    return assertEqualsDouble$default$4();
  }
  
  private final String $init$$$anonfun$222$$anonfun$31() {
    return assertEqualsDouble$default$4();
  }
  
  private static final boolean $init$$$anonfun$223$$anonfun$32(Fork quad$113) {
    return FloatOps$.MODULE$.$tilde$eq(quad$113.mass(), 892.5F);
  }
  
  private static final String $init$$$anonfun$224$$anonfun$33(Fork quad$114) {
    return (new StringBuilder(17)).append(quad$114.mass()).append(" should be 892.5f").toString();
  }
  
  private static final boolean $init$$$anonfun$225$$anonfun$34(Fork quad$115) {
    return FloatOps$.MODULE$.$tilde$eq(quad$115.massX(), 23.02773F);
  }
  
  private static final String $init$$$anonfun$226$$anonfun$35(Fork quad$116) {
    return (new StringBuilder(20)).append(quad$116.massX()).append(" should be 23.02773f").toString();
  }
  
  private static final boolean $init$$$anonfun$227$$anonfun$36(Fork quad$117) {
    return FloatOps$.MODULE$.$tilde$eq(quad$117.massY(), 29.823809F);
  }
  
  private static final String $init$$$anonfun$228$$anonfun$37(Fork quad$118) {
    return (new StringBuilder(21)).append(quad$118.massY()).append(" should be 29.823809f").toString();
  }
  
  private static final boolean $init$$$anonfun$229$$anonfun$38(Fork quad$119) {
    return (quad$119.total() == 3);
  }
  
  private static final String $init$$$anonfun$230$$anonfun$39(Fork quad$120) {
    return (new StringBuilder(12)).append(quad$120.total()).append(" should be 3").toString();
  }
  
  private final void $init$$$anonfun$16() {
    // Byte code:
    //   0: new barneshut/Body
    //   3: dup
    //   4: ldc_w 5.0
    //   7: ldc_w 0.5
    //   10: ldc_w 0.5
    //   13: ldc_w 0.1
    //   16: ldc_w 0.1
    //   19: invokespecial <init> : (FFFFF)V
    //   22: astore_1
    //   23: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   26: fconst_1
    //   27: fconst_1
    //   28: fconst_2
    //   29: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   32: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   35: iconst_1
    //   36: anewarray barneshut/Body
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   46: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   49: checkcast scala/collection/Seq
    //   52: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   55: astore_2
    //   56: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   59: fconst_1
    //   60: fconst_1
    //   61: fconst_2
    //   62: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   65: aload_1
    //   66: invokevirtual insert : (Lbarneshut/Body;)Lbarneshut/Quad;
    //   69: astore_3
    //   70: aload_0
    //   71: aload_2
    //   72: aload_3
    //   73: <illegal opcode> apply : (Lbarneshut/Leaf;Lbarneshut/Quad;)Lscala/Function0;
    //   78: aload_2
    //   79: aload_3
    //   80: <illegal opcode> apply : (Lbarneshut/Leaf;Lbarneshut/Quad;)Lscala/Function0;
    //   85: new munit/Location
    //   88: dup
    //   89: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   91: sipush #316
    //   94: invokespecial <init> : (Ljava/lang/String;I)V
    //   97: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   100: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #312	-> 0
    //   #313	-> 0
    //   #314	-> 23
    //   #315	-> 56
    //   #316	-> 70
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   23	77	1	body	Lbarneshut/Body;
    //   56	44	2	output	Lbarneshut/Leaf;
    //   70	30	3	res	Lbarneshut/Quad;
    //   0	101	0	this	Lbarneshut/BarnesHutSuite;
  }
  
  private static final boolean $init$$$anonfun$231$$anonfun$1(Leaf output$1, Quad res$1) {
    Leaf leaf = output$1;
    if (res$1 == null) {
      if (leaf != null);
    } else if (res$1.equals(leaf)) {
    
    } 
  }
  
  private static final String $init$$$anonfun$232$$anonfun$2(Leaf output$2, Quad res$2) {
    return (new StringBuilder(16)).append("expected ").append(output$2).append(" found ").append(res$2).toString();
  }
  
  private final void $init$$$anonfun$17() {
    // Byte code:
    //   0: new barneshut/Body
    //   3: dup
    //   4: ldc_w 5.0
    //   7: ldc_w 0.4
    //   10: ldc_w 0.4
    //   13: ldc_w 0.1
    //   16: ldc_w 0.1
    //   19: invokespecial <init> : (FFFFF)V
    //   22: astore_1
    //   23: new barneshut/Body
    //   26: dup
    //   27: ldc_w 5.0
    //   30: ldc_w 1.4
    //   33: ldc_w 0.4
    //   36: ldc_w 0.1
    //   39: ldc_w 0.1
    //   42: invokespecial <init> : (FFFFF)V
    //   45: astore_2
    //   46: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   49: fconst_1
    //   50: fconst_1
    //   51: fconst_2
    //   52: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   55: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   58: iconst_1
    //   59: anewarray barneshut/Body
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   69: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   72: checkcast scala/collection/Seq
    //   75: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   78: astore_3
    //   79: aload_3
    //   80: aload_2
    //   81: invokevirtual insert : (Lbarneshut/Body;)Lbarneshut/Quad;
    //   84: astore #4
    //   86: getstatic barneshut/Fork$.MODULE$ : Lbarneshut/Fork$;
    //   89: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   92: ldc_w 0.5
    //   95: ldc_w 0.5
    //   98: fconst_1
    //   99: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   102: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   105: iconst_1
    //   106: anewarray barneshut/Body
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   116: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   119: checkcast scala/collection/Seq
    //   122: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   125: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   128: ldc_w 1.5
    //   131: ldc_w 0.5
    //   134: fconst_1
    //   135: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   138: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   141: iconst_1
    //   142: anewarray barneshut/Body
    //   145: dup
    //   146: iconst_0
    //   147: aload_2
    //   148: aastore
    //   149: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   152: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   155: checkcast scala/collection/Seq
    //   158: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   161: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   164: ldc_w 0.5
    //   167: ldc_w 1.5
    //   170: fconst_1
    //   171: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   174: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   177: ldc_w 1.5
    //   180: ldc_w 1.5
    //   183: fconst_1
    //   184: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   187: invokevirtual apply : (Lbarneshut/Quad;Lbarneshut/Quad;Lbarneshut/Quad;Lbarneshut/Quad;)Lbarneshut/Fork;
    //   190: astore #5
    //   192: aload_0
    //   193: aload #4
    //   195: aload #5
    //   197: <illegal opcode> apply : (Lbarneshut/Quad;Lbarneshut/Fork;)Lscala/Function0;
    //   202: aload #4
    //   204: aload #5
    //   206: <illegal opcode> apply : (Lbarneshut/Quad;Lbarneshut/Fork;)Lscala/Function0;
    //   211: new munit/Location
    //   214: dup
    //   215: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   217: sipush #326
    //   220: invokespecial <init> : (Ljava/lang/String;I)V
    //   223: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   226: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #319	-> 0
    //   #320	-> 0
    //   #321	-> 23
    //   #322	-> 46
    //   #323	-> 79
    //   #324	-> 86
    //   #325	-> 161
    //   #326	-> 192
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   23	203	1	body1	Lbarneshut/Body;
    //   46	180	2	body2	Lbarneshut/Body;
    //   79	147	3	leaf	Lbarneshut/Leaf;
    //   86	140	4	res	Lbarneshut/Quad;
    //   192	34	5	output	Lbarneshut/Fork;
    //   0	227	0	this	Lbarneshut/BarnesHutSuite;
  }
  
  private static final boolean $init$$$anonfun$233$$anonfun$1(Quad res$3, Fork output$3) {
    Fork fork = output$3;
    if (res$3 == null) {
      if (fork != null);
    } else if (res$3.equals(fork)) {
    
    } 
  }
  
  private static final String $init$$$anonfun$234$$anonfun$2(Quad res$4, Fork output$4) {
    return (new StringBuilder(16)).append("expected ").append(output$4).append(" found ").append(res$4).toString();
  }
  
  private final void $init$$$anonfun$18() {
    // Byte code:
    //   0: ldc_w 1.0E-5
    //   3: fstore_1
    //   4: new barneshut/Body
    //   7: dup
    //   8: ldc_w 5.0
    //   11: iconst_1
    //   12: i2f
    //   13: fload_1
    //   14: iconst_2
    //   15: i2f
    //   16: fdiv
    //   17: fsub
    //   18: iconst_1
    //   19: i2f
    //   20: fload_1
    //   21: iconst_2
    //   22: i2f
    //   23: fdiv
    //   24: fsub
    //   25: ldc_w 0.1
    //   28: ldc_w 0.1
    //   31: invokespecial <init> : (FFFFF)V
    //   34: astore_2
    //   35: new barneshut/Body
    //   38: dup
    //   39: ldc_w 5.0
    //   42: iconst_1
    //   43: i2f
    //   44: fload_1
    //   45: iconst_2
    //   46: i2f
    //   47: fdiv
    //   48: fadd
    //   49: iconst_1
    //   50: i2f
    //   51: fload_1
    //   52: iconst_2
    //   53: i2f
    //   54: fdiv
    //   55: fadd
    //   56: ldc_w 0.1
    //   59: ldc_w 0.1
    //   62: invokespecial <init> : (FFFFF)V
    //   65: astore_3
    //   66: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   69: fconst_1
    //   70: fconst_1
    //   71: fload_1
    //   72: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   75: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   78: iconst_1
    //   79: anewarray barneshut/Body
    //   82: dup
    //   83: iconst_0
    //   84: aload_2
    //   85: aastore
    //   86: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   89: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   92: checkcast scala/collection/Seq
    //   95: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   98: astore #4
    //   100: aload #4
    //   102: aload_3
    //   103: invokevirtual insert : (Lbarneshut/Body;)Lbarneshut/Quad;
    //   106: astore #5
    //   108: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   111: fconst_1
    //   112: fconst_1
    //   113: fload_1
    //   114: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   117: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   120: iconst_2
    //   121: anewarray barneshut/Body
    //   124: dup
    //   125: iconst_0
    //   126: aload_2
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: aload_3
    //   131: aastore
    //   132: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   135: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   138: checkcast scala/collection/Seq
    //   141: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   144: astore #6
    //   146: aload #5
    //   148: astore #8
    //   150: aload #8
    //   152: instanceof barneshut/Leaf
    //   155: ifeq -> 296
    //   158: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   161: aload #8
    //   163: checkcast barneshut/Leaf
    //   166: invokevirtual unapply : (Lbarneshut/Leaf;)Lbarneshut/Leaf;
    //   169: astore #9
    //   171: aload #9
    //   173: invokevirtual _1 : ()F
    //   176: fstore #10
    //   178: aload #9
    //   180: invokevirtual _2 : ()F
    //   183: fstore #11
    //   185: aload #9
    //   187: invokevirtual _3 : ()F
    //   190: fstore #12
    //   192: aload #9
    //   194: invokevirtual _4 : ()Lscala/collection/Seq;
    //   197: astore #13
    //   199: fload #10
    //   201: fstore #14
    //   203: fload #11
    //   205: fstore #15
    //   207: fload #12
    //   209: fstore #16
    //   211: aload #13
    //   213: astore #17
    //   215: fload #14
    //   217: aload #6
    //   219: invokevirtual centerX : ()F
    //   222: fcmpl
    //   223: ifne -> 292
    //   226: fload #15
    //   228: aload #6
    //   230: invokevirtual centerY : ()F
    //   233: fcmpl
    //   234: ifne -> 292
    //   237: fload #16
    //   239: aload #6
    //   241: invokevirtual size : ()F
    //   244: fcmpl
    //   245: ifne -> 292
    //   248: aload #17
    //   250: invokeinterface toSet : ()Lscala/collection/immutable/Set;
    //   255: aload #6
    //   257: invokevirtual bodies : ()Lscala/collection/Seq;
    //   260: invokeinterface toSet : ()Lscala/collection/immutable/Set;
    //   265: astore #18
    //   267: dup
    //   268: ifnonnull -> 280
    //   271: pop
    //   272: aload #18
    //   274: ifnull -> 288
    //   277: goto -> 292
    //   280: aload #18
    //   282: invokevirtual equals : (Ljava/lang/Object;)Z
    //   285: ifeq -> 292
    //   288: iconst_1
    //   289: goto -> 293
    //   292: iconst_0
    //   293: goto -> 300
    //   296: iconst_0
    //   297: goto -> 300
    //   300: istore #7
    //   302: aload_0
    //   303: iload #7
    //   305: <illegal opcode> apply : (Z)Lscala/Function0;
    //   310: aload #5
    //   312: aload #6
    //   314: <illegal opcode> apply : (Lbarneshut/Quad;Lbarneshut/Leaf;)Lscala/Function0;
    //   319: new munit/Location
    //   322: dup
    //   323: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   325: sipush #341
    //   328: invokespecial <init> : (Ljava/lang/String;I)V
    //   331: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   334: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #329	-> 0
    //   #330	-> 0
    //   #331	-> 4
    //   #332	-> 35
    //   #333	-> 66
    //   #334	-> 100
    //   #335	-> 108
    //   #336	-> 146
    //   #337	-> 150
    //   #338	-> 215
    //   #339	-> 237
    //   #338	-> 293
    //   #340	-> 296
    //   #341	-> 302
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   203	93	14	x	F
    //   207	89	15	y	F
    //   211	85	16	s	F
    //   215	81	17	bodies	Lscala/collection/Seq;
    //   4	330	1	size	F
    //   35	299	2	body1	Lbarneshut/Body;
    //   66	268	3	body2	Lbarneshut/Body;
    //   100	234	4	leaf	Lbarneshut/Leaf;
    //   108	226	5	res	Lbarneshut/Quad;
    //   146	188	6	output	Lbarneshut/Leaf;
    //   302	32	7	asExpected	Z
    //   0	335	0	this	Lbarneshut/BarnesHutSuite;
  }
  
  private static final boolean $init$$$anonfun$235$$anonfun$1(boolean asExpected$1) {
    return asExpected$1;
  }
  
  private static final String $init$$$anonfun$236$$anonfun$2(Quad res$5, Leaf output$5) {
    return (new StringBuilder(16)).append("expected ").append(output$5).append(" found ").append(res$5).toString();
  }
  
  private final void $init$$$anonfun$19() {
    Body b1 = new Body(123.0F, 18.0F, 26.0F, 0.0F, 0.0F);
    Body body = b1.updated((Quad)Empty$.MODULE$.apply(50.0F, 60.0F, 5.0F));
    assertEquals(BoxesRunTime.boxToFloat(body.xspeed()), BoxesRunTime.boxToFloat(0.0F), BarnesHutSuite::$init$$$anonfun$237$$anonfun$1, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 351), (.less.colon.less)$less$colon$less$.MODULE$.refl());
    assertEquals(BoxesRunTime.boxToFloat(body.yspeed()), BoxesRunTime.boxToFloat(0.0F), BarnesHutSuite::$init$$$anonfun$238$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 352), (.less.colon.less)$less$colon$less$.MODULE$.refl());
  }
  
  private static final double $init$$$anonfun$237$$anonfun$1() {
    return FloatOps$.MODULE$.precisionThreshold();
  }
  
  private static final double $init$$$anonfun$238$$anonfun$2() {
    return FloatOps$.MODULE$.precisionThreshold();
  }
  
  private final void $init$$$anonfun$20() {
    Body b1 = new Body(123.0F, 18.0F, 26.0F, 0.0F, 0.0F);
    Body b2 = new Body(524.5F, 24.5F, 25.5F, 0.0F, 0.0F);
    Body b3 = new Body(245.0F, 22.4F, 41.0F, 0.0F, 0.0F);
    Leaf quad = Leaf$.MODULE$.apply(15.0F, 30.0F, 20.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b2, b3 })));
    Body body = b1.updated((Quad)quad);
    assert(body::$init$$$anonfun$239$$anonfun$1, this::$init$$$anonfun$240$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 364));
    assert(body::$init$$$anonfun$241$$anonfun$3, this::$init$$$anonfun$242$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 365));
  }
  
  private static final boolean $init$$$anonfun$239$$anonfun$1(Body body$1) {
    return FloatOps$.MODULE$.$tilde$eq(body$1.xspeed(), 12.587037F);
  }
  
  private final String $init$$$anonfun$240$$anonfun$2() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$241$$anonfun$3(Body body$2) {
    return FloatOps$.MODULE$.$tilde$eq(body$2.yspeed(), 0.015557117F);
  }
  
  private final String $init$$$anonfun$242$$anonfun$4() {
    return assert$default$2();
  }
  
  private final void $init$$$anonfun$21() {
    Body b1 = new Body(123.0F, 18.0F, 26.0F, 0.0F, 0.0F);
    Body b2 = new Body(524.5F, 24.5F, 25.5F, 0.0F, 0.0F);
    Body b3 = new Body(245.0F, 22.4F, 41.0F, 0.0F, 0.0F);
    Leaf quad = Leaf$.MODULE$.apply(15.0F, 30.0F, 20.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b1, b2, b3 })));
    Body body = b1.updated((Quad)quad);
    assert(body::$init$$$anonfun$243$$anonfun$1, this::$init$$$anonfun$244$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 378));
    assert(body::$init$$$anonfun$245$$anonfun$3, this::$init$$$anonfun$246$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 379));
  }
  
  private static final boolean $init$$$anonfun$243$$anonfun$1(Body body$3) {
    return FloatOps$.MODULE$.$tilde$eq(body$3.xspeed(), 12.587037F);
  }
  
  private final String $init$$$anonfun$244$$anonfun$2() {
    return assert$default$2();
  }
  
  private static final boolean $init$$$anonfun$245$$anonfun$3(Body body$4) {
    return FloatOps$.MODULE$.$tilde$eq(body$4.yspeed(), 0.015557117F);
  }
  
  private final String $init$$$anonfun$246$$anonfun$4() {
    return assert$default$2();
  }
  
  private final void $init$$$anonfun$22() {
    // Byte code:
    //   0: new barneshut/Body
    //   3: dup
    //   4: ldc_w 100.0
    //   7: ldc_w 17.0
    //   10: ldc_w 60.0
    //   13: fconst_0
    //   14: fconst_0
    //   15: invokespecial <init> : (FFFFF)V
    //   18: astore_1
    //   19: new barneshut/Body
    //   22: dup
    //   23: ldc_w 123.0
    //   26: ldc_w 18.0
    //   29: ldc_w 26.0
    //   32: fconst_0
    //   33: fconst_0
    //   34: invokespecial <init> : (FFFFF)V
    //   37: astore_2
    //   38: new barneshut/Body
    //   41: dup
    //   42: ldc_w 524.5
    //   45: ldc_w 24.5
    //   48: ldc_w 25.5
    //   51: fconst_0
    //   52: fconst_0
    //   53: invokespecial <init> : (FFFFF)V
    //   56: astore_3
    //   57: new barneshut/Body
    //   60: dup
    //   61: ldc_w 245.0
    //   64: ldc_w 22.4
    //   67: ldc_w 41.0
    //   70: fconst_0
    //   71: fconst_0
    //   72: invokespecial <init> : (FFFFF)V
    //   75: astore #4
    //   77: getstatic barneshut/Fork$.MODULE$ : Lbarneshut/Fork$;
    //   80: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   83: ldc_w 10.0
    //   86: ldc_w 30.0
    //   89: ldc_w 10.0
    //   92: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   95: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   98: ldc_w 20.0
    //   101: ldc_w 30.0
    //   104: ldc_w 10.0
    //   107: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   110: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   113: iconst_2
    //   114: anewarray barneshut/Body
    //   117: dup
    //   118: iconst_0
    //   119: aload_2
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_3
    //   124: aastore
    //   125: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   128: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   131: checkcast scala/collection/Seq
    //   134: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   137: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   140: ldc_w 10.0
    //   143: ldc_w 40.0
    //   146: ldc_w 10.0
    //   149: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   152: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   155: ldc_w 20.0
    //   158: ldc_w 40.0
    //   161: ldc_w 10.0
    //   164: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   167: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   170: iconst_1
    //   171: anewarray barneshut/Body
    //   174: dup
    //   175: iconst_0
    //   176: aload #4
    //   178: aastore
    //   179: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   182: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   185: checkcast scala/collection/Seq
    //   188: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   191: invokevirtual apply : (Lbarneshut/Quad;Lbarneshut/Quad;Lbarneshut/Quad;Lbarneshut/Quad;)Lbarneshut/Fork;
    //   194: astore #5
    //   196: aload_1
    //   197: aload #5
    //   199: invokevirtual updated : (Lbarneshut/Quad;)Lbarneshut/Body;
    //   202: astore #6
    //   204: aload_0
    //   205: aload_1
    //   206: aload #5
    //   208: <illegal opcode> apply : (Lbarneshut/Body;Lbarneshut/Fork;)Lscala/Function0;
    //   213: <illegal opcode> apply : ()Lscala/Function0;
    //   218: new munit/Location
    //   221: dup
    //   222: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   224: sipush #399
    //   227: invokespecial <init> : (Ljava/lang/String;I)V
    //   230: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   233: aload_0
    //   234: aload #6
    //   236: <illegal opcode> apply : (Lbarneshut/Body;)Lscala/Function0;
    //   241: aload #6
    //   243: <illegal opcode> apply : (Lbarneshut/Body;)Lscala/Function0;
    //   248: new munit/Location
    //   251: dup
    //   252: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   254: sipush #401
    //   257: invokespecial <init> : (Ljava/lang/String;I)V
    //   260: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   263: aload_0
    //   264: aload #6
    //   266: <illegal opcode> apply : (Lbarneshut/Body;)Lscala/Function0;
    //   271: aload #6
    //   273: <illegal opcode> apply : (Lbarneshut/Body;)Lscala/Function0;
    //   278: new munit/Location
    //   281: dup
    //   282: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   284: sipush #402
    //   287: invokespecial <init> : (Ljava/lang/String;I)V
    //   290: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   293: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #382	-> 0
    //   #383	-> 0
    //   #385	-> 19
    //   #386	-> 38
    //   #387	-> 57
    //   #389	-> 77
    //   #390	-> 80
    //   #391	-> 95
    //   #392	-> 137
    //   #393	-> 152
    //   #396	-> 196
    //   #398	-> 204
    //   #399	-> 213
    //   #401	-> 233
    //   #402	-> 263
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   19	274	1	b	Lbarneshut/Body;
    //   38	255	2	b1	Lbarneshut/Body;
    //   57	236	3	b2	Lbarneshut/Body;
    //   77	216	4	b3	Lbarneshut/Body;
    //   196	97	5	quad	Lbarneshut/Fork;
    //   204	89	6	body	Lbarneshut/Body;
    //   0	294	0	this	Lbarneshut/BarnesHutSuite;
  }
  
  private static final boolean $init$$$anonfun$247$$anonfun$1(Body b$2, Fork quad$121) {
    return (quad$121.size() / common$package$.MODULE$.distance(b$2.x(), b$2.y(), quad$121.centerX(), quad$121.centerY()) >= common$package$.MODULE$.theta());
  }
  
  private static final String $init$$$anonfun$248$$anonfun$2() {
    return "Sanity check: the fork is indeed close enough";
  }
  
  private static final boolean $init$$$anonfun$249$$anonfun$3(Body body$5) {
    return FloatOps$.MODULE$.$tilde$eq(body$5.xspeed(), 0.26418167F);
  }
  
  private static final String $init$$$anonfun$250$$anonfun$4(Body body$6) {
    return (new StringBuilder(11)).append("xspeed was ").append(body$6.xspeed()).toString();
  }
  
  private static final boolean $init$$$anonfun$251$$anonfun$5(Body body$7) {
    return FloatOps$.MODULE$.$tilde$eq(body$7.yspeed(), -1.1214639F);
  }
  
  private static final String $init$$$anonfun$252$$anonfun$6(Body body$8) {
    return (new StringBuilder(11)).append("yspeed was ").append(body$8.yspeed()).toString();
  }
  
  private final void $init$$$anonfun$23() {
    // Byte code:
    //   0: new barneshut/Body
    //   3: dup
    //   4: ldc_w 100.0
    //   7: ldc_w 55.0
    //   10: ldc_w 60.0
    //   13: fconst_0
    //   14: fconst_0
    //   15: invokespecial <init> : (FFFFF)V
    //   18: astore_1
    //   19: new barneshut/Body
    //   22: dup
    //   23: ldc_w 123.0
    //   26: ldc_w 18.0
    //   29: ldc_w 26.0
    //   32: fconst_0
    //   33: fconst_0
    //   34: invokespecial <init> : (FFFFF)V
    //   37: astore_2
    //   38: new barneshut/Body
    //   41: dup
    //   42: ldc_w 524.5
    //   45: ldc_w 24.5
    //   48: ldc_w 25.5
    //   51: fconst_0
    //   52: fconst_0
    //   53: invokespecial <init> : (FFFFF)V
    //   56: astore_3
    //   57: new barneshut/Body
    //   60: dup
    //   61: ldc_w 245.0
    //   64: ldc_w 22.4
    //   67: ldc_w 41.0
    //   70: fconst_0
    //   71: fconst_0
    //   72: invokespecial <init> : (FFFFF)V
    //   75: astore #4
    //   77: getstatic barneshut/Fork$.MODULE$ : Lbarneshut/Fork$;
    //   80: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   83: ldc_w 10.0
    //   86: ldc_w 30.0
    //   89: ldc_w 10.0
    //   92: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   95: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   98: ldc_w 20.0
    //   101: ldc_w 30.0
    //   104: ldc_w 10.0
    //   107: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   110: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   113: iconst_2
    //   114: anewarray barneshut/Body
    //   117: dup
    //   118: iconst_0
    //   119: aload_2
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_3
    //   124: aastore
    //   125: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   128: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   131: checkcast scala/collection/Seq
    //   134: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   137: getstatic barneshut/Empty$.MODULE$ : Lbarneshut/Empty$;
    //   140: ldc_w 10.0
    //   143: ldc_w 40.0
    //   146: ldc_w 10.0
    //   149: invokevirtual apply : (FFF)Lbarneshut/Empty;
    //   152: getstatic barneshut/Leaf$.MODULE$ : Lbarneshut/Leaf$;
    //   155: ldc_w 20.0
    //   158: ldc_w 40.0
    //   161: ldc_w 10.0
    //   164: getstatic scala/collection/Seq$.MODULE$ : Lscala/collection/Seq$;
    //   167: getstatic scala/runtime/ScalaRunTime$.MODULE$ : Lscala/runtime/ScalaRunTime$;
    //   170: iconst_1
    //   171: anewarray barneshut/Body
    //   174: dup
    //   175: iconst_0
    //   176: aload #4
    //   178: aastore
    //   179: invokevirtual wrapRefArray : ([Ljava/lang/Object;)Lscala/collection/immutable/ArraySeq;
    //   182: invokevirtual apply : (Lscala/collection/immutable/Seq;)Lscala/collection/SeqOps;
    //   185: checkcast scala/collection/Seq
    //   188: invokevirtual apply : (FFFLscala/collection/Seq;)Lbarneshut/Leaf;
    //   191: invokevirtual apply : (Lbarneshut/Quad;Lbarneshut/Quad;Lbarneshut/Quad;Lbarneshut/Quad;)Lbarneshut/Fork;
    //   194: astore #5
    //   196: aload_1
    //   197: aload #5
    //   199: invokevirtual updated : (Lbarneshut/Quad;)Lbarneshut/Body;
    //   202: astore #6
    //   204: aload_0
    //   205: aload_1
    //   206: aload #5
    //   208: <illegal opcode> apply : (Lbarneshut/Body;Lbarneshut/Fork;)Lscala/Function0;
    //   213: <illegal opcode> apply : ()Lscala/Function0;
    //   218: new munit/Location
    //   221: dup
    //   222: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   224: sipush #422
    //   227: invokespecial <init> : (Ljava/lang/String;I)V
    //   230: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   233: aload_0
    //   234: aload #6
    //   236: <illegal opcode> apply : (Lbarneshut/Body;)Lscala/Function0;
    //   241: aload #6
    //   243: <illegal opcode> apply : (Lbarneshut/Body;)Lscala/Function0;
    //   248: new munit/Location
    //   251: dup
    //   252: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   254: sipush #424
    //   257: invokespecial <init> : (Ljava/lang/String;I)V
    //   260: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   263: aload_0
    //   264: aload #6
    //   266: <illegal opcode> apply : (Lbarneshut/Body;)Lscala/Function0;
    //   271: aload #6
    //   273: <illegal opcode> apply : (Lbarneshut/Body;)Lscala/Function0;
    //   278: new munit/Location
    //   281: dup
    //   282: ldc '/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala'
    //   284: sipush #425
    //   287: invokespecial <init> : (Ljava/lang/String;I)V
    //   290: invokevirtual assert : (Lscala/Function0;Lscala/Function0;Lmunit/Location;)V
    //   293: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #405	-> 0
    //   #406	-> 0
    //   #408	-> 19
    //   #409	-> 38
    //   #410	-> 57
    //   #412	-> 77
    //   #413	-> 80
    //   #414	-> 95
    //   #415	-> 137
    //   #416	-> 152
    //   #419	-> 196
    //   #421	-> 204
    //   #422	-> 213
    //   #424	-> 233
    //   #425	-> 263
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   19	274	1	b	Lbarneshut/Body;
    //   38	255	2	b1	Lbarneshut/Body;
    //   57	236	3	b2	Lbarneshut/Body;
    //   77	216	4	b3	Lbarneshut/Body;
    //   196	97	5	quad	Lbarneshut/Fork;
    //   204	89	6	body	Lbarneshut/Body;
    //   0	294	0	this	Lbarneshut/BarnesHutSuite;
  }
  
  private static final boolean $init$$$anonfun$253$$anonfun$1(Body b$3, Fork quad$122) {
    return (quad$122.size() / common$package$.MODULE$.distance(b$3.x(), b$3.y(), quad$122.centerX(), quad$122.centerY()) < common$package$.MODULE$.theta());
  }
  
  private static final String $init$$$anonfun$254$$anonfun$2() {
    return "Sanity check: the fork is indeed far enough";
  }
  
  private static final boolean $init$$$anonfun$255$$anonfun$3(Body body$9) {
    return FloatOps$.MODULE$.$tilde$eq(body$9.xspeed(), -0.3358085F);
  }
  
  private static final String $init$$$anonfun$256$$anonfun$4(Body body$10) {
    return (new StringBuilder(11)).append("xspeed was ").append(body$10.xspeed()).toString();
  }
  
  private static final boolean $init$$$anonfun$257$$anonfun$5(Body body$11) {
    return FloatOps$.MODULE$.$tilde$eq(body$11.yspeed(), -0.31694406F);
  }
  
  private static final String $init$$$anonfun$258$$anonfun$6(Body body$12) {
    return (new StringBuilder(11)).append("yspeed was ").append(body$12.yspeed()).toString();
  }
  
  private final void $init$$$anonfun$24() {
    Body body = new Body(5.0F, 25.0F, 47.0F, 0.1F, 0.1F);
    Boundaries boundaries = new Boundaries();
    boundaries.minX_$eq(1.0F);
    boundaries.minY_$eq(1.0F);
    boundaries.maxX_$eq(97.0F);
    boundaries.maxY_$eq(97.0F);
    SectorMatrix sm = new SectorMatrix(boundaries, common$package$.MODULE$.SECTOR_PRECISION());
    sm.$plus$eq(body);
    boolean res = (sm.apply(2, 3).size() == 1 && sm.apply(2, 3).find(_$1 -> {
          Body body = body$13;
          if (_$1 == null) {
            if (body != null);
          } else if (_$1.equals(body)) {
          
          } 
        }).isDefined());
    assert(res::$init$$$anonfun$259$$anonfun$1, BarnesHutSuite::$init$$$anonfun$260$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 441));
  }
  
  private static final boolean $init$$$anonfun$259$$anonfun$1(boolean res$6) {
    return res$6;
  }
  
  private static final String $init$$$anonfun$260$$anonfun$2() {
    return "Body not found in the right sector";
  }
  
  private final void $init$$$anonfun$25() {
    Body body = new Body(5.0F, 25.0F, 47.0F, 0.1F, 0.1F);
    Boundaries boundaries = new Boundaries();
    boundaries.minX_$eq(1.0F);
    boundaries.minY_$eq(1.0F);
    boundaries.maxX_$eq(101.0F);
    boundaries.maxY_$eq(101.0F);
    SectorMatrix sectorMatrix = new SectorMatrix(boundaries, common$package$.MODULE$.SECTOR_PRECISION());
    sectorMatrix.$plus$eq(body);
    boolean res = (sectorMatrix.apply(1, 3).size() == 1 && sectorMatrix.apply(1, 3).find(_$2 -> {
          Body body = body$14;
          if (_$2 == null) {
            if (body != null);
          } else if (_$2.equals(body)) {
          
          } 
        }).isDefined());
    assert(res::$init$$$anonfun$261$$anonfun$1, BarnesHutSuite::$init$$$anonfun$262$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 455));
  }
  
  private static final boolean $init$$$anonfun$261$$anonfun$1(boolean res$7) {
    return res$7;
  }
  
  private static final String $init$$$anonfun$262$$anonfun$2() {
    return "Body not found in the right sector. Hint: sector sizes could be fractions";
  }
  
  private final void $init$$$anonfun$26() {
    Body body = new Body(5.0F, 64.0F, 27.0F, 0.1F, 0.1F);
    Boundaries boundaries = new Boundaries();
    boundaries.minX_$eq(0.0F);
    boundaries.minY_$eq(0.0F);
    boundaries.maxX_$eq(108.0F);
    boundaries.maxY_$eq(108.0F);
    SectorMatrix sectorMatrix = new SectorMatrix(boundaries, 12);
    sectorMatrix.$plus$eq(body);
    boolean res = (sectorMatrix.apply(7, 3).size() == 1 && sectorMatrix.apply(7, 3).find(_$3 -> {
          Body body = body$15;
          if (_$3 == null) {
            if (body != null);
          } else if (_$3.equals(body)) {
          
          } 
        }).isDefined());
    assert(res::$init$$$anonfun$263$$anonfun$1, BarnesHutSuite::$init$$$anonfun$264$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 468));
  }
  
  private static final boolean $init$$$anonfun$263$$anonfun$1(boolean res$8) {
    return res$8;
  }
  
  private static final String $init$$$anonfun$264$$anonfun$2() {
    return "Body not found in the right sector";
  }
  
  private final void $init$$$anonfun$27() {
    List bodies = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(12.0F), BoxesRunTime.boxToFloat(34.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(23.0F), BoxesRunTime.boxToFloat(45.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(56.0F), BoxesRunTime.boxToFloat(9.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(8.0F), BoxesRunTime.boxToFloat(79.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(5.0F), BoxesRunTime.boxToFloat(90.0F)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_0
          //   1: astore_1
          //   2: aload_1
          //   3: ifnull -> 43
          //   6: aload_1
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   13: fstore_2
          //   14: aload_1
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   21: fstore_3
          //   22: new barneshut/Body
          //   25: dup
          //   26: ldc_w 5.0
          //   29: fload_2
          //   30: fload_3
          //   31: ldc_w 0.1
          //   34: ldc_w 0.1
          //   37: invokespecial <init> : (FFFFF)V
          //   40: goto -> 52
          //   43: new scala/MatchError
          //   46: dup
          //   47: aload_1
          //   48: invokespecial <init> : (Ljava/lang/Object;)V
          //   51: athrow
          //   52: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #473	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	29	2	x	F
          //   22	21	3	y	F
          //   0	53	0	x$1	Lscala/Tuple2;
        });
    Boundaries boundaries = new Boundaries();
    boundaries.minX_$eq(1.0F);
    boundaries.minY_$eq(1.0F);
    boundaries.maxX_$eq(97.0F);
    boundaries.maxY_$eq(97.0F);
    SectorMatrix sectorMatrix1 = new SectorMatrix(boundaries, 12);
    SectorMatrix sectorMatrix2 = new SectorMatrix(boundaries, 12);
    sectorMatrix1.$plus$eq((Body)bodies.apply(1));
    sectorMatrix1.$plus$eq((Body)bodies.apply(2));
    sectorMatrix1.$plus$eq((Body)bodies.apply(3));
    sectorMatrix2.$plus$eq((Body)bodies.apply(0));
    sectorMatrix2.$plus$eq((Body)bodies.apply(4));
    SectorMatrix sectorMatrix3 = sectorMatrix1.combine(sectorMatrix2);
    List buckets = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(1), BoxesRunTime.boxToInteger(4)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(2), BoxesRunTime.boxToInteger(5)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(6), BoxesRunTime.boxToInteger(1)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToInteger(9)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToInteger(11)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_1
          //   1: astore_2
          //   2: aload_2
          //   3: ifnull -> 35
          //   6: aload_2
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToInt : (Ljava/lang/Object;)I
          //   13: istore_3
          //   14: aload_2
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToInt : (Ljava/lang/Object;)I
          //   21: istore #4
          //   23: aload_0
          //   24: iload_3
          //   25: iload #4
          //   27: invokeinterface apply : (II)Lbarneshut/conctrees/ConcBuffer;
          //   32: goto -> 44
          //   35: new scala/MatchError
          //   38: dup
          //   39: aload_2
          //   40: invokespecial <init> : (Ljava/lang/Object;)V
          //   43: athrow
          //   44: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #492	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	21	3	row	I
          //   23	12	4	col	I
          //   0	45	0	sm$1	Lbarneshut/SectorMatrixInterface;
          //   0	45	1	x$1	Lscala/Tuple2;
        });
    RichInt$.MODULE$.until$extension(Predef$.MODULE$.intWrapper(0), bodies.size()).foreach((Function1)(i -> {
          boolean res = (((IterableOnceOps)buckets$1.apply(i)).size() == 1 && ((IterableOnceOps)buckets$1.apply(i)).find(_$4 -> {
                Object object = bodies$10.apply(i$1);
                if (_$4 == null) {
                  if (object != null);
                } else if (_$4.equals(object)) {
                
                } 
              }).isDefined());
          assert(res::$init$$$anonfun$265$$anonfun$1$$anonfun$1, i::$init$$$anonfun$266$$anonfun$2$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 496));
        }));
  }
  
  private static final boolean $init$$$anonfun$265$$anonfun$1$$anonfun$1(boolean res$9) {
    return res$9;
  }
  
  private static final String $init$$$anonfun$266$$anonfun$2$$anonfun$2(int i$2) {
    return (new StringBuilder(61)).append("Body ").append(i$2 + 1).append(" not found in the right sector in combined sector matrix").toString();
  }
  
  private final void $init$$$anonfun$28() {
    List bodies = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(12.0F), BoxesRunTime.boxToFloat(34.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(13.0F), BoxesRunTime.boxToFloat(35.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(56.0F), BoxesRunTime.boxToFloat(9.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(55.0F), BoxesRunTime.boxToFloat(10.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(5.0F), BoxesRunTime.boxToFloat(90.0F)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_0
          //   1: astore_1
          //   2: aload_1
          //   3: ifnull -> 43
          //   6: aload_1
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   13: fstore_2
          //   14: aload_1
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   21: fstore_3
          //   22: new barneshut/Body
          //   25: dup
          //   26: ldc_w 5.0
          //   29: fload_2
          //   30: fload_3
          //   31: ldc_w 0.1
          //   34: ldc_w 0.1
          //   37: invokespecial <init> : (FFFFF)V
          //   40: goto -> 52
          //   43: new scala/MatchError
          //   46: dup
          //   47: aload_1
          //   48: invokespecial <init> : (Ljava/lang/Object;)V
          //   51: athrow
          //   52: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #501	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	29	2	x	F
          //   22	21	3	y	F
          //   0	53	0	x$1	Lscala/Tuple2;
        });
    Boundaries boundaries = new Boundaries();
    boundaries.minX_$eq(1.0F);
    boundaries.minY_$eq(1.0F);
    boundaries.maxX_$eq(97.0F);
    boundaries.maxY_$eq(97.0F);
    SectorMatrix sectorMatrix1 = new SectorMatrix(boundaries, 12);
    SectorMatrix sectorMatrix2 = new SectorMatrix(boundaries, 12);
    sectorMatrix1.$plus$eq((Body)bodies.apply(1));
    sectorMatrix1.$plus$eq((Body)bodies.apply(2));
    sectorMatrix1.$plus$eq((Body)bodies.apply(3));
    sectorMatrix2.$plus$eq((Body)bodies.apply(0));
    sectorMatrix2.$plus$eq((Body)bodies.apply(4));
    SectorMatrix sectorMatrix3 = sectorMatrix1.combine(sectorMatrix2);
    List buckets = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(1), BoxesRunTime.boxToInteger(4)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(1), BoxesRunTime.boxToInteger(4)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(6), BoxesRunTime.boxToInteger(1)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(6), BoxesRunTime.boxToInteger(1)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToInteger(11)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_1
          //   1: astore_2
          //   2: aload_2
          //   3: ifnull -> 35
          //   6: aload_2
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToInt : (Ljava/lang/Object;)I
          //   13: istore_3
          //   14: aload_2
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToInt : (Ljava/lang/Object;)I
          //   21: istore #4
          //   23: aload_0
          //   24: iload_3
          //   25: iload #4
          //   27: invokeinterface apply : (II)Lbarneshut/conctrees/ConcBuffer;
          //   32: goto -> 44
          //   35: new scala/MatchError
          //   38: dup
          //   39: aload_2
          //   40: invokespecial <init> : (Ljava/lang/Object;)V
          //   43: athrow
          //   44: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #520	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	21	3	row	I
          //   23	12	4	col	I
          //   0	45	0	sm$2	Lbarneshut/SectorMatrixInterface;
          //   0	45	1	x$1	Lscala/Tuple2;
        });
    assert(buckets::$init$$$anonfun$268$$anonfun$1, BarnesHutSuite::$init$$$anonfun$269$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 522));
    assert(buckets::$init$$$anonfun$270$$anonfun$3, BarnesHutSuite::$init$$$anonfun$271$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 523));
    assert(buckets::$init$$$anonfun$272$$anonfun$5, BarnesHutSuite::$init$$$anonfun$273$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 524));
    RichInt$.MODULE$.until$extension(Predef$.MODULE$.intWrapper(0), bodies.size()).foreach((Function1)(i -> {
          boolean res = ((IterableOnceOps)buckets$5.apply(i)).find(_$5 -> {
                Object object = bodies$12.apply(i$3);
                if (_$5 == null) {
                  if (object != null);
                } else if (_$5.equals(object)) {
                
                } 
              }).isDefined();
          assert(res::$init$$$anonfun$274$$anonfun$7$$anonfun$1, i::$init$$$anonfun$275$$anonfun$8$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 527));
        }));
  }
  
  private static final boolean $init$$$anonfun$268$$anonfun$1(List buckets$2) {
    return (((IterableOnceOps)buckets$2.apply(0)).size() == 2);
  }
  
  private static final String $init$$$anonfun$269$$anonfun$2() {
    return "bucket (1,4) should have size 2";
  }
  
  private static final boolean $init$$$anonfun$270$$anonfun$3(List buckets$3) {
    return (((IterableOnceOps)buckets$3.apply(2)).size() == 2);
  }
  
  private static final String $init$$$anonfun$271$$anonfun$4() {
    return "bucket (6,1) should have size 2";
  }
  
  private static final boolean $init$$$anonfun$272$$anonfun$5(List buckets$4) {
    return (((IterableOnceOps)buckets$4.apply(4)).size() == 1);
  }
  
  private static final String $init$$$anonfun$273$$anonfun$6() {
    return "bucket (0,11) should have size 1";
  }
  
  private static final boolean $init$$$anonfun$274$$anonfun$7$$anonfun$1(boolean res$10) {
    return res$10;
  }
  
  private static final String $init$$$anonfun$275$$anonfun$8$$anonfun$2(int i$4) {
    return (new StringBuilder(61)).append("Body ").append(i$4 + 1).append(" not found in the right sector in combined sector matrix").toString();
  }
  
  private final void $init$$$anonfun$29() {
    Body b = new Body(5.0F, 3.0F, 5.0F, 0.1F, 0.1F);
    Simulator sim = new Simulator(package$.MODULE$.defaultTaskSupport(), new TimeStatistics());
    Boundaries res = sim.updateBoundaries(new Boundaries(), b);
    assert(res::$init$$$anonfun$277$$anonfun$1, BarnesHutSuite::$init$$$anonfun$278$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 536));
    assert(res::$init$$$anonfun$279$$anonfun$3, BarnesHutSuite::$init$$$anonfun$280$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 537));
  }
  
  private static final boolean $init$$$anonfun$277$$anonfun$1(Boundaries res$11) {
    return (res$11.minX() == 3 && res$11.maxX() == 3);
  }
  
  private static final String $init$$$anonfun$278$$anonfun$2() {
    return "minX and maxX are not correctly updated";
  }
  
  private static final boolean $init$$$anonfun$279$$anonfun$3(Boundaries res$12) {
    return (res$12.minY() == 5 && res$12.maxY() == 5);
  }
  
  private static final String $init$$$anonfun$280$$anonfun$4() {
    return "minY and maxY are not correctly updated";
  }
  
  private final void $init$$$anonfun$30() {
    List bodies = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(12.0F), BoxesRunTime.boxToFloat(34.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(23.0F), BoxesRunTime.boxToFloat(45.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(56.0F), BoxesRunTime.boxToFloat(9.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(8.0F), BoxesRunTime.boxToFloat(79.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(5.0F), BoxesRunTime.boxToFloat(90.0F)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_0
          //   1: astore_1
          //   2: aload_1
          //   3: ifnull -> 43
          //   6: aload_1
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   13: fstore_2
          //   14: aload_1
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   21: fstore_3
          //   22: new barneshut/Body
          //   25: dup
          //   26: ldc_w 5.0
          //   29: fload_2
          //   30: fload_3
          //   31: ldc_w 0.1
          //   34: ldc_w 0.1
          //   37: invokespecial <init> : (FFFFF)V
          //   40: goto -> 52
          //   43: new scala/MatchError
          //   46: dup
          //   47: aload_1
          //   48: invokespecial <init> : (Ljava/lang/Object;)V
          //   51: athrow
          //   52: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #542	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	29	2	x	F
          //   22	21	3	y	F
          //   0	53	0	x$1	Lscala/Tuple2;
        });
    Simulator sim = new Simulator(package$.MODULE$.defaultTaskSupport(), new TimeStatistics());
    Boundaries res = (Boundaries)bodies.foldLeft(new Boundaries(), (acc, b) -> sim$1.updateBoundaries(acc, b));
    assert(res::$init$$$anonfun$281$$anonfun$1, BarnesHutSuite::$init$$$anonfun$282$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 546));
    assert(res::$init$$$anonfun$283$$anonfun$3, BarnesHutSuite::$init$$$anonfun$284$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 547));
  }
  
  private static final boolean $init$$$anonfun$281$$anonfun$1(Boundaries res$13) {
    return (res$13.minX() == 5 && res$13.maxX() == 56);
  }
  
  private static final String $init$$$anonfun$282$$anonfun$2() {
    return "minX and maxX are not correctly updated";
  }
  
  private static final boolean $init$$$anonfun$283$$anonfun$3(Boundaries res$14) {
    return (res$14.minY() == 9 && res$14.maxY() == 90);
  }
  
  private static final String $init$$$anonfun$284$$anonfun$4() {
    return "minY and maxY are not correctly updated";
  }
  
  private final void $init$$$anonfun$31() {
    Boundaries boundaries1 = new Boundaries();
    boundaries1.minX_$eq(45.0F);
    boundaries1.minY_$eq(76.0F);
    boundaries1.maxX_$eq(89.0F);
    boundaries1.maxY_$eq(91.0F);
    Boundaries boundaries2 = new Boundaries();
    boundaries2.minX_$eq(56.0F);
    boundaries2.minY_$eq(23.0F);
    boundaries2.maxX_$eq(117.0F);
    boundaries2.maxY_$eq(78.0F);
    Boundaries res = (new Simulator(package$.MODULE$.defaultTaskSupport(), new TimeStatistics())).mergeBoundaries(boundaries1, boundaries2);
    assert(res::$init$$$anonfun$285$$anonfun$1, BarnesHutSuite::$init$$$anonfun$286$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 562));
    assert(res::$init$$$anonfun$287$$anonfun$3, BarnesHutSuite::$init$$$anonfun$288$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 563));
  }
  
  private static final boolean $init$$$anonfun$285$$anonfun$1(Boundaries res$15) {
    return (res$15.minX() == 45 && res$15.maxX() == 117);
  }
  
  private static final String $init$$$anonfun$286$$anonfun$2() {
    return "minX and maxX are not correctly updated";
  }
  
  private static final boolean $init$$$anonfun$287$$anonfun$3(Boundaries res$16) {
    return (res$16.minY() == 23 && res$16.maxY() == 91);
  }
  
  private static final String $init$$$anonfun$288$$anonfun$4() {
    return "minY and maxY are not correctly updated";
  }
  
  private final void $init$$$anonfun$32() {
    List bodies = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(12.0F), BoxesRunTime.boxToFloat(34.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(23.0F), BoxesRunTime.boxToFloat(45.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(56.0F), BoxesRunTime.boxToFloat(9.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(8.0F), BoxesRunTime.boxToFloat(79.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(5.0F), BoxesRunTime.boxToFloat(90.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(1.0F), BoxesRunTime.boxToFloat(1.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(96.0F), BoxesRunTime.boxToFloat(96.0F)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_0
          //   1: astore_1
          //   2: aload_1
          //   3: ifnull -> 43
          //   6: aload_1
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   13: fstore_2
          //   14: aload_1
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   21: fstore_3
          //   22: new barneshut/Body
          //   25: dup
          //   26: ldc_w 5.0
          //   29: fload_2
          //   30: fload_3
          //   31: ldc_w 0.1
          //   34: ldc_w 0.1
          //   37: invokespecial <init> : (FFFFF)V
          //   40: goto -> 52
          //   43: new scala/MatchError
          //   46: dup
          //   47: aload_1
          //   48: invokespecial <init> : (Ljava/lang/Object;)V
          //   51: athrow
          //   52: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #568	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	29	2	x	F
          //   22	21	3	y	F
          //   0	53	0	x$1	Lscala/Tuple2;
        });
    Boundaries boundaries = new Boundaries();
    boundaries.minX_$eq(1.0F);
    boundaries.minY_$eq(1.0F);
    boundaries.maxX_$eq(97.0F);
    boundaries.maxY_$eq(97.0F);
    SectorMatrix sm = (new Simulator(package$.MODULE$.defaultTaskSupport(), new TimeStatistics())).computeSectorMatrix((Seq)bodies, boundaries);
    List buckets = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToInteger(2)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(1), BoxesRunTime.boxToInteger(3)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(4), BoxesRunTime.boxToInteger(0)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToInteger(6)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToInteger(7)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToInteger(0)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(7), BoxesRunTime.boxToInteger(7)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_1
          //   1: astore_2
          //   2: aload_2
          //   3: ifnull -> 33
          //   6: aload_2
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToInt : (Ljava/lang/Object;)I
          //   13: istore_3
          //   14: aload_2
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToInt : (Ljava/lang/Object;)I
          //   21: istore #4
          //   23: aload_0
          //   24: iload_3
          //   25: iload #4
          //   27: invokevirtual apply : (II)Lbarneshut/conctrees/ConcBuffer;
          //   30: goto -> 42
          //   33: new scala/MatchError
          //   36: dup
          //   37: aload_2
          //   38: invokespecial <init> : (Ljava/lang/Object;)V
          //   41: athrow
          //   42: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #577	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	19	3	row	I
          //   23	10	4	col	I
          //   0	43	0	sm$3	Lbarneshut/SectorMatrix;
          //   0	43	1	x$1	Lscala/Tuple2;
        });
    RichInt$.MODULE$.until$extension(Predef$.MODULE$.intWrapper(0), bodies.size()).foreach((Function1)(i -> {
          boolean res = (((IterableOnceOps)buckets$6.apply(i)).size() == 1 && ((IterableOnceOps)buckets$6.apply(i)).find(_$6 -> {
                Object object = bodies$14.apply(i$5);
                if (_$6 == null) {
                  if (object != null);
                } else if (_$6.equals(object)) {
                
                } 
              }).isDefined());
          assert(res::$init$$$anonfun$289$$anonfun$1$$anonfun$1, i::$init$$$anonfun$290$$anonfun$2$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 581));
        }));
  }
  
  private static final boolean $init$$$anonfun$289$$anonfun$1$$anonfun$1(boolean res$17) {
    return res$17;
  }
  
  private static final String $init$$$anonfun$290$$anonfun$2$$anonfun$2(int i$6) {
    return (new StringBuilder(56)).append("Body ").append(i$6 + 1).append(" not found in the right sector in the sector matrix").toString();
  }
  
  private final void $init$$$anonfun$33() {
    List bodies = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(12.0F), BoxesRunTime.boxToFloat(34.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(13.0F), BoxesRunTime.boxToFloat(35.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(56.0F), BoxesRunTime.boxToFloat(9.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(55.0F), BoxesRunTime.boxToFloat(10.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(5.0F), BoxesRunTime.boxToFloat(90.0F)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_0
          //   1: astore_1
          //   2: aload_1
          //   3: ifnull -> 43
          //   6: aload_1
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   13: fstore_2
          //   14: aload_1
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   21: fstore_3
          //   22: new barneshut/Body
          //   25: dup
          //   26: ldc_w 5.0
          //   29: fload_2
          //   30: fload_3
          //   31: ldc_w 0.1
          //   34: ldc_w 0.1
          //   37: invokespecial <init> : (FFFFF)V
          //   40: goto -> 52
          //   43: new scala/MatchError
          //   46: dup
          //   47: aload_1
          //   48: invokespecial <init> : (Ljava/lang/Object;)V
          //   51: athrow
          //   52: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #586	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	29	2	x	F
          //   22	21	3	y	F
          //   0	53	0	x$1	Lscala/Tuple2;
        });
    Boundaries boundaries = new Boundaries();
    boundaries.minX_$eq(1.0F);
    boundaries.minY_$eq(1.0F);
    boundaries.maxX_$eq(97.0F);
    boundaries.maxY_$eq(97.0F);
    SectorMatrix sm = (new Simulator(package$.MODULE$.defaultTaskSupport(), new TimeStatistics())).computeSectorMatrix((Seq)bodies, boundaries);
    List buckets = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToInteger(2)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(1), BoxesRunTime.boxToInteger(2)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(4), BoxesRunTime.boxToInteger(0)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(4), BoxesRunTime.boxToInteger(0)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToInteger(7)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_1
          //   1: astore_2
          //   2: aload_2
          //   3: ifnull -> 33
          //   6: aload_2
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToInt : (Ljava/lang/Object;)I
          //   13: istore_3
          //   14: aload_2
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToInt : (Ljava/lang/Object;)I
          //   21: istore #4
          //   23: aload_0
          //   24: iload_3
          //   25: iload #4
          //   27: invokevirtual apply : (II)Lbarneshut/conctrees/ConcBuffer;
          //   30: goto -> 42
          //   33: new scala/MatchError
          //   36: dup
          //   37: aload_2
          //   38: invokespecial <init> : (Ljava/lang/Object;)V
          //   41: athrow
          //   42: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #595	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	19	3	row	I
          //   23	10	4	col	I
          //   0	43	0	sm$4	Lbarneshut/SectorMatrix;
          //   0	43	1	x$1	Lscala/Tuple2;
        });
    assert(buckets::$init$$$anonfun$292$$anonfun$1, BarnesHutSuite::$init$$$anonfun$293$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 597));
    assert(buckets::$init$$$anonfun$294$$anonfun$3, BarnesHutSuite::$init$$$anonfun$295$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 598));
    assert(buckets::$init$$$anonfun$296$$anonfun$5, BarnesHutSuite::$init$$$anonfun$297$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 599));
    assert(buckets::$init$$$anonfun$298$$anonfun$7, BarnesHutSuite::$init$$$anonfun$299$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 600));
    RichInt$.MODULE$.until$extension(Predef$.MODULE$.intWrapper(0), bodies.size()).foreach((Function1)(i -> {
          boolean res = ((IterableOnceOps)buckets$11.apply(i)).find(_$7 -> {
                Object object = bodies$16.apply(i$7);
                if (_$7 == null) {
                  if (object != null);
                } else if (_$7.equals(object)) {
                
                } 
              }).isDefined();
          assert(res::$init$$$anonfun$300$$anonfun$9$$anonfun$1, i::$init$$$anonfun$301$$anonfun$10$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 603));
        }));
  }
  
  private static final boolean $init$$$anonfun$292$$anonfun$1(List buckets$7) {
    return (((IterableOnceOps)buckets$7.apply(0)).size() == 1);
  }
  
  private static final String $init$$$anonfun$293$$anonfun$2() {
    return "bucket (0,2) should have size 1";
  }
  
  private static final boolean $init$$$anonfun$294$$anonfun$3(List buckets$8) {
    return (((IterableOnceOps)buckets$8.apply(1)).size() == 1);
  }
  
  private static final String $init$$$anonfun$295$$anonfun$4() {
    return "bucket (1,2) should have size 1";
  }
  
  private static final boolean $init$$$anonfun$296$$anonfun$5(List buckets$9) {
    return (((IterableOnceOps)buckets$9.apply(2)).size() == 2);
  }
  
  private static final String $init$$$anonfun$297$$anonfun$6() {
    return "bucket (4,0) should have size 2";
  }
  
  private static final boolean $init$$$anonfun$298$$anonfun$7(List buckets$10) {
    return (((IterableOnceOps)buckets$10.apply(4)).size() == 1);
  }
  
  private static final String $init$$$anonfun$299$$anonfun$8() {
    return "bucket (0,7) should have size 1";
  }
  
  private static final boolean $init$$$anonfun$300$$anonfun$9$$anonfun$1(boolean res$18) {
    return res$18;
  }
  
  private static final String $init$$$anonfun$301$$anonfun$10$$anonfun$2(int i$8) {
    return (new StringBuilder(56)).append("Body ").append(i$8 + 1).append(" not found in the right sector in the sector matrix").toString();
  }
  
  private final void $init$$$anonfun$34() {
    List bodies = ((List)package$.MODULE$.List().apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Tuple2[] { Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(12.0F), BoxesRunTime.boxToFloat(34.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(23.0F), BoxesRunTime.boxToFloat(45.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(56.0F), BoxesRunTime.boxToFloat(9.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(8.0F), BoxesRunTime.boxToFloat(79.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(5.0F), BoxesRunTime.boxToFloat(90.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(1.0F), BoxesRunTime.boxToFloat(1.0F)), Tuple2$.MODULE$.apply(BoxesRunTime.boxToFloat(96.0F), BoxesRunTime.boxToFloat(96.0F)) }))).map(x$1 -> {
          // Byte code:
          //   0: aload_0
          //   1: astore_1
          //   2: aload_1
          //   3: ifnull -> 43
          //   6: aload_1
          //   7: invokevirtual _1 : ()Ljava/lang/Object;
          //   10: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   13: fstore_2
          //   14: aload_1
          //   15: invokevirtual _2 : ()Ljava/lang/Object;
          //   18: invokestatic unboxToFloat : (Ljava/lang/Object;)F
          //   21: fstore_3
          //   22: new barneshut/Body
          //   25: dup
          //   26: ldc_w 5.0
          //   29: fload_2
          //   30: fload_3
          //   31: ldc_w 0.1
          //   34: ldc_w 0.1
          //   37: invokespecial <init> : (FFFFF)V
          //   40: goto -> 52
          //   43: new scala/MatchError
          //   46: dup
          //   47: aload_1
          //   48: invokespecial <init> : (Ljava/lang/Object;)V
          //   51: athrow
          //   52: areturn
          // Line number table:
          //   Java source line number -> byte code offset
          //   #608	-> 0
          // Local variable table:
          //   start	length	slot	name	descriptor
          //   14	29	2	x	F
          //   22	21	3	y	F
          //   0	53	0	x$1	Lscala/Tuple2;
        });
    Boundaries boundaries = new Boundaries();
    boundaries.minX_$eq(1.0F);
    boundaries.minY_$eq(1.0F);
    boundaries.maxX_$eq(97.0F);
    boundaries.maxY_$eq(97.0F);
    ForkJoinTaskSupport trackingTaskSuport = Util$.MODULE$.trackingTaskSuport();
    Simulator simulator = new Simulator((TaskSupport)trackingTaskSuport, new TimeStatistics());
    simulator.computeSectorMatrix((Seq)bodies, boundaries);
    assert(trackingTaskSuport::$init$$$anonfun$303$$anonfun$1, BarnesHutSuite::$init$$$anonfun$304$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 621));
  }
  
  private static final boolean $init$$$anonfun$303$$anonfun$1(ForkJoinTaskSupport trackingTaskSuport$1) {
    return (((Util.CallTracking)trackingTaskSuport$1).numberOfCalls() > 0L);
  }
  
  private static final String $init$$$anonfun$304$$anonfun$2() {
    return "computeSectorMatrix should be parallel";
  }
  
  private final void $init$$$anonfun$35() {
    Body b1 = new Body(123.0F, 18.0F, 26.0F, 0.0F, 0.0F);
    Body b2 = new Body(524.5F, 24.5F, 25.5F, 0.0F, 0.0F);
    Body b3 = new Body(245.0F, 22.4F, 41.0F, 0.0F, 0.0F);
    Leaf quad = Leaf$.MODULE$.apply(15.0F, 30.0F, 20.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b1, b2, b3 })));
    Simulator simulator = new Simulator(package$.MODULE$.defaultTaskSupport(), new TimeStatistics());
    Seq bodies = simulator.updateBodies((Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b1, b2, b3 }, )), (Quad)quad);
    assert(bodies::$init$$$anonfun$305$$anonfun$1, bodies::$init$$$anonfun$306$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 634));
    assert(bodies::$init$$$anonfun$307$$anonfun$3, bodies::$init$$$anonfun$308$$anonfun$4, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 635));
    assert(bodies::$init$$$anonfun$309$$anonfun$5, bodies::$init$$$anonfun$310$$anonfun$6, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 637));
    assert(bodies::$init$$$anonfun$311$$anonfun$7, bodies::$init$$$anonfun$312$$anonfun$8, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 638));
    assert(bodies::$init$$$anonfun$313$$anonfun$9, bodies::$init$$$anonfun$314$$anonfun$10, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 640));
    assert(bodies::$init$$$anonfun$315$$anonfun$11, bodies::$init$$$anonfun$316$$anonfun$12, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 641));
  }
  
  private static final boolean $init$$$anonfun$305$$anonfun$1(Seq bodies$17) {
    return FloatOps$.MODULE$.$tilde$eq(((Body)bodies$17.apply(0)).xspeed(), 12.587037F);
  }
  
  private static final String $init$$$anonfun$306$$anonfun$2(Seq bodies$18) {
    return (new StringBuilder(11)).append("xspeed was ").append(((Body)bodies$18.apply(0)).xspeed()).toString();
  }
  
  private static final boolean $init$$$anonfun$307$$anonfun$3(Seq bodies$19) {
    return FloatOps$.MODULE$.$tilde$eq(((Body)bodies$19.apply(0)).yspeed(), 0.015557117F);
  }
  
  private static final String $init$$$anonfun$308$$anonfun$4(Seq bodies$20) {
    return (new StringBuilder(11)).append("yspeed was ").append(((Body)bodies$20.apply(0)).yspeed()).toString();
  }
  
  private static final boolean $init$$$anonfun$309$$anonfun$5(Seq bodies$21) {
    return FloatOps$.MODULE$.$tilde$eq(((Body)bodies$21.apply(1)).xspeed(), -3.0200372F);
  }
  
  private static final String $init$$$anonfun$310$$anonfun$6(Seq bodies$22) {
    return (new StringBuilder(11)).append("xspeed was ").append(((Body)bodies$22.apply(1)).xspeed()).toString();
  }
  
  private static final boolean $init$$$anonfun$311$$anonfun$7(Seq bodies$23) {
    return FloatOps$.MODULE$.$tilde$eq(((Body)bodies$23.apply(1)).yspeed(), 1.2142922F);
  }
  
  private static final String $init$$$anonfun$312$$anonfun$8(Seq bodies$24) {
    return (new StringBuilder(11)).append("yspeed was ").append(((Body)bodies$24.apply(1)).yspeed()).toString();
  }
  
  private static final boolean $init$$$anonfun$313$$anonfun$9(Seq bodies$25) {
    return FloatOps$.MODULE$.$tilde$eq(((Body)bodies$25.apply(2)).xspeed(), 0.14613827F);
  }
  
  private static final String $init$$$anonfun$314$$anonfun$10(Seq bodies$26) {
    return (new StringBuilder(11)).append("xspeed was ").append(((Body)bodies$26.apply(2)).xspeed()).toString();
  }
  
  private static final boolean $init$$$anonfun$315$$anonfun$11(Seq bodies$27) {
    return FloatOps$.MODULE$.$tilde$eq(((Body)bodies$27.apply(2)).yspeed(), -2.607387F);
  }
  
  private static final String $init$$$anonfun$316$$anonfun$12(Seq bodies$28) {
    return (new StringBuilder(11)).append("yspeed was ").append(((Body)bodies$28.apply(2)).yspeed()).toString();
  }
  
  private final void $init$$$anonfun$36() {
    Body b1 = new Body(123.0F, 18.0F, 26.0F, 0.0F, 0.0F);
    Body b2 = new Body(524.5F, 24.5F, 25.5F, 0.0F, 0.0F);
    Body b3 = new Body(245.0F, 22.4F, 41.0F, 0.0F, 0.0F);
    Leaf quad = Leaf$.MODULE$.apply(15.0F, 30.0F, 20.0F, (Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b1, b2, b3 })));
    ForkJoinTaskSupport trackingTaskSuport = Util$.MODULE$.trackingTaskSuport();
    Simulator simulator = new Simulator((TaskSupport)trackingTaskSuport, new TimeStatistics());
    Seq bodies = simulator.updateBodies((Seq)Seq$.MODULE$.apply((Seq)ScalaRunTime$.MODULE$.wrapRefArray((Object[])new Body[] { b1, b2, b3 }, )), (Quad)quad);
    assert(trackingTaskSuport::$init$$$anonfun$317$$anonfun$1, BarnesHutSuite::$init$$$anonfun$318$$anonfun$2, new Location("/Users/mbovel/moocs/courses/parprog1/barneshut/src/test/scala/barneshut/BarnesHutSuite.scala", 656));
  }
  
  private static final boolean $init$$$anonfun$317$$anonfun$1(ForkJoinTaskSupport trackingTaskSuport$2) {
    return (((Util.CallTracking)trackingTaskSuport$2).numberOfCalls() > 0L);
  }
  
  private static final String $init$$$anonfun$318$$anonfun$2() {
    return "updateBodies should be parallel";
  }
  
  public Duration munitTimeout() {
    return this.munitTimeout;
  }
}
