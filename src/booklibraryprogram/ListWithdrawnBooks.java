package booklibraryprogram;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class ListWithdrawnBooks {
   public static void listBooks() throws IOException {
       
       // Menu heading
        System.out.println("-- List Books: Withdrawn --");
       
        // Withdrawn Books
        Scanner s = new Scanner(Paths.get("./resources/withdrawnBooks.txt"));
        
        // Will loop through all the lines in the "'withdrawnBooks.txt'" 
        // and store each line into the linked list
        LinkedList<String> withdrawnBooksInfo = new LinkedList<>();
        while (s.hasNext()) {
            withdrawnBooksInfo.add(s.nextLine()); 
        }
        
        System.out.println("Here are all the books currently withdrawn:");
        System.out.println("--------------------------------------------");
        
        // Prints out every book reviously saved into the linked list
        int withdrawnIndex = 1;
        for (String i : withdrawnBooksInfo) {
            System.out.println("("+withdrawnIndex +") "+i);
            withdrawnIndex++;
        }
        System.out.println("--------------------------------------------");

        s.close();
    } 
}
