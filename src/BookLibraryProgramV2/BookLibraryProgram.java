package BookLibraryProgramV2;

import javax.swing.JFrame;



public class BookLibraryProgram {

    public static void main(String[] args) {
        LoginMenu f = new LoginMenu();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Setting static screen size
        int WIDTH = 1280;
        int HEIGHT = 750;
        f.setSize(WIDTH, HEIGHT);
        
        // Centering frame
        int X = 300;
        int Y = 200;
        f.setLocation(X,Y);
        
        f.setVisible(true);
        
    }
}
