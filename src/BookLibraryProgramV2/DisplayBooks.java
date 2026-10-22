
package BookLibraryProgramV2;

//import java.util.List;

import java.util.List;
import javax.swing.DefaultListModel;



public class DisplayBooks {
    public DefaultListModel<String> listModel;
    
    public DefaultListModel<String> displayAvailableBooks() {
        GetBooks gb = new GetBooks();
        
        List<Book> bookList = gb.getAllBooks();
        
        listModel = new DefaultListModel<>();
        
        for (Book b : bookList) {
            listModel.addElement(b.toString());
        }
        
        return listModel;
        
    }
    
}
