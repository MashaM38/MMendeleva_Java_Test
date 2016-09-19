package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Masha on 19.09.2016.
 */
public class PointTests {

  @Test
  public void testDistanceForPositivePoint(){
    Point p1 = new Point(1, 3);
    Point p2 = new Point(3, 5);

    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);
  }

  @Test
  public void testDistanceForNumberWithFloatPoint(){
    Point p1 = new Point(1, 3);
    Point p2 = new Point(4.5, 9.75);

    Assert.assertEquals(p1.distance(p2), 7.603453162872775);
  }

  @Test
  public void testDistanceForNegativeAndPositivePoints(){
    Point p1 = new Point(1, 3);
    Point p2 = new Point(-3, 8);

    Assert.assertEquals(p1.distance(p2), 6.4031242374328485);
  }

  @Test
  public void testDistanceForZeroAndPositivePoints(){
    Point p1 = new Point(1, 3);
    Point p2 = new Point(0, 0);

    Assert.assertEquals(p1.distance(p2), 3.1622776601683795);
  }

  @Test
  public void testDistanceForNegativePoints(){
    Point p1 = new Point(1, 3);
    Point p2 = new Point(-2, -3);

    Assert.assertEquals(p1.distance(p2), 6.708203932499369);
  }
}
