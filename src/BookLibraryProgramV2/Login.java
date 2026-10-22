
package BookLibraryProgramV2;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    private final String username;
    private final String password;
    private boolean admin;
    private boolean userExsistKey = false;
    private boolean passMatchKey = false;
    
    public Login(String user, String pass){
        this.username = user;
        this.password = pass;
    }
    
    public boolean isAdmin() {
        return this.admin;
    }

    public void checkUserDetails() throws SQLException {
        DBManager db = new DBManager();
        
        // Setting up sql query used
        String sql = "SELECT password, admin FROM ACCOUNT WHERE username = ?";
        
        // Program will try to execute the sql after connecting to the database
        try (PreparedStatement prep = db.getConnection().prepareStatement(sql)){
            // The '1, this.username' fills in the '?' as seen in the sql above
            prep.setString(1,this.username);
            
            ResultSet rs = prep.executeQuery();
            
            // Each line of the database is checked to see if it matched the sql
            if(rs.next()) {
                // The username entered was found in the database
                this.userExsistKey = true;
                String dbPass = rs.getString("password");
                boolean dbAdmin = rs.getBoolean("admin");
            
                // After verifying that the user exsists it will check if the 
                // password given matches that user
                if(dbPass.equals(this.password)) {
                    // The entered password matches the stored user
                    this.passMatchKey = true;
                    this.admin = dbAdmin;
                }
        } 
    }catch (SQLException ex) {
        // If something goes wrong it will send an error message to the console
        System.err.println(ex.getMessage());        
    }
        // Disconnects from the database instance
        db.closeConnections();
    }
    // Check if the user is in the database 
    public boolean userExsists() {
        return this.userExsistKey;
    }
    
    // Check if the user is in the database
    public boolean passMatch() {
        return this.passMatchKey;
    }

}
