
package BookLibraryProgramV2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoadDatabases {
        public static Connection conn;
        public static String url;
        public static String username = "pdc";
        public static String password = "pdc";
    
    public static void LoadUserDB() throws SQLException 
    {
        // Double Check how to use embedded version
        url = "jdbc:derby://localhost:1527/UserDB";
        
        try {
            conn = DriverManager.getConnection(url,username,password);
            System.out.println(url+"Connected..");
        }
        catch (SQLException ex) {
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
    
    public static void LoadBookDB() throws SQLException 
    {
        // Double Check how to use embedded version
        url = "jdbc:derby://localhost:1527/BookDB";
        
        try {
            conn = DriverManager.getConnection(url,username,password);
            System.out.println(url+"Connected..");
        }
        catch (SQLException ex) {
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}

