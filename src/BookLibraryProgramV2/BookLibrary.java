
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
    
}
