
package BookLibraryProgramV2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookLibrary {
        private final DBManager dbManager;
        private final Connection conn;
        private Statement statement;
        
        public BookLibrary() throws SQLException {
            dbManager = new DBManager();
            conn = dbManager.getConnection();
        }
        
        public void connectBookDB() {
            dbManager.establishConnection();
        }
    
    public void getQuery() {
        ResultSet rs = null;

        try {

            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from BOOK";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                System.out.println("Title: "+title+" Author: "+author);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
    }
    public void getUsers() {
        ResultSet rs = null;

        try {

            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from ACCOUNT";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                String dbUser = rs.getString("username");
                String dbPass = rs.getString("password");
                System.out.println("Username: "+dbUser+" Password: "+dbPass);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
    }
    
    public void addBook() {
            try {

            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            String sql2 = "INSERT INTO BOOK VALUES (20,'mickey','marlin buns',true)";
        
            statement.executeUpdate(sql2);
            
             System.out.println("New book added");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        }
    }
    
//    public void getQuery() {
//        ResultSet rs = null;
//
//        try {
//
//            System.out.println(" getting query....");
//            Statement statement = dbManager.getConnection().createStatement(
//                    ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//
//            String sqlQuery = "select * from BOOK";
//
//            rs = statement.executeQuery(sqlQuery);
//            rs.beforeFirst();
//            while (rs.next()) {
//                String title = rs.getString("title");
//                String author = rs.getString("author");
//                System.out.println("Title: "+title+" Author: "+author);
//            }
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());        
//        }
//    }
    public int count() {
        int count = 0;
        ResultSet rs = null;

        try {
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from ACCOUNT";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                String dbUser = rs.getString("username");
                String dbPass = rs.getString("password");
                count++;
            }
            return count;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());    
            return 0;
        }
    }
    
}
