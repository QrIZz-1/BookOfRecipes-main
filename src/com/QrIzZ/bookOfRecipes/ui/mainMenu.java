package com.QrIzZ.bookOfRecipes.ui;

import com.QrIzZ.bookOfRecipes.bl.Recipe.ReceptConstructor;
import com.QrIzZ.bookOfRecipes.bl.Recipe.ReceptReader;
import com.QrIzZ.bookOfRecipes.da.TextReader;
import com.QrIzZ.bookOfRecipes.bl.Recipe.UserChoice;
import com.QrIzZ.bookOfRecipes.bl.UserData.AuthorizationUsers;
import com.QrIzZ.bookOfRecipes.bl.UserData.BoleanAutorization;
import com.QrIzZ.bookOfRecipes.bl.UserData.RegistrationUsers;
import java.io.IOException;
import java.util.Scanner;
/**
 * Головне меню.
 */
public class mainMenu {
   /**
    * Зміна, яка зберігає вибір пункту користувача.
    */
   static int el = 0;
   static final String RESET = "\u001b[0m";
   static final String BLACk = "\u001b[30m";
   static final String RED = "\u001b[31m";
   static final String GREEN = "\u001b[32m";
   static final String YELLOW = "\u001b[33m";
   static final String BLUE = "\u001b[34m";
   static final String PURPLE = "\u001b[35m";
   static final String CYAN = "\u001b[36m";
   static final String WHITE = "\u001b[37m";
   /**
    * Метод, який виводить в консоль графічну частину основного меню.
    */
   public static void menuPrint() {
      BoleanAutorization ba = new BoleanAutorization();
      System.out.println(" ▣**********____________________________________**********▣ \n" +
          "((                                                       ))\n" +
          " )) \uD83D\uDCDA Ласкаво просимо до книги Українських рецептів \uD83D\uDCDA (( \n" +
          "((                                                       ))\n" +
          " ▣**********____________________________________**********▣  ");
      if (!ba.getisAutorization()) {
         System.out.println(GREEN + "<<[1]>> ➡️ Авторизація ⬅️" + RESET);
      } else {
         System.out.println(GREEN + "<<[1]>> ➡️ Авторизація успішна!!! ⬅️" + RESET);
      }
      System.out.println(GREEN + "<<[2]>> ➡️ Реєстрація ⬅️" + RESET);
      System.out.println(GREEN + "<<[3]>> ➡️ Перегляд рецептів ⬅️" + RESET);
      System.out.println(GREEN + "<<[4]>> ➡️ Конструктор рецептів ⬅️" + RESET);
   }
   /**
    * Метод, що визиває потрібні функції для логіки головного меню.
    */
   public static void main() {
      Scanner userInput = new Scanner(System.in);
      menuPrint();
      while (userInput.hasNext()) {
         menuChoice(userInput.nextInt());
      }
   }
   /**
    * Головне меню.
    *
    * @param numMenu Пункт, який вибрав користувач.
    */
   public static void menuChoice(int numMenu) {
      ReceptConstructor receptConstructor = new ReceptConstructor();
      switch (numMenu) {
         case 1:
            autorization();
            break;
         case 2:
            registration();
            break;
         case 3:
            viewRecipes();
            break;
         case 4:
            receptConstructor.AaddText();
            break;
         default:
            System.out.println(RED + "<<---Ви вибрали пункт якого не існує!--->>" + RESET);
      }
   }
   /**
    * Меню вибору типів страв, графічна частина
    */
   public static int startMenuChoice() {
      System.out.println("▣=============================▣" + '\n' + "Типи страв!" + '\n'
          + "▣=============================▣" + '\n');
      /** Масив, в якому зберігаються всі пункти меню. */
      String[] punkts = {"Сніданок", "Обід", "Вечеря", "Головне меню"};
      for (int i = 0; i < punkts.length; i++) {
         System.out.println((i + 1) + ")" + punkts[i]);
      }

      while (1 == 1) {
         try {
            el = UserChoice.Choice(punkts.length);
            if (el > 0 && el <= punkts.length) {
               break;
            } else {
               System.out.println("Такого пункту немає!");
            }
         } catch (Exception e) {
            System.out.println("Не коректні дані!");
         }
      }
      return el;
   }

   /**
    * Меню вибору типів страв
    */
   public static int startMenu() throws IOException {

      el = startMenuChoice();
      switch (el) {
         case 1:
            menuBrecfast();
            break;
         case 2:
            menuDiner();
            break;
         case 3:
            menuSuper();
            break;
         case 4:
            main();
            break;
      }
      return el;
   }

   /**
    * Перелік текстових файлів.
    */
   static String[] files = {"Breakfast.txt", "DinnerRecpes.txt", "SupperRecipes.txt"};
   /**
    * Рецепти на сніданок.
    */
   public static void menuBrecfast() throws IOException {
      /** Дані з файлу.  */
      String text = TextReader.readAllText(files[0]);
      /** Масив, в якому зберігаються всі рецепти, розбиті по блочно. */
      String[] numberBlock = new String[text.split("▣").length + 1];
      for (int i = 1; i < text.split("⁙")[1].split("▣").length + 2; i++) {
         if (i < numberBlock.length - 1) {
            numberBlock[i - 1] = text.split("⁙")[1].split("▣")[i].split("⁕")[0];
         }
         if (i == numberBlock.length - 1) {
            numberBlock[i - 1] = "Головне меню";
         } else if (i == numberBlock.length) {
            numberBlock[i - 1] = "Вихід";
         }
      }
      /** Масив, в якому зберігаються всі рецепти, розбиті по блочно.  */
      String[] punkts = numberBlock;
      mainMenu.menu("Оиберіть сніданок!", punkts, 1);
   }
   /**
    * Рецепти на обід.
    */
   public static void menuDiner() throws IOException {
      /** Дані з файлу.  */
      String text = TextReader.readAllText(files[1]);
      /** Масив, в якому зберігаються всі рецепти, розбиті по блочно. */
      String[] numberBlock = new String[text.split("▣").length + 1];
      for (int i = 1; i < text.split("⁙")[1].split("▣").length + 2; i++) {
         if (i < numberBlock.length - 1) {
            numberBlock[i - 1] = text.split("⁙")[1].split("▣")[i].split("⁕")[0];
         }
         if (i == numberBlock.length - 1) {
            numberBlock[i - 1] = "Головне меню";
         } else if (i == numberBlock.length) {
            numberBlock[i - 1] = "Вихід";
         }
      }
      /** Масив, в якому зберігаються всі рецепти, розбиті по блочно. */
      String[] punkts = numberBlock;
      mainMenu.menu("Оиберіть обід!", punkts, 2);
   }
   /**
    * Рецепти на вечерю.
    */
   public static void menuSuper() throws IOException {
      /** Дані з файлу.  */
      String text = TextReader.readAllText(files[2]);
      /** Масив, в якому зберігаються всі рецепти, розбиті по блочно. */
      String[] numberBlock = new String[text.split("▣").length + 1];
      for (int i = 1; i < text.split("⁙")[1].split("▣").length + 2; i++) {
         if (i < numberBlock.length - 1) {
            numberBlock[i - 1] = text.split("⁙")[1].split("▣")[i].split("⁕")[0];
         }
         if (i == numberBlock.length - 1) {
            numberBlock[i - 1] = "Головне меню";
         } else if (i == numberBlock.length) {
            numberBlock[i - 1] = "Вихід";
         }
      }
      /** Масив, в якому зберігаються всі рецепти, розбиті по блочно. */
      String[] punkts = numberBlock;
      mainMenu.menu("Оиберіть вечерю!", punkts, 3);
   }

   /**
    * @param title    Заголовок.
    * @param punkts   Блок, з яким потрібно працювати.
    * @param nextMenu Куди далі повернеться програма.
    */
   public static void menu(String title, String[] punkts, int nextMenu) throws IOException {
      menuUkraine();
      System.out.println("▣=============================▣" + '\n' + title + '\n'
          + "▣=============================▣" + '\n');

      for (int i = 0; i < punkts.length; i++) {
         System.out.println((i + 1) + ")" + punkts[i]);
      }
      el = UserChoice.Choice(punkts.length);
      if (el <= punkts.length - 2) {
         ReceptReader.Write(el, nextMenu);
         if (nextMenu == 1) {
            menuBrecfast();
         } else if (nextMenu == 2) {
            menuDiner();
         } else if (nextMenu == 3) {
            menuSuper();
         }
      } else if (el == punkts.length - 1) {
         startMenu();
      } else if (el == punkts.length) {
      }
   }

   public static void autorization() {
      AuthorizationUsers.main();
   }

   public static void registration() {
      RegistrationUsers.main();
   }

   public static void viewRecipes() {
      try {
         startMenu();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   public static void menuUkraine() {
      print(BLUE);
      print(BLUE);
      print(YELLOW);
      print(YELLOW);
   }

   public static void print(String color) {
      for (int i = 0; i < 60; i++) {
         System.out.print(color + "\u058D" + RESET);
      }
      System.out.println();
   }


}
