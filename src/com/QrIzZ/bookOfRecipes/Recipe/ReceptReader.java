package com.QrIzZ.bookOfRecipes.Recipe;

import java.io.IOException;

public class ReceptReader {

   static String[][] allInfo;
   static String decor = "▣====================================================================================▣";

   public static String[][] Write(int numberRecept, int numberFile) throws IOException {
      int i = 0;
      String []files = {"ForEveryDay.txt","DinnerRecpes.txt","SupperRecipes.txt"};
      String text = TextReader.readAllText(files[numberFile-1]);
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
