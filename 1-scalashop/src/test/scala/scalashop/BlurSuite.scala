package scalashop

import java.util.concurrent.*
import scala.collection.*

class BlurSuite extends munit.FunSuite:
  // Put tests here
  test("boxBlurKernel works as intended"){
    val img = Img(10,10)
    for(i <- 0 to 8)
      for (j <- 0 to 8)
        img.update(i,j,1) 
    for(i <- 0 to 8)
      img.update(0,9, 9)
    for (j <- 1 to 9)
      img.update(9,j, 9)
    
    println(img)
    assertEquals(boxBlurKernel(img, 0, 0, 8), 1)
  }
