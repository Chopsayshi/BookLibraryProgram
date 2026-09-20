package booklibraryprogram;

import java.io.IOException;
import java.util.Scanner;

public class BookLibraryProgram {
    public static void main(String[] args) throws IOException { 
               
        // Prepare scanner for input
        Scanner sc = new Scanner(System.in);
        String choice;
  
        boolean menuComplete = false;
        
        // Welcomes the user and checks which user view they are accessing
        System.out.println("--------------------------");
        System.out.println(" - = LIBRARY PROGRAM = -");
        System.out.println("--------------------------");
        System.out.println("* For a better user experience expand the "
                + "output window when running ");
    
        do {
            // Menu options
            System.out.println("Select your account type:");
            System.out.println("(1) Admin");
            System.out.println("(2) Basic");
            System.out.println("(x) Exit");

            choice = sc.nextLine();

            switch (choice) {
                // Admin User
                case "1" -> { 
                    menuComplete = true;
                    AdminMenu.adminMenu();
                    break;
                }
                // Basic User
                case "2" -> {
                    menuComplete = true;
                    BasicMenu.basicMenu();
                    break;
                }
                // Close
                case "x", "X" -> {
                    menuComplete = true;
                    break;
                }
                // Will keep asking until user inputs a valid input
                default -> System.out.println("Invalid Input: please select an option below");
            }
                    
        } while (!menuComplete);
        sc.close();
    }
}