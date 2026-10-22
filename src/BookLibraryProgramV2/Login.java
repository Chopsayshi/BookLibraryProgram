
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
        
        String sql = "SELECT password, admin FROM ACCOUNT WHERE username = ?";
        
        try (PreparedStatement prep = db.getConnection().prepareStatement(sql)){
            prep.setString(1,this.username);
            ResultSet rs = prep.executeQuery();
            
            if(rs.next()) {
                // The username entered was found in the database
                this.userExsistKey = true;
                String dbPass = rs.getString("password");
                boolean dbAdmin = rs.getBoolean("admin");
            
                if(dbPass.equals(this.password)) {
                    // The entered password matches the stored user
                    this.passMatchKey = true;
                    this.admin = dbAdmin;
                }
            
        } 
    }catch (SQLException ex) {
        System.err.println(ex.getMessage());        
    }
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
