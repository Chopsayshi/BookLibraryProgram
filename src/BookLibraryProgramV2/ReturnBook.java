
package BookLibraryProgramV2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ReturnBook {
    public static void Return(String title, String author){
        DBManager db = new DBManager();
        
        String sql = "SELECT * FROM BOOK where (title,author) values (?,?)";
        
        try (PreparedStatement prep = db.getConnection().prepareStatement(sql)) {
             prep.setString(1, title);
             prep.setString(2, author);
             
             ResultSet rs = prep.executeQuery();
            
            if(rs.next()) {
                
                boolean available = rs.getBoolean("available");
                
                // Set to available
//                if (available)) {
//                        
//                }    
                // Refresh display
                
            }
            db.closeConnections();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        }
    }
}
