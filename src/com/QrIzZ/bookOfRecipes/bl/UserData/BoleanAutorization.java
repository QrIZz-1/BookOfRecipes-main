package com.QrIzZ.bookOfRecipes.bl.UserData;
/** у якому зберігається значення чи авторизований користувач. */

public class BoleanAutorization {

   public static boolean autorization;

   public static boolean getisAutorization() {
      return autorization;
   }

   public void setAutorization(boolean autorization) {
      this.autorization = autorization;
   }
}
