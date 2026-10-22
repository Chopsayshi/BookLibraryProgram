
package BookLibraryProgramV2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBManager {
    public static final String USERNAME = "pdc";
    public static final String PASSWORD = "pdc";
//    public final String URL = "jdbc:derby://localhost:1527/LibraryDB"; //jdbc:derby:LibraryDB; create=true
    public final String URL = "jdbc:derby:LibraryDB; create=true"; //jdbc:derby:LibraryDB; create=true

    Connection conn;
    
    public DBManager() {
        establishConnection();
    }
    
    public static void main(String[] args) throws SQLException {
        DBManager dbManager = new DBManager();
        System.out.println(dbManager.getConnection());
    }
    
    public Connection getConnection() {
        return this.conn;
    }
        
    public void establishConnection() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println(URL+" Connected..");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("db disconnected");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    public ResultSet queryDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}

