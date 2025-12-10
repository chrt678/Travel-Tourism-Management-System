package tourismmanagementsystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver"); 
          c=DriverManager.getConnection("jdbc:mysql:///t2ms","root","@Ashish123");
          s=c.createStatement();
        }
        catch(Exception e){
            
        }
    }
    
}
