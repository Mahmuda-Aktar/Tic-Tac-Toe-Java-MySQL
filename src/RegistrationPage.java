
import javax.swing.*;
        import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationPage extends JFrame {
    private Container c;
    private JLabel j1,j2,n1,n2,pass1,pass2,e1,e2,label1;
    private JTextField jb1,jb2,jb3,jb4;
    private JButton jl1,jl2;
    private ImageIcon icon,img;
    private Font f1,f2,f3;
    private JPasswordField p1,p2;
    private boolean pr1=false;
    private boolean pr2=false;
    RegistrationPage(){ this.setTitle("Registration Form");
        this.setBounds(100,100,500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
          this.setVisible(true);

    }
    public void initComponents(){
        c=this.getContentPane();
        c.setBackground(Color.BLACK);
        c.setLayout(null);

        f1=new Font("Arial",Font.BOLD,20);
        f2=new Font("Arial",Font.BOLD,14);
        icon=new ImageIcon(getClass().getResource("img_2.png"));
        this.setIconImage(icon.getImage());




        j1=new JLabel("Player 1 ");
        j1.setForeground(Color.WHITE);
        j1.setBounds(120,50,100,50);
        j1.setFont(f1);
        c.add(j1);
        j2=new JLabel("Player 2 ");
        j2.setForeground(Color.WHITE);

        j2.setBounds(330,50,100,50);
        j2.setFont(f1);
        c.add(j2);

        n1=new JLabel("Name : ");
        n1.setForeground(Color.WHITE);

        c.add(n1);
        n1.setBounds(30,100,50,50);
        jb1 =new JTextField();
        jb1.setBackground(Color.BLACK);
        jb1.setForeground(Color.white);
        jb1.setBounds(80,100,150,40);
        c.add(jb1);
        e1=new JLabel("Email : ");
        e1.setBounds(30,150,50,50);
        e1.setForeground(Color.WHITE);

        c.add(e1);
        jb2 =new JTextField();
        jb2.setBackground(Color.BLACK);
        jb2.setForeground(Color.white);
        jb2.setBounds(80,150,150,40);
        c.add(jb2);
        pass1=new JLabel("Pass : ");
        pass1.setForeground(Color.WHITE);

        pass1.setBounds(30,200,50,50);
        c.add(pass1);
        p1=new JPasswordField();
        p1.setBounds(80,200,150,40);
        p1.setForeground(Color.white);
        p1.setBackground(Color.BLACK);
        c.add(p1);
        jl1=new JButton("Register");
        jl1.setBackground(Color.BLACK);
        jl1.setForeground(Color.white);
        jl1.setBounds(100,250,100,40);
        c.add(jl1);
        jl1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1name=jb1.getText(),email=jb2.getText();
                String pass=new String(p1.getPassword());
                if(p1name.isEmpty() || email.isEmpty() || pass.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Sorry , Try Again!");
                }else{
                    try {
                        Connection conn = DataBaseConnection.getConnection();
                        String sql = "INSERT INTO TicTacToeUsers(name,email,password)VALUES(?,?,?)";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1,p1name);
                        pst.setString(2,email);
                        pst.setString(3,pass);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registered Successfully");
                        pr1 = true;
                        if(pr1 && pr2){
                            dispose();
                            new Game(jb1.getText(),jb3.getText());
                        }

                    }catch (SQLException ex){

                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

                    }


                }

            }
        });
        //player 2
        n2=new JLabel("Name : ");
        n2.setForeground(Color.WHITE);

        c.add(n2);
        n2.setBounds(250,100,50,50);
        jb3 =new JTextField();
        jb3.setBackground(Color.BLACK);
        jb3.setForeground(Color.white);
        jb3.setBounds(300,100,150,40);
        c.add(jb3);
        e2=new JLabel("Email : ");
        e2.setForeground(Color.WHITE);

        e2.setBounds(250,150,50,50);
        c.add(e2);
        jb4 =new JTextField();
        jb4.setForeground(Color.white);
        jb4.setBackground(Color.BLACK);
        jb4.setBounds(300,150,150,40);
        c.add(jb4);
        pass2=new JLabel("Pass : ");        pass2.setForeground(Color.WHITE);

        pass2.setBounds(250,200,50,50);
        c.add(pass2);
        p2=new JPasswordField();
        p2.setBounds(300,200,150,40);
        p2.setBackground(Color.BLACK);
        p2.setForeground(Color.white);
        c.add(p2);
        jl2=new JButton("Register");
        jl2.setBackground(Color.BLACK);
        jl2.setForeground(Color.white);
        jl2.setBounds(330,250,100,40);
        c.add(jl2);
        jl2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p2name=jb3.getText(),email=jb4.getText();
                String pass=new String(p2.getPassword());
                if(p2name.isEmpty() || email.isEmpty() || pass.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Sorry , Try Again!");
                }else{  try {
                    Connection conn = DataBaseConnection.getConnection();
                    String sql = "INSERT INTO TicTacToeUsers(name,email,password)VALUES(?,?,?)";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1,p2name);
                    pst.setString(2,email);
                    pst.setString(3,pass);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Registered Successfully");
                    pr2 = true;
                    if(pr1 && pr2){
                        dispose();
                        new Game(jb1.getText(),jb3.getText());
                    }
                }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
                }

            }
        });

            }








}
