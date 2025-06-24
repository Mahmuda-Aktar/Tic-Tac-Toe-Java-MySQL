import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPage extends JFrame {
    private JFrame frame;
    private JLabel label1,label2,label3;
    private JButton jb1,jb2;
    private Font f1,f2;
    private Container c;
    private ImageIcon icon,img;

    public FrontPage(){
        initComponent();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
    }
    public void initComponent(){
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        f1=new Font("Arial",Font.BOLD,20);
        icon=new ImageIcon(getClass().getResource("img_2.png"));
        this.setIconImage(icon.getImage());
        img=new ImageIcon(getClass().getResource("img_5.png"));
        label2=new JLabel(img);
        label2.setBounds(150,20,200,200);
        c.add(label2);
        label1 =new JLabel(" Lets play TicTacToe ");
        label1.setBounds(160,230,250,50);
        label1.setFont(f1);

        label1.setForeground(Color.WHITE);
        c.add(label1);
        f2=new Font("Arial",Font.BOLD,14);

        jb1=new JButton("Register");
        jb1.setBounds(200,280,100,50);
        jb1.setBackground(Color.BLACK);
        jb1.setForeground(Color.white);
        jb1.setFont(f2);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegistrationPage fr=new RegistrationPage();
                fr.setVisible(true);
            }
        });
        c.add(jb1);

        jb2=new JButton("Login");
        jb2.setBounds(200,340,100,50);
        jb2.setBackground(Color.BLACK);
        jb2.setForeground(Color.white);
        jb2.setFont(f2);
        c.add(jb2);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginPage  frame=new LoginPage();
                frame.setVisible(true);
            }
        });


    }
    public static void main(String args[]){
        FrontPage frame=new FrontPage();
        frame.setVisible(true);
        frame.setBounds(100,100,500,500);
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
