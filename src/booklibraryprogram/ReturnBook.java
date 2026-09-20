package booklibraryprogram;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class ReturnBook {
    public static void returnBook() throws IOException {
        // Setting up inputs
        Scanner scWithdrawn = new Scanner(Paths.get("./resources/withdrawnBooks.txt"));
        PrintWriter pw;
        Scanner s = new Scanner(System.in);
        
        String input;
        int bookNum;
        
        // Loops default value
        boolean finished = false;
        
        // Menu heading
        System.out.println("-- Return Book : (Review 'List "
                + "Withdrawn Books' in the previous menu) --");
        
        // Puts all books into a linked list
        LinkedList<String> withdrawnBooksInfo = new LinkedList<>();
        while (scWithdrawn.hasNext()) {
            withdrawnBooksInfo.add(scWithdrawn.nextLine());
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
                    
                    if ((bookNum > 0) && (bookNum <= withdrawnBooksInfo.size())) {
                       
                        pw = new PrintWriter(new FileOutputStream("./resources/availableBooks.txt",true));
                        pw.println(withdrawnBooksInfo.get(bookNum -1));
                        pw.close();
                        
                        withdrawnBooksInfo.remove(bookNum - 1);
                        
                        try (PrintWriter pwWithdrawn = new PrintWriter(new FileOutputStream(""
                                + "./resources/withdrawnBooks.txt"))) {
                            for (String std : withdrawnBooksInfo) {
                                pwWithdrawn.println(std);
                            }
                        }
                        
                        BasicMenu.basicMenu();
                        finished = true;
                    }
                    else {
                        System.out.println("The number you entered does not "
                                + "match any withdrawn books. Please try again.");
                    }
                }

            } catch (NumberFormatException e) {
                    System.out.println("Invalid input: Please enter an integer:");
                }
        } while (!finished);
    }
}
