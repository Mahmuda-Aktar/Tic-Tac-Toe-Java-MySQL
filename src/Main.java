import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JLabel label1,label2,label3,label4;
    private ImageIcon icon,icon2;
    private Container c;
    private Font f1;
    private JButton jb;
   public Main(){
       initComponents();
   }
   public void initComponents(){
       c=this.getContentPane();
       c.setLayout(null);
       c.setBackground(Color.BLACK);
       f1=new Font("Impact", Font.BOLD, 22);
       c.setBounds(100,100,500,500);
       icon=new ImageIcon(getClass().getResource("img_2.png"));
       this.setIconImage(icon.getImage());

       icon2=new ImageIcon(getClass().getResource("img_4.png"));
       label1=new JLabel(icon2);
       label1.setBounds(140,20,200,200);
       c.add(label1);
       label2=new JLabel("Hey , Beautiful people");
       label2.setFont(f1);       label2.setForeground(Color.WHITE);

       label2.setBounds(130,220,250,50);
       c.add(label2);
       label3=new JLabel("Welcome to ");
       label3.setFont(f1);       label3.setForeground(Color.WHITE);

       label3.setBounds(170,250,250,50);
       c.add(label3);
       label4=new JLabel("Tic Tac Toe Game");
       label4.setForeground(Color.WHITE);
       label4.setFont(f1);
       label4.setBounds(150,280,250,50);
       c.add(label4);
       jb=new JButton("START");
       jb.setBackground(Color.BLACK);
        jb.setForeground(Color.white);
        jb.setBounds(180,330,100,40);
       jb.setCursor(new Cursor(Cursor.HAND_CURSOR));

       c.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
              FrontPage page= new FrontPage();
              page.setVisible(true);
            }
        });
   }

    public static void main(String[] args) {
        Main frame=new Main();
        frame.setVisible(true);
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTitle(" Tic Tac Toe ");

    }
}