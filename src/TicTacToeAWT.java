import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeAWT implements ActionListener {
    static int count;
    private JButton button;
    private JButton[][] buttons;
    static boolean gameFinished=false;
    private boolean wasClicked=false;

    private int dimension;

    private JFrame frame;
    public TicTacToeAWT(JButton[][] buttons, int row, int col, int dimension, JFrame a){
        button = buttons[row][col];
        this.buttons = buttons;
        this.dimension=dimension;
        frame=a;
    }

    public void actionPerformed(ActionEvent e){
        // create an object for Fonts
        Font font = new Font("Arial", Font.PLAIN, 40);
        //check if the button was already clicked
        if (!wasClicked) {
            wasClicked = true;
            button.setFont(font);
            if (count % 2 == 0) {
                button.setText("X");
                ImageIcon imageIcon = new ImageIcon("catPicture.jpeg"); // load the image to a imageIcon
                Image image = imageIcon.getImage(); // transform it
                Image newimg = image.getScaledInstance(110, 110,  Image.SCALE_DEFAULT); // scale it the smooth way
                imageIcon = new ImageIcon(newimg);
                button.setIcon(imageIcon);
            } else if (count % 2 == 1) {
                button.setText("O");
                ImageIcon imageIcon = new ImageIcon("dogPicture.jpeg"); // load the image to a imageIcon
                Image image = imageIcon.getImage(); // transform it
                Image newimg = image.getScaledInstance(110, 110,  Image.SCALE_DEFAULT); // scale it the smooth way
                imageIcon = new ImageIcon(newimg);
                button.setIcon(imageIcon);
            }
            count++;
            /////////////////SEARCHING FOR A ROW WIN///////////////////
            for (int row=0; row<dimension; row++){
                //initialize some variables
                String letter = buttons[row][0].getText();
                boolean rowWin=false;
                for (int col=1; col<dimension; col++){
                    if (buttons[row][col].getText().equals(letter) && buttons[row][col].getText().length()>0){
                        rowWin=true;
                    } else{
                        rowWin=false;
                        break;
                    }
                }
                if (rowWin){

                    if (letter.compareTo("O") == 0) {
                        letter = "Dog";
                    } else {
                        letter = "Cat";
                    }
                    JOptionPane.showMessageDialog(frame, letter + " wins horizontally!\nResetting...");
                    TicTacToe test = new TicTacToe();
                    count=0;
                    gameFinished=false;
                }
            }
            /////////////////SEARCHING FOR A COLUMN WIN///////////////////
            for (int col=0; col<dimension; col++){
                //initialize some variables
                String letter = buttons[0][col].getText();
                boolean colWin=false;
                for (int row=1; row<dimension; row++){
                    if (buttons[row][col].getText().equals(letter) && buttons[row][col].getText().length()>0){
                        colWin=true;
                    } else{
                        colWin=false;
                        break;
                    }
                }
                if (colWin){
                    if (letter.compareTo("O") == 0) {
                        letter = "Dog";
                    } else {
                        letter = "Cat";
                    }
                    JOptionPane.showMessageDialog(frame, letter + " wins vertically!\nResetting...");
                    TicTacToe test = new TicTacToe();
                    count=0;
                    gameFinished=false;
                }
            }
            /////////////////SEARCHING FOR A DIAGONAL WIN///////////////////

            //intialize letter!!!
            String letter = buttons[0][0].getText();
            boolean diagonalWin=false;

            for (int num1=1; num1<dimension; num1++){
                if (buttons[num1][num1].getText().equals(letter) && buttons[num1][num1].getText().length()>0){
                    diagonalWin = true;
                } else{
                    diagonalWin = false;
                    break;
                }
            }
            if (diagonalWin){
                if (letter.compareTo("O") == 0) {
                    letter = "Dog";
                } else {
                    letter = "Cat";
                }
                JOptionPane.showMessageDialog(frame, letter + " wins diagonally!\nResetting...");
                TicTacToe test = new TicTacToe();
                count=0;
                gameFinished=false;
            }
            //initializing variables
            int startRow = dimension-1;
            int startCol = 0;
            String letter1 = buttons[startRow][startCol].getText();
            boolean diagonalWin1=false;

            for (int num1=1; num1<dimension; num1++){
                startRow--;
                startCol++;
                if (buttons[startRow][startCol].getText().equals(letter1) && buttons[startRow][startCol].getText().length()>0){
                    diagonalWin1 = true;
                } else{
                    diagonalWin1 = false;
                    break;
                }
            }

            if (diagonalWin1){
                if (letter.compareTo("O") == 0) {
                    letter = "Dog";
                } else {
                    letter = "Cat";
                }
                JOptionPane.showMessageDialog(frame, letter1 + " wins diagonally!\nResetting...");
                TicTacToe test = new TicTacToe();
                count=0;
                gameFinished=false;
            }

        }if (count==dimension*dimension){
            JOptionPane.showMessageDialog(frame,"Cat's game\nResetting...");
            TicTacToe test = new TicTacToe();
            count=0;
            gameFinished=false;
        }

    }


}
