
package BookLibraryProgramV2;

import javax.swing.JFrame;


public class LoadFrame {
        // Setting Frames Dimentions
        public static int WIDTH = 1280;
        public static int HEIGHT = 750;
        
        // Setting Stating Position
        public static int X = 300;
        public static int Y = 200;
        
        public static void LoginMenu() {
            LoginMenu f = new LoginMenu();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting screen size
            f.setSize(WIDTH, HEIGHT);

            // Centering frame
            f.setLocation(X,Y);
            
            // Displays menu
            f.setVisible(true);
        }
        
        public static void AddUserMenu() {
            AddUserMenu addU = new AddUserMenu();
            addU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting screen size
            addU.setSize(WIDTH, HEIGHT);

            // Centering frame
            addU.setLocation(X,Y);
            
            // Displays menu
            addU.setVisible(true);
        }
        
        public static void AdminMenu() {
            AdminMenu admin = new AdminMenu();
            admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting screen size
            admin.setSize(WIDTH, HEIGHT);

            // Centering frame
            admin.setLocation(X,Y);

            // Displays menu
            admin.setVisible(true);
        }

        public static void AddBookMenu() {
            AddBookMenu addB = new AddBookMenu();
            addB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting size
            addB.setSize(WIDTH, HEIGHT);

            // Centering frame
            addB.setLocation(X,Y);

            // Displays menu
            addB.setVisible(true);
        }
        
        public static void UpdateBookMenu() {
            UpdateBookMenu update = new UpdateBookMenu();
            update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting screen size
            update.setSize(WIDTH, HEIGHT);

            // Centering frame
            update.setLocation(X,Y);
            
            // Displays menu
            update.setVisible(true);
        }
        
        public static void DeleteBookMenu() {
            DeleteBooksMenu delete = new DeleteBooksMenu();
            delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting screen size
            delete.setSize(WIDTH, HEIGHT);

            // Centering frame
            delete.setLocation(X,Y);
            
            // Displays menu
            delete.setVisible(true);
        }
        
        public static void BasicMenu() {
            BasicMenu basic = new BasicMenu();
            basic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting screen size
            basic.setSize(WIDTH, HEIGHT);

            // Centering frame
            basic.setLocation(X,Y);
            
            // Displays menu
            basic.setVisible(true);
        }
        
        public static void BorrowBooksMenu() {
            BorrowBooksMenu borrow = new BorrowBooksMenu();
            borrow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting screen size
            borrow.setSize(WIDTH, HEIGHT);

            // Centering frame
            borrow.setLocation(X,Y);
            
            // Displays menu
            borrow.setVisible(true);
        }
        
        public static void ReturnBooksMenu() {
            ReturnBooksMenu returns = new ReturnBooksMenu();
            returns.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting screen size
            returns.setSize(WIDTH, HEIGHT);

            // Centering frame
            returns.setLocation(X,Y);
            
            // Displays menu
            returns.setVisible(true);
        }
}
