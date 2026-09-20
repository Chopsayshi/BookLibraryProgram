package booklibraryprogram;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class AddBook {
    public static void addBook() throws IOException { 
        
        // Preparing inputs
        Scanner s = new Scanner(System.in);
        String title = null;
        String author = null;
        String confirmAdd;
    
        // Menu heading
        System.out.println("-- Add Book --");
        
        // Loops default value
        boolean finished = false;
        boolean finished2 = false;
        
        // Will force each stage to loop until a valid input is given
        int stage = 1; 
        
        do {
            switch (stage) {
                // Asking for a 'book title' until a valid input is given
                case 1 -> {
                    System.out.println("Please enter the books title:");
                    title = s.nextLine();

                    // Exit clause
                    if (title.toLowerCase().equals("x")) {
                        finished = true;
                        break;
                    }
                    // Invlaid input : user does not set a title
                    else if (title.isEmpty()){
                        System.out.println("No title was given, please try again:");
                    }
                    //  Will move to the next stage after a valid input is given
                    else {
                        stage++;
                        break;
                    }
                }
                // Asking for a 'book author' until a valid input is given
                case 2 -> {
                    System.out.println("Please enter the books author: ");
                    author = s.nextLine();
                    if (author.toLowerCase().equals("x")) {
                        finished = true;
                        break;
                    }
                    else if (author.isEmpty()) {
                        System.out.println("No author was given, please try again:");
                    }
                    else {
                        stage++;
                        break;
                    }
                }
                case 3 -> {
                   do {
                    // Creating book object for user to add to before adding to book.txtfile
                    Book newBook = new Book(title, author);
                    System.out.println("Book details:");
                    System.out.println("'"+newBook.getTitle() + " by " + newBook.getAuthor()+"'");

                    // Final check before adding this book to the books.txt document
                    System.out.println("If these details are correct select "
                            + "Y to add otherwise enter to cancel");
                    confirmAdd = s.nextLine();

                    switch (confirmAdd.toLowerCase()) {
                        case "x" ->  {
                            finished2 = true;
                            stage = 5;
                            break;
                        }
                        case "y" -> {

                            Scanner sc = new Scanner(Paths.get("./resources/availableBooks.txt"));

                            // Puts all books into a linked list
                            LinkedList<String> availableBooksInfo = new LinkedList<>();
                            while (sc.hasNext()) {
                                availableBooksInfo.add(sc.nextLine());
                            }   availableBooksInfo.add(newBook.toString());

                            PrintWriter pw = new PrintWriter(new FileOutputStream("./resources/availableBooks.txt"));
                            for (String std : availableBooksInfo) {
                                pw.println(std);
                            }   pw.close();
                            stage++;
                            finished2 = true;
                            break;
                        }
                        default -> {
                            System.out.println("You canceled, try again or enter 'x' to exit");
                            finished2 = true;
                            stage = 1;
                            break;
                        }
                    }

                    }while (!finished2);
                }
                // Valid exit will return to Admin menu
                case 4 -> {
                    finished = true;
                    AdminMenu.adminMenu();
                    break;
                }
                // Exits if x is entered
                case 5 -> {
                    finished = true;
                    break;
                }
            }
        } while (!finished);        
        
        s.close();
        
    }
}