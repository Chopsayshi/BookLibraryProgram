
package BookLibraryProgramV2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
    public String title;
    private String author;
    private boolean available = true;
    private boolean matchTitle = false;
    private boolean bookMatch = false;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
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
    
    public void bookExsists() throws SQLException  {
        DBManager newdb = new DBManager();
        
        String sql = "SELECT author FROM BOOK where title = ?";
        
        try (PreparedStatement prep = newdb.getConnection().prepareStatement(sql)) {
             prep.setString(1, this.title);
             ResultSet rs = prep.executeQuery();
            
            if(rs.next()) {
                // A book matches the entered title
                this.matchTitle = true;
                String dbAuthor = rs.getString("author");
                
                if (dbAuthor.equals(this.author)) {
                        this.bookMatch = true;
//                        System.out.println("THIS BOOK EXSISITS");
                }    
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        }
       
        
    }
    
     public boolean matchTitle() {
        return this.matchTitle;
    }
    
    public boolean matchBook() {
        return this.bookMatch;
    }
    
    public void addBook() throws SQLException {
        DBManager db = new DBManager();     
        
        String sql = "INSERT INTO PDC.BOOK (title, author, available) VALUES (?, ?, ?)";
        try (PreparedStatement prep = db.getConnection().prepareStatement(sql)) {
            
            prep.setString(1, this.title);
            prep.setString(2, this.author);
            prep.setBoolean(3, true);

            prep.executeUpdate();
            
            db.getConnection().commit();
            System.out.println("Book Added and Comitted");
 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        } 
    }
    
    
    // For delete and borrow book menus
    public void displayAvailableBooks() {
        
    }
    
    // For return menu
    public void displayUnvailableBooks() {
        
    }
    
    public void deleteBook() {
        
    }
}
