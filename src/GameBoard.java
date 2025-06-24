import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame implements ActionListener {
    private Container c;
     JButton[][] button=new JButton[3][3];
    private Game game;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1;
    private JTextField tf;
    private JButton exit;
    GameBoard(Game game){
        this.game=game;
        initComponents();
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        tf=new JTextField("Now "+game.CurrentPlayer.getName()+"'s turn ");
        tf.setBounds(300,150,180,50);
        tf.setBackground(Color.BLACK);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setFont(new Font("Arial",Font.BOLD,18));
        tf.setForeground(Color.white);
        this.add(tf);
    }
    public void setTf(String s){
        tf.setText(s);
    }


    public void initComponents(){
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        icon=new ImageIcon(getClass().getResource("img_2.png"));
        this.setIconImage(icon.getImage());
        f1=new Font("Arial",Font.BOLD,18);
        label1=new JLabel("TicTacToe is ongoing.....");
        label1.setBounds(20,10,200,50);
        label1.setFont(f1);
        label1.setForeground(Color.WHITE);
        c.add(label1);
        int y=150;
        for(int i=0;i<3;i++){
            int x=50;

            for(int j=0;j<3;j++){
                 button[i][j]=new JButton("");
                 button[i][j].setBounds(x,y,70,70);x=x+70;
                 button[i][j].setBackground(Color.white);
                 button[i][j].setForeground(Color.black);
                 button[i][j].addActionListener(this);
                 c.add(button[i][j]);
            }
            y=y+70;
        }
        exit=new JButton("Exit");
        exit.setBounds(350,300,100,40);
        exit.setFont(new Font("Arial",Font.BOLD,18));
        exit.setBackground(Color.BLUE);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        c.add(exit);
    }
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(e.getSource()==button[i][j]){
                  if(isValidMove(i,j)){
                      game.makeMove(i,j);
                  }
                }
            }
        }
    }
    public boolean isValidMove(int row,int col){
        if(row<3 && row>=0 && col<3 && col>=0 && button[row][col].getText().equals("")){
            return true;
        }return false;
    }


}
