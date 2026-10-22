
package BookLibraryProgramV2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListBooks {
    DBManager db = new DBManager();
    
    // Adjusted 'getAllCars' lab demo
    public List<Book> getAllBooks() {
                
        List<Book> bookList = new ArrayList<>();
        ResultSet rs = db.queryDB("select * from book");
        
        try {
            while (rs.next()) {
                int bookid = rs.getInt("bookid");
                String title = rs.getString("title");
                String author = rs.getString("author");
                boolean available = rs.getBoolean("available");

                Book b = new Book(title,author);
                bookList.add(b);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ListBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }
    
    
    
    public static void main(String args[]) {
        ListBooks gb = new ListBooks();
        List<Book> bookList = gb.getAllBooks();
        for (Book b : bookList) {
            System.out.println(b.toString());
        }
        
        System.out.println("Counted Books: "+CountBooks.countBooks());
        gb.db.closeConnections();
    }
}
