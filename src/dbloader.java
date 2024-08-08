 
import java.sql.*;
public class dbloader {
    public static ResultSet executeQuery(String str){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loading Done");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pos2024", "root","662003");
            System.out.println("Connection Done");
            
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Done");
            
            ResultSet rs = stmt.executeQuery(str);
            System.out.println("ResultSet Created"); 
            
            return rs;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
