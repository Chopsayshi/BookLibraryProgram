
package BookLibraryProgramV2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
    private int bookid;
    private String title;
    private String author;
    private boolean available;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }
    
    // Getters
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public boolean getAvailable() {
        return this.available;
    }
    
    // Setters
    public void setBorrow() {
        this.available = false;
    }
    
    public void setReturn() {
        this.available = true;
    }
    
    public void setBookID(int num) {
        this.bookid += num ;
    }
    
    // toString
    @Override
    public String toString(){
        return "Book ID:"+this.bookid+" Title: "+ this.title + " Author: "+this.author+" Avaialbility: "+this.available;
    }
    
    // 

    private boolean matchTitle = false;
    private boolean bookMatch = false;
    
    
    
    public void bookExsists() throws SQLException  {
        DBManager db = new DBManager();
        
        String sql = "SELECT author FROM BOOK where title = ?";
        
        try (PreparedStatement prep = db.getConnection().prepareStatement(sql)) {
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
            db.closeConnections();
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
        GetBooks gb = new GetBooks();
        
        String sql = "INSERT INTO PDC.BOOK (bookid,title, author, available) VALUES (?,?, ?, ?)";
        try (PreparedStatement prep = db.getConnection().prepareStatement(sql)) {
            
            prep.setInt(1, gb.countBooks() + 2);
            prep.setString(2, this.title);
            prep.setString(3, this.author);
            prep.setBoolean(4, true);

            prep.executeUpdate();
            System.out.println("Book Added");
 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        } 
    }
    
}
