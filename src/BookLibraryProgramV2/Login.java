
package BookLibraryProgramV2;



public class Login {
    
    public String username;
    public String password;
    public boolean admin;

    
    public Login(String user, String pass){
        this.username = user;
        this.password = pass;
    }
    
    // Check if the user is in the database

    
    public boolean userExsists() {
        boolean value = true;
        return value;
    }
    
    // Check if the user is in the database
    public boolean passMatch() {
        boolean value = true;
        return value;
    }
    
    // Check if the user is an admin or not
    public boolean isAdmin() {
        boolean value = true;
        return value;
    }

}
