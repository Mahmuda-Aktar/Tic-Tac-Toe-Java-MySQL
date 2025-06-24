import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginPage extends JFrame {
     private Container c;
     private JLabel j1,j2,n1,n2,pass1,pass2,label1;
     private JTextField jb1,jb3;
     private JButton jb4,jl1,jl2;
     private ImageIcon icon,img;
     private Font f1,f2,f3;
     private JPasswordField p1,p2;
     private boolean pr1=false;
     private boolean pr2=false;
     LoginPage(){  this.setTitle("Login Form");
         this.setBounds(100,100,500,500);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         initComponents();
              this.setVisible(true);

     }
     public void initComponents(){
         c=this.getContentPane();
         c.setBackground(Color.BLACK);
         c.setLayout(null);

         f1=new Font("Arial",Font.BOLD,18);
         f1=new Font("Arial",Font.BOLD,14);

         try {
             icon = new ImageIcon(getClass().getResource("img.png"));
             this.setIconImage(icon.getImage());
         } catch (Exception e) {
             System.out.println("Icon not found");
         }

         j1=new JLabel("Player 1 ");
         j1.setBounds(120,50,100,50);
         j1.setFont(f1);         j1.setForeground(Color.WHITE);

         c.add(j1);
         j2=new JLabel("Player 2 ");
         j2.setBounds(330,50,100,50);
         j2.setForeground(Color.WHITE);
         j2.setFont(f1);
         c.add(j2);

         n1=new JLabel("Name : ");
         n1.setForeground(Color.WHITE);

         c.add(n1);
         n1.setBounds(30,100,50,50);
         jb1 =new JTextField();
         jb1.setBackground(Color.BLACK);
         jb1.setForeground(Color.WHITE);
         jb1.setBounds(80,100,150,40);
         c.add(jb1);

         pass1=new JLabel("Pass : ");
         pass1.setForeground(Color.WHITE);
         pass1.setBounds(30,150,50,50);
         c.add(pass1);
         p1=new JPasswordField();
         p1.setBounds(80,150,150,40);
         p1.setForeground(Color.white);
         p1.setBackground(Color.BLACK);
         c.add(p1);
         jl1=new JButton("Login");
         jl1.setBackground(Color.BLACK);
         jl1.setForeground(Color.white);
         jl1.setBounds(100,200,100,40);
         jl1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String name=jb1.getText();
                 String pass=new String(p1.getPassword());
                 if(validateLogin(name,pass)){
                     JOptionPane.showMessageDialog(null,"login Successfully");
                     pr1=true;if(pr1 && pr2){
                         dispose();
                         new Game(jb1.getText(),jb3.getText());
                     }

                 }else{
                     JOptionPane.showMessageDialog(null,"Sorry , Try Again!");
                     jb1.setText("");
                     p1.setText("");


                 }

             }
         });
         c.add(jl1);
         //player 2
         n2=new JLabel("Name : ");n2.setForeground(Color.WHITE);
         c.add(n2);
         n2.setBounds(250,100,50,50);
         jb3 =new JTextField();
         jb3.setBackground(Color.BLACK);
         jb3.setForeground(Color.white);
         jb3.setBounds(300,100,150,40);
         c.add(jb3);

         pass2=new JLabel("Pass : ");
         pass2.setForeground(Color.WHITE);
         pass2.setBounds(250,150,50,50);
         c.add(pass2);
         p2=new JPasswordField();
         p2.setBounds(300,150,150,40);
         p2.setBackground(Color.BLACK);
         p2.setForeground(Color.white);
         c.add(p2);
         jl2=new JButton("Login");
         jl2.setBackground(Color.BLACK);
         jl2.setForeground(Color.white);
         jl2.setBounds(330,200,100,40);
         c.add(jl2);
         jl2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String name=jb3.getText();
                 String pass=new String(p2.getPassword());
                 if(validateLogin(name,pass)){
                     JOptionPane.showMessageDialog(null,"Login Successfully");
                     pr2=true;
                     if(pr1 && pr2){
                         dispose();
                         new Game(jb1.getText(),jb3.getText());
                     }

                 }else{JOptionPane.showMessageDialog(null,"Sorry , Try Again!");
                     jb3.setText("");p2.setText("");

                 }

             }
         });


     }

    private boolean validateLogin(String name, String pass) {
        boolean valid = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DataBaseConnection.getConnection();
            String sql = "SELECT * FROM TicTacToeUsers WHERE name = ? AND password = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, pass);
            rs = pst.executeQuery();

            if (rs.next()) {
                valid = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                // ignore
            }
        }

        return valid;
    }

public static void main(String args[]){
         LoginPage frame=new LoginPage();
}

}
