package booklibraryprogram;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class WithdrawBook {
    public static void withdrawBook() throws IOException {
        // Setting up inputs
        Scanner scAvailable = new Scanner(Paths.get("./resources/availableBooks.txt"));
        PrintWriter pw;
        Scanner s = new Scanner(System.in);
        
        String input;
        int bookNum;
        
        // Loops default value
        boolean finished = false;
        
        // Menu heading
        System.out.println("-- Withdraw Book : (Review 'List "
                + "Available Books' in the previous menu) --");
        
        // Puts all books into a linked list
        LinkedList<String> availableBooksInfo = new LinkedList<>();
        while (scAvailable.hasNext()) {
            availableBooksInfo.add(scAvailable.nextLine());
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
                       
                        pw = new PrintWriter(new FileOutputStream("./resources/withdrawnBooks.txt",true));
                        pw.println(availableBooksInfo.get(bookNum -1));
                        pw.close();
                        
                        availableBooksInfo.remove(bookNum - 1);
                        
                        try (PrintWriter pwWithdrawn = new PrintWriter(new FileOutputStream(""
                                + "./resources/availableBooks.txt"))) {
                            for (String std : availableBooksInfo) {
                                pwWithdrawn.println(std);
                            }
                        }
                        
                        BasicMenu.basicMenu();
                        finished = true;
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
    }
}
