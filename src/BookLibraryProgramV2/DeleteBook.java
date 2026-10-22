
package BookLibraryProgramV2;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteBook {
    
    public void deleteBook(String title, String author) throws SQLException {
        DBManager db = new DBManager();
        
        String sql = "DELETE FROM PDC.BOOK WHERE (title, author) values (?,?)";
        try (PreparedStatement prep = db.getConnection().prepareStatement(sql)) {
            prep.setString(1, title);
            prep.setString(2, author);
            
            prep.executeUpdate();
            System.out.println("Book Deleted");
 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        } 
    }

 
    // Was resetting books back to original added
//    public static void resetBooks() throws SQLException {
//        DBManager db = new DBManager();
//        
//        String sql = "DELETE FROM PDC.BOOK WHERE BOOKID >= 14";
//        try (PreparedStatement prep = db.getConnection().prepareStatement(sql)) {
//        
//            prep.executeUpdate();
//            System.out.println("Book Deleted");
// 
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());        
//        } 
//    }
//     public static void main(String[] args) throws SQLException {
//         DeleteBook.resetBooks();
//     }

}
