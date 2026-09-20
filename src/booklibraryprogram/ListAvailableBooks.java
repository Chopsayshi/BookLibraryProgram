package booklibraryprogram;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class ListAvailableBooks {
    public static void listBooks() throws IOException {
        
       // Menu heading
        System.out.println("-- List Books: Available --");
       
        // Available Books
        Scanner s = new Scanner(Paths.get("./resources/availableBooks.txt"));
        
        // Will loop through all the lines in the "'availableBooks.txt'" 
        // and store each line into the linked list
        LinkedList<String> availableBooksInfo = new LinkedList<>();
        while (s.hasNext()) {
            availableBooksInfo.add(s.nextLine()); 
        }
        
        System.out.println("Here are all the books currently available:");
        System.out.println("--------------------------------------------");
        
        // Prints out every book reviously saved into the linked list
        int availableIndex = 1;
        for (String i : availableBooksInfo) {
            System.out.println("("+availableIndex +") "+i);
            availableIndex++;
        }
        System.out.println("--------------------------------------------");
        
        s.close();
    } 
}
