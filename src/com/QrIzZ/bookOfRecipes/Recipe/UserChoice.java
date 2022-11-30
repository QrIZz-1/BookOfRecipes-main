package com.QrIzZ.bookOfRecipes.Recipe;

import java.util.Scanner;

public class UserChoice {

  public static byte Choice(int numberRows) {
    System.out.println("Виберіть пункт:");
    Scanner scanner = new Scanner(System.in);
    byte el = 0;
    boolean valide = false;
    while (!valide) {
      try {
        el = scanner.nextByte();
        if (el > numberRows || el < 0) {
          System.out.println("Виберіть існуючий пункт--->");
        }
        if (el > 0 && el <= numberRows) {
          valide = true;
        }
      } catch (Exception e) {
        System.out.println("Не вірні дані!--->");
      }
    }
    return el;
  }

}
