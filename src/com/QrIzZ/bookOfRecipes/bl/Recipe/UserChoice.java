package com.QrIzZ.bookOfRecipes.bl.Recipe;

import java.util.Scanner;
/**  Класи, який зчитує дані, що вводить користувач. */
public class UserChoice {

  /** Метод, який отримує вибір користувача.
   * @param numberRows Кількість рядків меню.
   *  */
  public static byte Choice(int numberRows) {
    System.out.println("Виберіть пункт:");
    /** поле, в яке зберігається вибір користувача. */
    byte el = 0;
    /** Поле, що вказує чи дані коректні. */
    boolean valide = false;
    while (!valide) {
      Scanner scanner = new Scanner(System.in);
      try {
        el = scanner.nextByte();
        if (el > numberRows && el < 0) {
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
