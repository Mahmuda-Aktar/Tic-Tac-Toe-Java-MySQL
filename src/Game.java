import javax.swing.*;
import java.awt.*;
import java.util.Random;



public class Game {
  private TicTacToePlayer player1,player2;
  public TicTacToePlayer CurrentPlayer;
    GameBoard board;
    JTextField tf;
   Game(String s1,String s2){
       player1=new TicTacToePlayer(s1,'X');
       player2=new TicTacToePlayer(s2,'O');

       Random rand=new Random();
       CurrentPlayer=(rand.nextInt(2)==0)?player1:player2;
       board=new GameBoard(this);


   }

   public boolean winnerCheck(){
       for(int i=0;i<3;i++){
           String t1=board.button[i][0].getText();
           String t2=board.button[i][1].getText();
           String t3=board.button[i][2].getText();
           if(!t1.equals("") && t1.equals(t3) && t1.equals(t2))return true;
           String t4=board.button[0][i].getText();
           String t5=board.button[1][i].getText();
           String t6=board.button[2][i].getText();
           if(!t4.equals("") && t4.equals(t5) && t4.equals(t6))return true;

       }
       String s1=board.button[0][0].getText();
       String s2=board.button[1][1].getText();
       String s3 =board.button[2][2].getText();
       String s4=board.button[0][2].getText();
       String s5=board.button[2][0].getText();
       if(!s1.equals("") && s1.equals(s2) && s2.equals(s3))return true;
       if(!s2.equals("") && s4.equals(s2) && s2.equals(s5))return true;

       return false;

   }
   public boolean drawCheck(){
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               if(board.button[i][j].getText().equals(""))return false;
           }
       }
       return true;
   }


    public void makeMove(int row, int col) {
        if (board.button[row][col].getText().equals("")) {
            board.button[row][col].setText(CurrentPlayer.symbol + "");
            if(winnerCheck())
            {
                JOptionPane.showMessageDialog(null,"The Winner is " +CurrentPlayer.getName() );
                disableAllButtons();

            }
           else if(drawCheck()==true) {
                JOptionPane.showMessageDialog(null, "Draw");
                disableAllButtons();
            }
            else {
                if(CurrentPlayer==player1)CurrentPlayer=player2;
                else CurrentPlayer=player1;
               board.setTf("Now "+CurrentPlayer.getName()+"'s turn ");


            }

        }
    }
    public void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.button[i][j].setEnabled(false);
            }
        }
    }


}
