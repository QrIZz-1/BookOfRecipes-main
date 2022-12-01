package com.QrIzZ.bookOfRecipes.da;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/** */
public class ReaderFile {
   /**
    * Клас, який читає дані з файлу.
    * @param file Шлях до файлу.
    * */
   public static String readFile(File file) {
      /** Поле, яке зберігає дані з файлу. */
      String TextFiles = "";
      BufferedReader br = null;
      try {
         br = new BufferedReader(new FileReader("Users.txt"));
         String line;
         while ((line = br.readLine()) != null) {
            TextFiles += line + "\n";
         }

      } catch (IOException e) {
         System.out.println("Error: " + e);

      } finally {
         try {
            br.close();
         } catch (IOException e) {
            System.out.println("Error: " + e);

         }
      }
      return TextFiles;
   }
}
