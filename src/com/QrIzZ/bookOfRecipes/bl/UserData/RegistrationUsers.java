package com.QrIzZ.bookOfRecipes.bl.UserData;

import static com.QrIzZ.bookOfRecipes.ui.ChoiseReader.choiceReader;
import static com.QrIzZ.bookOfRecipes.da.ReaderFile.readFile;
import static com.QrIzZ.bookOfRecipes.da.TextWriter.writingTextToFile;

import com.QrIzZ.bookOfRecipes.ui.mainMenu;

import java.io.*;

/** */
public class RegistrationUsers {

   static Register register = new Register();

   public static void main() {
      Register register = new Register();
      System.out.print(" ⚪ Введіть логін => ");
      /** Поле зберігає логін користувача. */
      String Login = choiceReader();
      register.setLogin(Login);

      System.out.print(" ⚪ Введіть пароль => ");
      /** Поле зберігає пароль користувача. */
      String password = choiceReader();
      register.setPassword(password);

      BoleanAutorization ba = new BoleanAutorization();
      /** Поле, що зберігає шлях до файлу. */
      File file = new File("Users.txt");
      for (int i = 0; i < readFile(file).split("\n").length; i++) {
         /** Ім'я зчитане з текстового файлу. */
         String nameTest = readFile(file).split("\n")[i].split("‖")[0];
         /** Пароль зчитаний з текстового файлу. */
         String passwordTest = readFile(file).split("\n")[i].split("‖")[1];
         if (register.getLogin().equals(nameTest)) {
            ba.setAutorization(true);
         }
      }
      if (ba.getisAutorization()){
         System.out.println("Такий користувач вже існує!");
         ba.setAutorization(false);
         main();
      }else {
         writingTextToFile(file, readFile(file),
             register.getLogin() + "‖" + register.getPassword() + '\n');
         ba.setAutorization(true);
         System.out.println("Реєстрація успішна");
         System.out.println(
             "Дякуємо за реєстрація, тепер ви отримуєте по +1 рецепту з кожної категорії");
         mainMenu.main();
      }
   }
   //String hashedUserPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());


}
/** Клас, що зберігає дані користувача для реєстрації. */
class Register {
   /** Поле зберігає логін користувача. */
   private String login;
   /** Поле зберігає пароль користувача.  */
   private String password;

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }
}
