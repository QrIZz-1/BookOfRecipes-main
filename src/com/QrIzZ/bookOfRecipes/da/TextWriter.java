package com.QrIzZ.bookOfRecipes.da;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/** Клас для запису даних в файл. */
public class TextWriter {
   /**
    * Запис даних в файл.
    * @param file Шлях до файлу.
    * @param pastText  Попередній текст файлу.
    * @param textWritten  Дані, що повинні додатися.
    * */
   public static void writingTextToFile(File file, String pastText, String textWritten) {
      PrintWriter pw = null;
      try {
         pw = new PrintWriter(file);
         String newText = pastText;
         newText += textWritten;
         pw.write(newText);
         pw.close();

      } catch (IOException e) {
         System.out.println("Error: " + e);
      }
   }
}
