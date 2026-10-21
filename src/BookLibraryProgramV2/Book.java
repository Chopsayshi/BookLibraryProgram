
package BookLibraryProgramV2;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {
    private String title;
    private String author;
    private boolean available = true;
    
    public Book(String title, String author) {
        this.title = title;
        this.title = author;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public boolean isAvailable() {
        return this.available;
    }

    public void setBorrow() {
        this.available = false;
    }
    
    public void setReturn() {
        this.available = true;
    }

    public void addBook() throws SQLException {
        DBManager db = new DBManager();
        BookLibrary bl = new BookLibrary();
        
        
        try  {
             String sql = "INSERT INTO BOOK (bookid, title, author, available) VALUES (?,?,?,?)";
        
            try(PreparedStatement prep = db.getConnection().prepareStatement(sql)) {
                prep.setInt(1,bl.count());
                prep.setString(2,getTitle());
                prep.setString(3,getAuthor());
                prep.setBoolean(4,isAvailable());
                
                int fields = prep.executeUpdate();
                if (fields > 0) {
                    System.out.println("Book Added!");
                }
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        }
       
        
    }
}
