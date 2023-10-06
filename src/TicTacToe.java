import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;

public class TicTacToe extends JFrame {
    public TicTacToe(){
        super.setSize(500,500);
        super.setTitle("Tic Tac Toe");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
        super.setVisible(true);
    }

    private void buildPanel() {
        //tictactoe dimensions
        int dimension=0;
        boolean isWrong=true;
        while (isWrong){
            try{
                dimension = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer greater than 1 which will be the number of rows and columns for the TicTacToe game (Enter 1 to exit):"));
                isWrong = false;
                if (dimension ==1){
                    System.exit(0);
                }
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Please enter an integer");
            }
        }

        //int dimension = 3;
        //set the layout as grid
        GridLayout gridlayout = new GridLayout(dimension,dimension);
        super.setLayout(gridlayout);
        //make a list of buttons
        JButton[][] buttons = new JButton[dimension][dimension];
        //initialize the buttons
        for (int row=0; row<dimension; row++){
            for (int col=0; col<dimension; col++){
                buttons[row][col] = new JButton();
                super.add(buttons[row][col]);
                //ActionListener WITHIN forloop!!!!
                TicTacToeAWT mylistener = new TicTacToeAWT(buttons,row, col, dimension, this);
                buttons[row][col].addActionListener(mylistener);
            }

        }

    }

    public static void main(String[] args) {
        TicTacToe test = new TicTacToe();
    }
}
