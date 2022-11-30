package com.QrIzZ.bookOfRecipes;

import com.QrIzZ.bookOfRecipes.Recipe.ReceptReader;
import com.QrIzZ.bookOfRecipes.Recipe.UserChoice;
import com.QrIzZ.bookOfRecipes.byUsers.AuthorizationUsers;
import com.QrIzZ.bookOfRecipes.byUsers.RegistrationUsers;
import java.io.IOException;
import java.util.Scanner;


public class mainMenu {

   static int el = 0;
    static  final  String RESET = "\u001b[0m";
    static  final  String BLACk = "\u001b[30m";
    static  final  String RED = "\u001b[31m";
    static  final  String GREEN = "\u001b[32m";
    static  final  String YELLOW = "\u001b[33m";
    static  final  String BLUE = "\u001b[34m";
    static  final  String PURPLE = "\u001b[35m";
    static  final  String CYAN = "\u001b[36m";
    static  final  String WHITE = "\u001b[37m";

   public static void startMenu() throws IOException {
      System.out.println("▣=============================▣" + '\n' + "Типи страв!" + '\n'
          + "▣=============================▣" + '\n');

      String[] punkts = {"Сніданок", "Обід", "Вечеря", "Вийти"};
      for (int i = 0; i < punkts.length; i++) {
         System.out.println((i + 1) + ")" + punkts[i]);
      }
      el = UserChoice.Choice(punkts.length);

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
            break;
      }

   }

   public static void menuBrecfast() throws IOException {
      String[] punkts = {
          "Французький тост до сніданку",
          "Оладки на кефірі з яблуками без дріжджів",
          "Омлет з овочами на сніданок",
          "Швидкі гарячі бутерброди на сніданок",
          "Як приготувати фріттату в духовці",
          "Головне меню",
          "Вихід"};

      mainMenu.menu("Оиберіть сніданок!", punkts, 1);
   }
    public static void menuDiner() throws IOException {
        String[] punkts = {
            "Як запекти свинину в духовці",
            "к приготувати борщ з домашньої курки",
            "Курячі стегенця в духовці",
            "Бограч по-закарпатськи",
            "Паста Болоньєзе",
            "Головне меню",
            "Вихід"};

        mainMenu.menu("Оиберіть обід!", punkts, 2);
    }
    public static void  menuSuper() throws IOException {
        String[] punkts = {
            "Як запекти свинину в духовці",
            "к приготувати борщ з домашньої курки",
            "Курячі стегенця в духовці",
            "Бограч по-закарпатськи",
            "Паста Болоньєзе",
            "Головне меню",
            "Вихід"};

        mainMenu.menu("Оиберіть вечерю!", punkts, 3);
    }

   public static void menu(String title, String[] punkts, int nextMenu) throws IOException {

      System.out.println("▣=============================▣" + '\n' + title + '\n'
          + "▣=============================▣" + '\n');

      for (int i = 0; i < punkts.length; i++) {
         System.out.println((i + 1) + ")" + punkts[i]);
      }
      el = UserChoice.Choice(punkts.length);
      if (el <= punkts.length - 2) {
         ReceptReader.Write(el,nextMenu);
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

    public static void menu (){
        print(BLUE);
        print(BLUE);
        print(YELLOW);
        print(YELLOW);
    }

    public static void print (String color){
        for (int i = 0; i < 60; i++) {
            System.out.print(color + "\u058D");
        }
        System.out.println();
    }

    public static void menuPrint() {
        System.out.println("<<[1]>> - --Авторизація;--");
        System.out.println("<<[2]>> - --Реєстрація;--");
        System.out.println("<<[3]>> - --Перегляд рецептів;--");
    }


    public static void menuChoice(int numMenu) {
        switch (numMenu) {
            case 1 : autorization();
                break;
            case 2 : registration();
                break;
            case 3 : viewRecipes();
                break;
            default:
                System.out.println("<<---Ви вибрали пункт якого не існує!--->>");
        }
    }

    public static void main() {
        Scanner userInput = new Scanner(System.in);
        menuPrint();
        while (userInput.hasNext()){
            menuChoice(userInput.nextInt());
        }
    }

}
