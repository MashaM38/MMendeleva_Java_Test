package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    System.out.println("My First Program!");

    hello("User!");

    int l=6;
    Square s = new Square(5);
    System.out.println("S квадрата со стороной =" + l + " = " + (l*l));

    System.out.println("S квадрата со стороной =" + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("S прямоугольника со стороной a=" + r.a + " b=" + r.b + " равна " + r.area());

  }

  public static void hello(String somebody){
    System.out.println("Hello " + somebody);
  }

}