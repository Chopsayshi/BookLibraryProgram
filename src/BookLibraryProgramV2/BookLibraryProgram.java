package BookLibraryProgramV2;

import java.sql.SQLException;

public class BookLibraryProgram {

    public static void main(String[] args) throws SQLException {
        
        //Loads Initial Menu: Login Menu
        LoadFrame.LoginMenu();
        
    }
}

/*
CURRENTLY WORKING ON: DeleteBookMenu [DisplayBooks, DeleteBook], BorrowBookMenu [DisplayBooks], ReturnBookMenu [DisplayBooks]
Current obsticle is getting the JLists to display books. Otherwise I know how I would implement each function 

Classes shown in '[]' spaced next to the frames they relate to..
Frames/Menus surrounded by '//' have intentially not been implemented yet

ALLFRAMES [LoadFrame, Exit]
BACKEND/BUGFIXING [ListBooks, DeleteBook]

Logged Out: LoginMenu [Login.java] , //AddUserMenu// 
Admin User: AdminMenu, AddBookMenu [CountBooks, Book, AddBook], DeleteBookMenu [DisplayBooks, DeleteBook], // UpdateBookMenu//
Basic User: BasicMenu, BorrowBookMenu [DisplayBooks, BorrowBook], ReturnBookMenu [DisplayBooks]

FULLY IMPLEMENTED:  AdminMenu, BasicMenu, LoginMenu [Login.java], AddBookMenu [CountBooks, Book, AddBook].

NOTABLE INCOMPLETE AREAS: 5x Test Cases have not been completed 
*/