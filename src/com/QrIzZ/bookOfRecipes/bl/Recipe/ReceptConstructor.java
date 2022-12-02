package com.QrIzZ.bookOfRecipes.bl.Recipe;
import static com.QrIzZ.bookOfRecipes.da.TextWriter.writingTextToFile;
import com.QrIzZ.bookOfRecipes.da.TextReader;
import com.QrIzZ.bookOfRecipes.ui.mainMenu;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас для додавання рецептів користувачем, через програму
 */
public class ReceptConstructor {
   /**  Масив який зберігає різні шляхи до файлу  */
   String[] files = {"Breakfast.txt", "DinnerRecpes.txt", "SupperRecipes.txt"};
   /**
    *Метод отримання та записування даних
    */
   public void AaddText() {
      Scanner scanner = new Scanner(System.in);
      /**  Поле яке зберігає вибір користувача  */
      int el = mainMenu.startMenuChoice();
      /**  Поле яке зберігаєвсі дані тхт файлу  */
      String text;
      /**  Поле яке зберігає новий рецепт  */
      String result = "";
      System.out.println(el);

      try {
         text = TextReader.readAllText(files[el - 1]);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      /**  Поле яке зберігає неймовірну силу і стійкість однойменного героя "Ахілеса", використовується для безкінечного циклу  */
      boolean Ahiles = true;


      System.out.println("Введіть Назву страви:");
      /**  Поле яке зберігає назву рецепту  */
      String title = "▣"+scanner.nextLine() + "⁕"+'\n';
      /**  Поле яке використовується для номерації пунктів  */
      int number = 0;
      result += title;
      /**  Поле яке зберігає перелік інгредієнтів  */
      String ingred = "";
      ingred += "Інгредієнти \uD83D\uDCC4:" + '\n';
      System.out.println("Додайте інгредієнт!" + '\n' + "Щоб завершити додавання введіть 0 !!!!");
      while (Ahiles) {
         try {
            el = scanner.nextByte();
            if (el == 0){
               break;
            }
         }catch (Exception e){
            ingred += scanner.nextLine() + '\n';
            System.out.println((number+1) + ") Інгредіент додано. ");
            number++;
         }
      }
      ingred += "⌂" + '\n';
      result += ingred;
      number = 0;
      /**  Поле яке зберігає етапи приготування  */
      String etapCooking = "";
      System.out.println("Додайте етапи приготування!" + '\n' + "Щоб завершити додавання введіть 0 !!!!");
      etapCooking += "Процес приготування неймовірно смачного сніданку."+'\n';
      while (Ahiles) {
         try {
            el = scanner.nextByte();
            if (el == 0){
               break;
            }
         }catch (Exception e){
            etapCooking += "₱"+scanner.nextLine() + '\n';
            System.out.println((number+1) + ") Етап додано. ");
            number++;
         }
      }
      etapCooking += "⌂" + '\n';
      result += etapCooking;
      /**  Поле яке зберігає перелік характеристик  */
      String Harakteristik = "";
      number = 0;
      System.out.println("Додайте додаткові критерії!" + '\n' + "Щоб завершити додавання введіть 0 !!!!");
      while (Ahiles) {
         try {
            el = scanner.nextByte();
            if (el == 0){
               break;
            }
         }catch (Exception e){
            Harakteristik += scanner.nextLine() + '\n';
            System.out.println((number+1) + ") Критерій додано. ");
            number++;

         }
      }
      result += Harakteristik;

      /**  Поле яке зберігає шлях до файлу, в який здійсниться запис даних */
      File file = new File("Resourses/"+files[el]);
      writingTextToFile(file, text, result);
      mainMenu.main();
   }





}
