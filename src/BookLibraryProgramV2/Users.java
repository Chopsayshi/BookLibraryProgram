
package BookLibraryProgramV2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Users {
        private final DBManager ldDatabases;
        private final Connection conn;
        
        public Users() {
            ldDatabases = new DBManager();
            conn = ldDatabases.getConnection();
        }
        
    
        public ResultSet getUsers() {
        ResultSet rs = null;
        
        try (Statement statement = conn.createStatement()) {
            String sql = "SELECT * FROM LOGIN";
            rs=statement.executeQuery(sql);
            
            while(rs.next()) {
                String dbUsername = rs.getString("username");
                String dbPassword = rs.getString("password");
                boolean isAdmin = rs.getBoolean("admin");
                System.out.println("User: "+dbUsername+" Password: "+dbPassword+" Admin?: "+ isAdmin);
            }
            
        } catch (SQLException ex) {
            System.err.println("Error has occured ");
        }
        return(rs);
    }
}
