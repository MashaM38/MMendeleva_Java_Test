package ru.stqa.pft.sandbox;

/**
 * Created by Masha on 14.09.2016.
 */
public class PointProgram {

  public static void main(String[] args) {

    Point p = new Point(2.2, 5.3);
    System.out.println("Расстояние между точками p1=" + p.p1 + " p2=" + p.p2 + " равно " + p.distance());

    Point p2 = new Point(-3, 4);
    System.out.println("Расстояние между точками p1=" + p2.p1 + " p2=" + p2.p2 + " равно " + p2.distance());

    Point p3 = new Point(0, 2);
    System.out.println("Расстояние между точками p1=" + p3.p1 + " p2=" + p3.p2 + " равно " + p3.distance());

    Point p4 = new Point(0,0);
    System.out.println("Расстояние между точками p1=" + p4.p1 + " p2=" + p4.p2 + " равно " + p4.distance());

    Point p5 = new Point(-2, -3);
    System.out.println("Расстояние между точками p1=" + p5.p1 + " p2=" + p5.p2 + " равно " + p5.distance());
  }
}
