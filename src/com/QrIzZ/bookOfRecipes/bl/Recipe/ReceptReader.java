package com.QrIzZ.bookOfRecipes.bl.Recipe;

import com.QrIzZ.bookOfRecipes.da.TextReader;
import java.io.IOException;
/**
 * Клас для виводу даних про рецепти
 */
public class ReceptReader {

   /** масив який зберігає дані про рецепти */
   static String[][] allInfo;
   /** Поле що зберігає декоративний елемент */
   static String decor = "▣====================================================================================▣";
   /** Метод для читання рецептів
    * @param numberRecept вивід блоку меню який потрібно вивести
    * @param numberFile число що вказує на номер тхт файлу над яким виконувати операції
    * */
   public static String[][] Write(int numberRecept, int numberFile) throws IOException {
      int i = 0;
      /** Масив, в якому зберігаються назви файлів. */
      String []files = {"Breakfast.txt","DinnerRecpes.txt","SupperRecipes.txt"};
      /** Поле, в якому зберігаються дані зчитані з файлу. */
      String text = TextReader.readAllText(files[numberFile-1]);
      /** Масив, в якому зберігаються дані розбиті на окремі блоки. */
      String[] numberBlock = text.split("⁙")[1].split("▣");
      allInfo = new String[numberBlock.length][4];

      //name
      allInfo[numberRecept][0] = numberBlock[numberRecept].split("⁕")[0];
      //ingredients
      allInfo[numberRecept][1] = numberBlock[numberRecept].split("⁕")[1].split("⌂")[0];
      //Method of cooking
      allInfo[numberRecept][2] = numberBlock[numberRecept].split("⁕")[1].split("⌂")[1];
      //MainInfo
      allInfo[numberRecept][3] = numberBlock[numberRecept].split("⁕")[1].split("⌂")[2];
      System.out.println(
          '\n' + decor + '\n' + "  "
              + allInfo[numberRecept][0] + '\n' + decor
      );
      readText(1, numberRecept, "\n", "Інгредієнти:");
      readText(2, numberRecept, "₱", "Процес приготування:");
      readText(3, numberRecept, "\n", "Загальні відомості:");
      //  readText(3,i,"\n");

      i++;
      return allInfo;
   }
   /** Функція, що виводить дані в консолі.
    * @param  punkt Параметр що зберігає номер блоку з яким будуть проводитися операції.
    * @param  i Параметр що вказує який рядок масиву потрібно використовувати.
    * @param  split Параметр що зберігає елемент, за яким буде розбиватись цей блок.
    * @param  title Параметр що зберігає заголовок блоку.
    * */
   public static void readText(int punkt, int i, String split, String title) {
      System.out.println('\n' + "  " + title + '\n' + decor);
      for (int n = 1; n < allInfo[i][punkt].split(split).length - 1; n++) {
         if (punkt != 2) {
            System.out.print("   " + n + " )  " + allInfo[i][punkt].split(split)[n + 1] + '\n');
         } else {
            System.out.print("   " + n + " )  " + allInfo[i][punkt].split(split)[n + 1]);
         }
      }
   }
}
