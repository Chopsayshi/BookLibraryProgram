
package BookLibraryProgramV2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
        // Not needed for the embedded version
//      public static String username = "pdc";
//      public static String password = "pdc";
        
    public static String url;
    Connection conn;
    
    public DBManager() {
        
    }
    
    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
    }
    
    public Connection getConnection() {
        return this.conn;
    }
        
    public void establishUserDBConnection() {
        url = "jdbc:derby:UserDB; create=true";
        
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(url);
                // Debug Test
                System.out.println(url+"Connected..");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    public void establishBookDBConnection() {
        url = "jdbc:derby:BookDB; create=true";
        
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(url);
                // Debug Test
                System.out.println(url+"Connected..");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    

    
//    public static void LoadUserDB() throws SQLException 
//    {
//        // Embedded Version
//        url = "jdbc:derby:UserDB; create=true";
//        
//        try {
//            conn = DriverManager.getConnection("jdbc:derby:UserDB; create=true");
//            System.out.println(url+"Connected..");
//        }
//        catch (SQLException ex) {
//            System.err.println("SQLException: "+ex.getMessage());
//        }
//        
//        // Derby Network Server Version
////        url = "jdbc:derby://localhost:1527/UserDB; create=true";
////        
////        try {
////            conn = DriverManager.getConnection(url,username,password);
////            System.out.println(url+"Connected..");
////        }
////        catch (SQLException ex) {
////            System.err.println("SQLException: "+ex.getMessage());
////        }
//    }
//    
//    public static void LoadBookDB() throws SQLException 
//    {
//        
//        // Embedded Version
//        url = "jdbc:derby:BookDB; create=true";
//        
//        try {
//            conn = DriverManager.getConnection("jdbc:derby:BookDB; create=true");
//            System.out.println(url+"Connected..");
//        }
//        catch (SQLException ex) {
//            System.err.println("SQLException: "+ex.getMessage());
//        }
//        
//        // Derby Network Server Version
////        url = "jdbc:derby://localhost:1527/BookDB; create=true";
//        
////        try {
////            conn = DriverManager.getConnection(url,username,password);
////            System.out.println(url+"Connected..");
////        }
////        catch (SQLException ex) {
////            System.err.println("SQLException: "+ex.getMessage());
////        }
//    }
    
}

