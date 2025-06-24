import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public static Connection getConnection(){
     try {
         String driver="com.mysql.cj.jdbc.Driver";
         String databaseurl="jdbc:mysql://localhost:3306/TicTacToe";
         String username="root";
         String password="";
          Class.forName(driver);
          Connection conn= DriverManager.getConnection(databaseurl,username,password);
          System.out.println("database connection");
          return conn;
     }
     catch (Exception e){
         System.out.println(e);
     }
     return null;
    }
}
