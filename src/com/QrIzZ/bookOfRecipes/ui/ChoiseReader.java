package com.QrIzZ.bookOfRecipes.ui;

import java.util.Scanner;
/** Клас для зчитування вибору користувача.  */
public class ChoiseReader {
   /** Отримання вибору користувача.
    * @return Вибір користувача.
    * */
   public static String choiceReader() {
      Scanner scanner = new Scanner(System.in);
      /** В поле, в якому зберігається вибір. */
      String element;
      while (1 == 1) {
         try {
            element = scanner.nextLine();
            if (element.length() >= 3) {
               break;
            } else {
               System.out.println("Ці дані повинні бути довжиною не менше 3 символів!");
            }
         } catch (Exception e) {
            System.out.println("Уведені не коректні дані!");
         }
      }
      return element;
   }
}
