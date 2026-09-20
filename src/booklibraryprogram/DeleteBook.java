package booklibraryprogram;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class DeleteBook {
    public static void deleteBook() throws IOException {
        
        // Setting up inputs
        Scanner sc = new Scanner(Paths.get("./resources/availableBooks.txt"));
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        
        String input;
        int bookNum;
        String check;
        
        // Loops default value
        boolean finished = false;
        
        // Menu heading
        System.out.println("-- Delete Book : (Review 'List "
                + "Available Books' in the previous menu) --");
        
        // Puts all books into a linked list
        LinkedList<String> availableBooksInfo = new LinkedList<>();
        while (sc.hasNext()) {
            availableBooksInfo.add(sc.nextLine());
        }   
        
        do {
            try {
                
                System.out.println("Please enter the books number:");
                input = s.next();

                if ("x".equals(input.toLowerCase())) {
                    finished = true;
                }
                else {
                    bookNum = Integer.parseInt(input);
                    
                    if ((bookNum > 0) && (bookNum <= availableBooksInfo.size())) {
                        
                        System.out.println("Are you sure you want to delete: "
                                + "'"+availableBooksInfo.get(bookNum-1)+"'" + ""+" (y/n)");
                        check = s2.nextLine();
                        
                            switch (check.toLowerCase()) {
                                case "x" -> {
                                    finished = true;
                                    break;
                                }
                                // Deletes book from availableBooks.txt file
                                case "y", "yes" -> {
                                    availableBooksInfo.remove(bookNum - 1);

                                    PrintWriter pw = new PrintWriter(new FileOutputStream(""
                                            + "./resources/availableBooks.txt"));
                                    for (String std : availableBooksInfo) {
                                        pw.println(std);
                                    }   pw.close();

                                    finished = true;
                                    AdminMenu.adminMenu();
                                }
                                // Restarts program
                                case "n", "no" -> {
                                    System.out.println("You cancelled, try again or exit (x)");
                                    break;
                                }
                                // Invalid Input
                                default -> {
                                    System.out.println("Invalid input, please try again:");
                                    break;
                                }
                            }
                    }
                    else {
                        System.out.println("The number you entered does not "
                                + "match any availabe books. Please try again.");
                    }
                }

            } catch (NumberFormatException e) {
                    System.out.println("Invalid input: Please enter an integer:");
                }
        } while (!finished);    
        s.close();
        s2.close();
    }
}
