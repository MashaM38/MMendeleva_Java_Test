package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by masha on 05.10.16.
 */
public class Collections {

  public static void main(String[] args){
    String[] langs = {"Java", "C£", "Python", "PHP"};

    List<String> languages = new ArrayList<>();
    languages.add("Java");
    languages.add("C£");
    languages.add("Python");
    languages.add("PHP");

    List<String> languages2 = Arrays.asList("Java", "C£", "Python", "PHP");

    for(String l: languages){
      System.out.println("I want to learn " + l);
    }

    for(int i=0; i< languages2.size(); i++){
      System.out.println("I want to learn2 " + languages2.get(i));
    }
  }
}
