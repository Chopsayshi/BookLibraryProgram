
package BookLibraryProgramV2;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBook {
    public static void addBook(String title, String author) throws SQLException {
        DBManager db = new DBManager();
        
        String sql = "INSERT INTO PDC.BOOK (bookid,title, author, available) VALUES (?,?, ?, ?)";
        try (PreparedStatement prep = db.getConnection().prepareStatement(sql)) {
            
            prep.setInt(1, CountBooks.countBooks() + 2);
            prep.setString(2, title);
            prep.setString(3, author);
            prep.setBoolean(4, true);

            prep.executeUpdate();
            System.out.println("Book Added");
 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        } 
    }
}
