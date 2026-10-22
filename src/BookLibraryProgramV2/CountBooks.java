
package BookLibraryProgramV2;

import java.util.List;


public class CountBooks {
    public static int countBooks() {
        int count = 0;
        ListBooks gb = new ListBooks();
        List<Book> bookList = gb.getAllBooks();
        for (Book b : bookList) {
            count++;
        }
        return count;
    }
}
