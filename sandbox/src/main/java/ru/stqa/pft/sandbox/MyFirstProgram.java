package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    System.out.println("My First Program!");

    hello("User!");

    int l=6;
    double len =5;

    System.out.println("S квадрата со стороной =" + l + " = " + (l*l));

    System.out.println("S квадрата со стороной =" + len + " = " + area(len));

    double a = 4;
    double b = 6;
    System.out.println("S прямоугольника со стороной a =" + a + " b=" + b + " равна " + area(a, b));

  }

  public static double area(double l){
    return l*l;
  }

  public static double area(double a, double b){
    return a * b;
  }

  public static void hello(String somebody){
    System.out.println("Hello " + somebody);
  }

}