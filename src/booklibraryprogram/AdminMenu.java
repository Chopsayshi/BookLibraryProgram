package booklibraryprogram;

import java.io.IOException;
import java.util.Scanner;

public class AdminMenu {
    public static void adminMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice;
        
        // Loops default value
        boolean adminComplete = false;
       
        do {    
        // Menu heading
        System.out.println("-- Admin Menu --");    
            
        // Listing all the options the user can select as an admin
        System.out.println("Please select an option:");
        System.out.println("(1) List Available Books");
        System.out.println("(2) List Withdrawn Books");
        System.out.println("(3) Add Book");
        System.out.println("(4) Update Book");
        System.out.println("(5) Delete Book");
        System.out.println("(x) Exit"); 
        
        
        choice = sc.nextLine();
            switch (choice) {
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
                // 'Add Books' choice
                case "3" -> {
                    AddBook.addBook();
                    adminComplete = true;
                    break;
                }
                // 'Update Book' choice
                case "4" -> {  
                    System.out.println("This feature is not added yet please "
                            + "use add and delete for now");
//                    UpdateBook.updateBook();
                    break;
                }
                // 'Remove Book' choice
                case "5" -> {  
                    DeleteBook.deleteBook();
                    adminComplete = true;
                    break;
                }
                // Close
                case "x", "X"-> {
                    adminComplete = true;
                    break;
                }
                 // Will keep asking until user inputs a valid input
                default -> System.out.println("Invalid Input: please select an option below");
            }
                    
        } while (!adminComplete);
        sc.close();
    }
}
