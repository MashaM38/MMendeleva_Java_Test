package ru.stqa.pft.sandbox;

/**
 * Created by Masha on 14.09.2016.
 */
public class PointProgram {

  public static void main(String[] args) {

    Point p11 = new Point(1, 3);
    Point p12 = new Point(3, 5);

    System.out.println("Расстояние между точками p1 и p2 = " + distance(p11, p12));

    Point p21 = new Point(1, 3);
    Point p22 = new Point(3, 5);
    System.out.println("Расстояние между точками p1(" + p21.x + ", "+ p21.y + ")" + " и p2(" + p22.x + ", "+ p22.y + ") равно = " + p21.distance(p22));

    Point p31 = new Point(1, 3);
    Point p32 = new Point(4.5, 9.75);
    System.out.println("Расстояние между точками p1(" + p31.x + ", "+ p31.y + ")" + " и p2(" + p32.x + ", "+ p32.y + ") равно = " + p31.distance(p32));

    Point p41 = new Point(1, 3);
    Point p42 = new Point(-3, 8);
    System.out.println("Расстояние между точками p1(" + p41.x + ", "+ p41.y + ")" + " и p2(" + p42.x + ", "+ p42.y + ") равно = " + p41.distance(p42));

    Point p51 = new Point(1, 3);
    Point p52 = new Point(0, 0);
    System.out.println("Расстояние между точками p1(" + p51.x + ", "+ p51.y + ")" + " и p2(" + p52.x + ", "+ p52.y + ") равно = " + p51.distance(p52));

    Point p61 = new Point(1, 3);
    Point p62 = new Point(-2, -3);
    System.out.println("Расстояние между точками p1(" + p61.x + ", "+ p61.y + ")" + " и p2(" + p62.x + ", "+ p62.y + ") равно = " + p61.distance(p62));
  }

  public static double distance(Point p1, Point p2){
    return Math.sqrt((Math.pow((p2.x - p1.x),2)) + (Math.pow((p2.y - p1.y),2)));
  }
}
