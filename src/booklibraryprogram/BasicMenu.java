package booklibraryprogram;

import java.io.IOException;
import java.util.Scanner;

public class BasicMenu {
   public static void basicMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        String basicChoice;
        
        boolean basicComplete = false;
        do {
        // Menu heading
        System.out.println("-- Basic User Menu --");    
            
        // Listing all the options the user can select as a basic user
        System.out.println("Please select an option:");
        System.out.println("(1) List Available Books");
        System.out.println("(2) List Withdrawn Books");
        System.out.println("(3) Withdraw Book");
        System.out.println("(4) Return Book");
        System.out.println("(x) Exit"); 
        
        basicChoice = sc.nextLine();
            switch (basicChoice) {
                // 'List Available Books' choice
                case "1" -> {
                    ListAvailableBooks.listBooks();
                    break;
                }
                // 'List Withdrawn Books' choice 
                case "2" -> {
                    ListWithdrawnBooks.listBooks();
                    break;
                }
                // 'Borrow Book' choice
                case "3" -> {
                    WithdrawBook.withdrawBook();
                    basicComplete = true;
                    break;
                }
                // 'Return Book' choice
                case "4" -> {                    
                    ReturnBook.returnBook();
                    basicComplete = true;
                    break;
                }
                // Close
                case "x", "X"-> {
                    basicComplete = true;
                    break;
                }
                // Will keep asking until user inputs a valid input
                default -> System.out.println("Invalid Input: please select an option below");
            }
                 
        } while (!basicComplete);
        sc.close();
    }
 
}
