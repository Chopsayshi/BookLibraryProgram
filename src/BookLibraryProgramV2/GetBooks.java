
package BookLibraryProgramV2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GetBooks {
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
            Logger.getLogger(GetBooks.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bookList;
    }
    
    public int countBooks() {
        int count = 0;
        GetBooks gb = new GetBooks();
        List<Book> bookList = gb.getAllBooks();
        for (Book b : bookList) {
            count++;
        }
        return count;
    }
    
    public static void main(String args[]) {
        GetBooks gb = new GetBooks();
        List<Book> bookList = gb.getAllBooks();
        for (Book b : bookList) {
            System.out.println(b.toString());
        }
        gb.db.closeConnections();
        
        System.out.println(gb.countBooks());
    }
}
