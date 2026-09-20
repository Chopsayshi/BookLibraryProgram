package booklibraryprogram;

public class Book {
    private String title;
    private String author;
    
    // Default Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    // Setters for the Admin user when Updating a book
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    // Getters for all users
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
        
    // To string
    @Override
    public String toString() {
        return getTitle() + " by " + getAuthor();
    }
    
}

    
