package com.QrIzZ.bookOfRecipes.byUsers;

import java.util.Scanner;

public class AuthorizationUsers {
    public static void main() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(" Enter user name => ");
            String userName = scanner.nextLine();

            System.out.print(" Enter password => ");
            String password = scanner.nextLine();


            if ("ramesh".equals(userName) && "password".equals(password)) {
                System.out.println(" User successfully logged-in.. ");
            } else {
                System.out.println(" In valid userName of password ");
            }
        }
    }
}
