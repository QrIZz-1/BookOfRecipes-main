package com.QrIzZ.bookOfRecipes.bl.UserData;

import static com.QrIzZ.bookOfRecipes.ui.ChoiseReader.choiceReader;
import static com.QrIzZ.bookOfRecipes.da.ReaderFile.readFile;

import com.QrIzZ.bookOfRecipes.ui.mainMenu;
import java.io.File;
import java.util.Scanner;
/** Клас, який реалізує функцію Авторизації. */
public class AuthorizationUsers {

   public static void main() {
      /** Одновимірний масив, в якому зберігаються дані користувача. */
      String[] UserData = new String[2];
      try (Scanner scanner = new Scanner(System.in)) {
         /** Поле, в якому зберігається шлях до файлу. */
         File file = new File("Users.txt");

         System.out.print(" ⚪ Введіть логін => ");
         /** Поле, в яке зберігає ім'я користувача. */
         String userName = choiceReader();
         UserData[0] = userName;
         System.out.print(" ⚪ Enter password => ");
         /** В поле, яке зберігає пароль користувача. */
         String password = scanner.nextLine();
         UserData[1] = password;

         BoleanAutorization ba = new BoleanAutorization();

         for (int i = 0; i < readFile(file).split("\n").length; i++) {
            /** Поле, яке зберігає ім'я з текстового файлу, авторизації. */
            String nameTest = readFile(file).split("\n")[i].split("‖")[0];
            /** Поле, яке зберігає пароль з текстового файлу, авторизації. */
            String passwordTest = readFile(file).split("\n")[i].split("‖")[1];
            if (UserData[0].equals(nameTest)) {
               if (UserData[1].equals(passwordTest)) {
                  ba.setAutorization(true);
                  System.out.println("Авторизація успішна!");
                  mainMenu.main();
                  break;
               } else {
                  System.out.println("Невірний пароль!");
                  main();
               }
            }
         }
         System.out.println("Користувача з таким іменем не існує!");
         main();
      }
   }
}

