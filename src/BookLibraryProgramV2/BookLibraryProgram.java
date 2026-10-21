package BookLibraryProgramV2;

import java.sql.SQLException;

public class BookLibraryProgram {

    public static void main(String[] args) throws SQLException {
        
        // Loads Initial Menu: Login Menu
        LoadFrame.LoginMenu();
      
        // Starts database connections
        LoadDatabases.LoadUserDB();
        LoadDatabases.LoadBookDB();
        
        
    }
}
